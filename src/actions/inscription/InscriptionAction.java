package actions.inscription;

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
			userToSave.setIdGroupe(1);
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
