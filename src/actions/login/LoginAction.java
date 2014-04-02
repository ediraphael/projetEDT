package actions.login;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import transitionObject.bean.UserBean;

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
		//TODO
		return forward;
	}


	/**
	 * Méthode permetant la validation des champs 
	 */
	public void validate()
	{
		//TODO
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
