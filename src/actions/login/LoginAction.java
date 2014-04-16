package actions.login;


import model.dao.UserDAO;
import model.org.persistence.UserEntity;

import actions.abstractAction.AbstractAction;
import bean.UserBean;

/**
 * Action de connexion
 * @author mickael
 *
 */
public class LoginAction extends AbstractAction
{
	//Serialization
	private static final long serialVersionUID = 1L;
	//bean de formulaire permettant le transfere des informations
	private UserBean userBean;
	//déclaration et initialisation du DAO
	private UserDAO udao = new UserDAO();

	/**
	 * Execution l'inscription en sauvegardant le user
	 */
	public String execute()
	{
		forward=FORWARD_SUCCESS;
		UserEntity user=udao.getUserByEmailAndPwd(userBean.getEmail(), userBean.getPassword());
		
		//Si le user n'existe pas c'est qu'il y a une erreur d'authentification
		if(user==null)
		{
			addActionError(getText("validator.not.register"));
			forward=FORWARD_INPUT;
		}
		else
		{
			convertEntityToBean(user, userBean);
			session.put("user", userBean);
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
	 * Méthode de conversion avec un userEntity en entrée et un userBean en sortie
	 * @param UserEntity, UserBean
	 */
	private void convertEntityToBean(UserEntity userToConvert, UserBean userResult)
	{
		userResult.setId(userToConvert.getId());
		userResult.setEmail(userToConvert.getEmail());
		userResult.setName(userToConvert.getName());
		userResult.setNameGroup(userToConvert.getGroupe().getName());
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
