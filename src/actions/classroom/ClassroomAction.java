package actions.classroom;

import java.util.Map;

import model.dao.ClassroomDAO;

import org.apache.struts2.interceptor.SessionAware;

import transitionObject.bean.ClassroomBean;

import com.opensymphony.xwork2.ActionSupport;


public class ClassroomAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	//forward pour rediriger vers la bonne page
	private String forward;
	//variable de session
	private Map<String, Object> session;
	//bean de formulaire permettant le transfere des informations
	private ClassroomBean classroomBean;
	
	
	/**
	 * Execution l'inscription en sauvegardant le user
	 */
	public String execute()
	{
		//Sauf si il y a erreur, le traitement est considéré comme étant un succès
		forward="SUCCESS";
		ClassroomDAO classroomDao = new ClassroomDAO();
		try
		{
			//Sauvegarde du user renseigné dans le formulaire
			classroomDao.addClassroom(classroomBean.getName());
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
		//test si le mail est renseigné
		if("".equals(classroomBean.getName()))
		{
			addFieldError("error.name", getText("validator.field.empty"));
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
	public ClassroomBean getClassroomBean() 
	{
		return classroomBean;
	}

	public void setClassroomBean(ClassroomBean classroomBean) 
	{
		this.classroomBean = classroomBean;
	}
}
