package actions.inscription;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.dao.UserDAO;

import actions.abstractAction.AbstractAction;
import bean.UserBean;

public class InscriptionAction extends AbstractAction
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
		forward=FORWARD_SUCCESS;
		UserDAO udao = new UserDAO();
		try
		{
			//Sauvegarde du user renseigné dans le formulaire
			udao.addUser(userBean.getEmail(), userBean.getPassword(), 1);
			
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
		//test si le mail est renseigné
		if("".equals(userBean.getEmail()))
		{
			addFieldError("error.email", getText("validator.field.empty"));
		}
		
		//test si le user est renseigné
		if("".equals(userBean.getPassword()))
		{
			addFieldError("error.password", getText("validator.field.empty"));
		}
		
		if(!emailValidator(userBean.getEmail()))
		{
			addFieldError("error.password", getText("validator.mail.false"));
		}
	}

	private boolean emailValidator(String email) 
	{
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
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
