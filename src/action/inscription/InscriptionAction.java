package action.inscription;

import java.util.Map;

import model.dao.UserDAO;

import org.apache.struts2.interceptor.SessionAware;

import bean.UserBean;

import com.opensymphony.xwork2.ActionSupport;


public class InscriptionAction extends ActionSupport implements SessionAware
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
		//Sauf si il y a erreur, le traitement est considéré comme étant un succès
		forward="SUCCESS";
		UserDAO udao = new UserDAO();
		try
		{
			//Sauvegarde du user renseigné dans le formulaire
			udao.addUser(userBean.getEmail(), userBean.getPassword());
		}
		catch(Exception e)
		{
			forward="ERROR";
		}
		return forward;
	}


	/**
	 * Méthode permetant la validation des champs 
	 */
	public void validate()
	{

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
