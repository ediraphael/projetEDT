package actions.horaire;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import model.dao.ClassroomDAO;
import model.dao.GroupDAO;
import model.dao.ScheduleDAO;
import model.dao.UserDAO;
import model.org.persistence.ScheduleEntity;
import actions.abstractAction.AbstractAction;
import bean.ScheduleBean;

public class HoraireAction extends AbstractAction
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private ScheduleBean scheduleBean;
	private ArrayList<ScheduleBean> listScheduleBean;
	//déclaration et initialisation des DAO
	private GroupDAO groupDao = new GroupDAO();
	private ClassroomDAO classroomDao = new ClassroomDAO();
	private UserDAO userDao = new UserDAO();
	private List<String> arrayGroupName;
	private List<String> arrayClassroomName;
	private List<String> arrayUserTeacherName;
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
			ScheduleEntity scheduleEntity = new ScheduleEntity();
			scheduleEntity.setDayStart(this.scheduleBean.getDayStart());
			scheduleEntity.setDayEnd(this.scheduleBean.getDayEnd());
			scheduleEntity.setName(this.scheduleBean.getName());
			scheduleEntity.setComment(this.scheduleBean.getComment());
			//scheduleEntity.setIdUserTeacher(this.scheduleBean.getIdUserTeacher());
			scheduleEntity.setIdSubject(this.scheduleBean.getIdSubject());
			scheduleEntity.setIdClassroom(this.classroomDao.getClassroomByName(this.scheduleBean.getNameClassroom()));
			scheduleEntity.setGroup(this.groupDao.getGroupByName(this.scheduleBean.getNameGroup()));
			
			scheduleDAO.addSchedule(scheduleEntity);
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
			ScheduleEntity scheduleEntity = new ScheduleEntity();
			scheduleEntity.setId(this.scheduleBean.getId());
			scheduleEntity.setDayStart(this.scheduleBean.getDayStart());
			scheduleEntity.setDayEnd(this.scheduleBean.getDayEnd());
			scheduleEntity.setName(this.scheduleBean.getName());
			scheduleEntity.setComment(this.scheduleBean.getComment());
			//scheduleEntity.setIdUserTeacher(this.scheduleBean.getIdUserTeacher());
			scheduleEntity.setIdSubject(this.scheduleBean.getIdSubject());
			scheduleEntity.setIdClassroom(this.classroomDao.getClassroomByName(this.scheduleBean.getNameClassroom()));
			scheduleEntity.setGroup(this.groupDao.getGroupByName(this.scheduleBean.getNameGroup()));
			
			scheduleDAO.updateSchedule(scheduleEntity);
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
				//scheduleBean.setIdUserTeacher(scheduleEntity.getIdUserTeacher());
				scheduleBean.setIdSubject(scheduleEntity.getIdSubject());
				scheduleBean.setIdClassroom(scheduleEntity.getClassroom().getName());
				scheduleBean.setNameGroup(scheduleEntity.getGroup().getName());
				this.listScheduleBean.add(scheduleBean);
			}
		} catch (Exception e)
		{
			forward = FORWARD_ERROR;
		}
		return forward;
	}
	
	/**
	 * Méthode permettant de lancer la page d'ajout d'horaire en initialisant la liste des groupes
	 * @return
	 */
	@SkipValidation 
	public String openHoraireForm()
	{
		forward=FORWARD_SUCCESS;
		this.arrayGroupName=this.groupDao.getAllGroupName();
		this.arrayClassroomName=this.classroomDao.getAllClassroomName();
		//this.arrayUserTeacherName
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
	
	public List<String> getArrayGroupName() 
	{
		return arrayGroupName;
	}

	public void setArrayGroupName(List<String> arrayGroupName) 
	{
		this.arrayGroupName = arrayGroupName;
	}
	
	public List<String> getArrayClassroomName() 
	{
		return arrayClassroomName;
	}

	public void setArrayClassroomName(List<String> arrayClassroomName) 
	{
		this.arrayClassroomName = arrayClassroomName;
	}
}
