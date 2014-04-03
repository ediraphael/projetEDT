package actions.horaire;

import java.util.List;
import java.util.Map;

import model.dao.ScheduleDAO;
import model.org.persistence.ScheduleEntity;

import org.apache.struts2.interceptor.SessionAware;

import bean.ScheduleBean;

import com.opensymphony.xwork2.ActionSupport;

public class HoraireAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//forward pour rediriger vers la bonne page
	private String forward;
	//variable de session
	private Map<String, Object> session;
	
	private ScheduleBean scheduleBean;

	/**
	 * Execution de l'ajout d'un horaire
	 */
	public String execute()
	{
		//Sauf si il y a erreur, le traitement est considéré comme étant un succès
		forward = "SUCCESS";
		try
		{
			ScheduleDAO scheduleDAO = new ScheduleDAO();
			List<ScheduleEntity> schedules = scheduleDAO.getAllSchedule();
		}
		catch(Exception e)
		{
			forward="ERROR";
		}
		return forward;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public Map<String, Object> getSession() 
	{
		return session;
	}

}
