package actions.inscription;

import org.apache.struts2.interceptor.validation.SkipValidation;

import model.dao.GroupDAO;
import model.dao.PasswordTeacherDAO;
import model.dao.UserDAO;
import model.org.persistence.UserEntity;
import actions.abstractAction.AbstractAction;
import bean.UserBean;


/**
 * Action d'inscription
 * @author mickael
 *
 */
public class InscriptionAction extends AbstractAction
{
	//Serialization
	private static final long serialVersionUID = 1L;
	//bean de formulaire permettant le transfere des informations
	private UserBean userBean;
	
	//déclaration et initialisation des DAO
	private GroupDAO gdao = new GroupDAO();
	private UserDAO udao = new UserDAO();
	private PasswordTeacherDAO pdao = new PasswordTeacherDAO();
	
	//mot de passe pour les enregistrement directement en groupe prof
	private String pwdTeacher;
	
	
	/**
	 * Execution l'inscription en sauvegardant le user
	 */
	public String execute()
	{
		forward=FORWARD_SUCCESS;
		try
		{
			//On prépare l'enregistrement en reprenant les informations bean
			UserEntity userToSave = new UserEntity();
			userToSave.setFirstName(userBean.getFirstName());
			userToSave.setName(userBean.getName());
			userToSave.setEmail(userBean.getEmail());
			userToSave.setPassword(userBean.getPassword());
			userToSave.setGroupe(gdao.getGroupByName(userBean.getNameGroup()));
			//Sauvegarde du user renseigné dans le formulaire
			udao.addUser(userToSave);
			
			session.put("user", userBean);
		}
		catch(Exception e)
		{
			forward=FORWARD_ERROR;
		}
		return forward;
	}

	/**
	 * Méthode permettant de lancer la page d'inscription en initialisant la liste des groupes
	 * 
	 */
	@SkipValidation 
	public String openInscriptionForm()
	{
		forward=FORWARD_SUCCESS;
		userBean=new UserBean();
		//pour ouvrir le formulaire d'inscription il faut charger la liste des groupes existant
		userBean.setArrayGroupName(gdao.getAllGroupName());
		//De meme, il faut récupérer le password prof pour le test lors de l'inscription
		pwdTeacher=pdao.getPasswordTeacher();
		return forward;
	}

	/**
	 * Méthode permettant la validation des champs 
	 */
	public void validate()
	{
		//test si le prénom est renseigné
		if(userBean.getFirstName().isEmpty())
		{
			addFieldError("error.firstName", getText("validator.field.empty"));
		}
		
		//test si le nom est renseigné
		if(userBean.getName().isEmpty())
		{
			addFieldError("error.name", getText("validator.field.empty"));
		}
		
		//test si le mail est renseigné
		if(userBean.getEmail().isEmpty())
		{
			addFieldError("error.email", getText("validator.field.empty"));
		}
		
		//test si le password est renseigné
		if(userBean.getPassword().isEmpty())
		{
			addFieldError("error.password", getText("validator.field.empty"));
		}
		
		//test si l'email est correctement renseigné
		if(!emailValidator(userBean.getEmail()))
		{
			addFieldError("error.password", getText("validator.mail.false"));
		}

		//test si la confirmation est correcte
		if(!userBean.getPassword().equals(userBean.getConfirmPassword()))
		{
			addFieldError("error.confirmpassword", getText("validator.pwd.confirm"));
		}
		
		//test si le groupe choisi est Enseignant, alors il faut le mot de passe d'inscription
		if(GROUP_NAME_TEACHER.equals(userBean.getNameGroup()))
		{
			if(userBean.getPasswordTeacher().isEmpty())
			{
				addFieldError("error.teacherpassword", getText("validator.field.empty"));
			}
			else if(!userBean.getPasswordTeacher().equals(pwdTeacher))
			{
				addFieldError("error.teacherpassword", getText("validator.pwd.false"));
			}
		}
		//rechargement de la liste des groupe pour réafficher la page des inscriptions
		userBean.setArrayGroupName(gdao.getAllGroupName());
	}



	/**
	 * Getters and setters
	 * @return
	 */
	public UserBean getUserBean() 
	{
		return userBean;
	}

	public void setUserBean(UserBean userBean) 
	{
		this.userBean = userBean;
	}
}
