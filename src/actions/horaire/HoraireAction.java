package actions.horaire;

import java.util.ArrayList;
import java.util.List;

import model.dao.ClassroomDAO;
import model.dao.ScheduleDAO;
import model.org.persistence.ClassroomEntity;
import model.org.persistence.ScheduleEntity;

import bean.ClassroomBean;
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
	
	public String update()
	{
		// Sauf si il y a erreur, le traitement est considéré comme étant un
		// succès
		forward = FORWARD_SUCCESS;
		ScheduleDAO scheduleDAO = new ScheduleDAO();
		try
		{
			ScheduleEntity ScheduleEntity = new ScheduleEntity();
			ScheduleEntity.setId(this.scheduleBean.getId());
			ScheduleEntity.setDayStart(this.scheduleBean.getDayStart());
			ScheduleEntity.setDayEnd(this.scheduleBean.getDayEnd());
			ScheduleEntity.setName(this.scheduleBean.getName());
			ScheduleEntity.setComment(this.scheduleBean.getComment());
			ScheduleEntity.setIdUserTeacher(this.scheduleBean.getIdUserTeacher());
			ScheduleEntity.setIdSubject(this.scheduleBean.getIdSubject());
			ScheduleEntity.setIdClassroom(this.scheduleBean.getIdClassroom());
			ScheduleEntity.setIdGroup(this.scheduleBean.getIdGroup());
			
			scheduleDAO.updateSchedule(ScheduleEntity);
		} catch (Exception e)
		{
			forward = FORWARD_ERROR;
		}
		return forward;
	}
	
	public String delete()
	{
		// Sauf si il y a erreur, le traitement est considéré comme étant un
		// succès
		forward = FORWARD_SUCCESS;
		ScheduleDAO scheduleDAO = new ScheduleDAO();
		try
		{
			ScheduleEntity scheduleEntity = scheduleDAO.getSchedule(this.id);
			scheduleDAO.removeSchedule(scheduleEntity);
		} catch (Exception e)
		{
			forward = FORWARD_ERROR;
		}
		return forward;
	}
	
	public String showSchedule()
	{
		forward = FORWARD_SUCCESS;
		ScheduleDAO scheduleDAO = new ScheduleDAO();
		this.listScheduleBean = new ArrayList<ScheduleBean>();
		try
		{
			List<ScheduleEntity> listScheduleEntity = scheduleDAO.getAllSchedule();
			for (ScheduleEntity scheduleEntity : listScheduleEntity)
			{
				ScheduleBean scheduleBean = new ScheduleBean();
				scheduleBean.setId(scheduleEntity.getId());
				scheduleBean.setDayStart(scheduleEntity.getDayStart());
				scheduleBean.setDayEnd(scheduleEntity.getDayEnd());
				scheduleBean.setName(scheduleEntity.getName());
				scheduleBean.setComment(scheduleEntity.getComment());
				scheduleBean.setIdUserTeacher(scheduleEntity.getIdUserTeacher());
				scheduleBean.setIdSubject(scheduleEntity.getIdSubject());
				scheduleBean.setIdClassroom(scheduleEntity.getIdClassroom());
				scheduleBean.setIdGroup(scheduleEntity.getIdGroup());
				this.listScheduleBean.add(scheduleBean);
			}
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
