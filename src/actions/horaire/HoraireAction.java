package actions.horaire;

import java.util.ArrayList;

import model.dao.ClassroomDAO;
import model.dao.ScheduleDAO;

import bean.ScheduleBean;
import actions.abstractAction.AbstractAction;

public class HoraireAction extends AbstractAction
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private ScheduleBean scheduleBean;
	private ArrayList<ScheduleBean> listScheduleBean;

	/**
	 * Execution de l'ajout d'un horaire
	 */
	public String execute()
	{
		// Sauf si il y a erreur, le traitement est considéré comme étant un
		// succès
		forward = FORWARD_SUCCESS;
		ScheduleDAO scheduleDAO = new ScheduleDAO();
		try
		{
			// Sauvegarde du user renseigné dans le formulaire
			scheduleDAO.addSchedule(scheduleBean.getDayStart(), scheduleBean.getDayEnd(), scheduleBean.getName(), scheduleBean.getComment(), scheduleBean.getIdUserTeacher(), scheduleBean.getIdSubject(), scheduleBean.getIdClassroom(), scheduleBean.getIdGroup());
		} catch (Exception e)
		{
			forward = FORWARD_ERROR;
		}
		return forward;
	}

	/**
	 * Getters and setters
	 * 
	 * @return
	 */
	public ScheduleBean getScheduleBean()
	{
		return scheduleBean;
	}

	public void setScheduleBean(ScheduleBean scheduleBean)
	{
		this.scheduleBean = scheduleBean;
	}

	public ArrayList<ScheduleBean> getListScheduleBean()
	{
		return listScheduleBean;
	}

	public void setListScheduleBean(ArrayList<ScheduleBean> listScheduleBean)
	{
		this.listScheduleBean = listScheduleBean;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}
}
