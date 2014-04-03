package actions.login;

import java.util.Map;

import model.dao.UserDAO;
import model.org.persistence.UserEntity;

import org.apache.struts2.interceptor.SessionAware;

import bean.UserBean;

import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	//forward pour rediriger vers la bonne page
	private String forward;
	//variable de session
	private Map<String, Object> session;
	//bean de formulaire permettant le transfere des informations
	private UserBean userBean;

	/**
	 * Execution l'inscription en sauvegardant le user
	 */
	public String execute()
	{
		forward="SUCCESS";
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
			forward="input";
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


	@Override
	public void setSession(Map<String, Object> session) 
	{
		this.session=session;
	}

	public Map<String, Object> getSession() 
	{
		return session;
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
