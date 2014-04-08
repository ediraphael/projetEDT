package actions.inscription;

import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import model.dao.GroupDAO;
import model.dao.UserDAO;
import model.org.persistence.UserEntity;
import actions.abstractAction.AbstractAction;
import bean.UserBean;

public class InscriptionAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;
	//forward pour rediriger vers la bonne page
	private String forward;
	//bean de formulaire permettant le transfere des informations
	private UserBean userBean;
	
	private List<String> arrayGroupName;
	
	
	/**
	 * Execution l'inscription en sauvegardant le user
	 */
	public String execute()
	{
		forward=FORWARD_SUCCESS;
		UserDAO udao = new UserDAO();
		try
		{
			UserEntity userToSave = new UserEntity();
			userToSave.setFirstName(userBean.getFirstName());
			userToSave.setName(userBean.getName());
			userToSave.setEmail(userBean.getEmail());
			userToSave.setPassword(userBean.getPassword());
			//userToSave.setIdGroupe(1);
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

	@SkipValidation 
	public String openInscriptionForm()
	{
		forward=FORWARD_SUCCESS;
		GroupDAO gdao = new GroupDAO();
		arrayGroupName=gdao.getAllGroupName();
		return forward;
	}

	/**
	 * Méthode permetant la validation des champs 
	 */
	public void validate()
	{
		//test si le nom est renseigné
		if("".equals(userBean.getName()))
		{
			addFieldError("error.name", getText("validator.field.empty"));
		}
		
		//test si le mail est renseigné
		if("".equals(userBean.getEmail()))
		{
			addFieldError("error.email", getText("validator.field.empty"));
		}
		
		//test si le password est renseigné
		if("".equals(userBean.getPassword()))
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
			addFieldError("error.confirmpassword", getText("validator.mail.false"));
		}
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

	public List<String> getArrayGroupName() 
	{
		return arrayGroupName;
	}

	public void setArrayGroupName(List<String> arrayGroupName) 
	{
		this.arrayGroupName = arrayGroupName;
	}
}
