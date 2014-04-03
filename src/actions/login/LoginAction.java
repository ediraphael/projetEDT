package actions.login;


import model.dao.UserDAO;
import model.org.persistence.UserEntity;

import actions.abstractAction.AbstractAction;
import bean.UserBean;


public class LoginAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;

	//bean de formulaire permettant le transfere des informations
	private UserBean userBean;

	/**
	 * Execution l'inscription en sauvegardant le user
	 */
	public String execute()
	{
		forward=FORWARD_SUCCESS;
		UserDAO udao = new UserDAO();
		UserEntity user=udao.getUserByEmailAndPwd(userBean.getEmail(), userBean.getPassword());
		
		if(user!=null)
		{
			//TODO mettre en session
		}
		//sinon on indique au user qu'il s'est trompé d'identifiant ou de mot de passe
		else
		{
			addActionError(getText("validator.not.register"));
			forward=FORWARD_INPUT;
		}
		
		return forward;
	}


	/**
	 * Méthode permetant la validation des champs 
	 */
	public void validate()
	{
		if("".equals(userBean.getEmail()))
		{
			addFieldError("error.email", getText("validator.field.empty"));
		}

		if("".equals(userBean.getPassword()))
		{
			addFieldError("error.password", getText("validator.field.empty"));
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
