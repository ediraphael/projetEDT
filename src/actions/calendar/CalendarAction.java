package actions.calendar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.dao.ClassroomDAO;
import model.dao.GroupDAO;
import model.dao.ScheduleDAO;
import model.dao.SubjectDAO;
import model.dao.UserDAO;
import model.org.persistence.GroupEntity;
import model.org.persistence.ScheduleEntity;

import org.apache.struts2.interceptor.validation.SkipValidation;

import actions.abstractAction.AbstractAction;
import bean.ScheduleBean;
import bean.UserBean;

public class CalendarAction extends AbstractAction
{
	// Serialization
	private static final long serialVersionUID = 1L;
	private long id;
	private String dayMin;
	private String dayMax;

	// bean de formulaire permettant le transfere des informations
	private ScheduleBean scheduleBean;
	private ArrayList<ScheduleBean> listScheduleBean;

	// déclaration et initialisation des DAO
	private GroupDAO groupDao = new GroupDAO();
	private ClassroomDAO classroomDao = new ClassroomDAO();
	private UserDAO userDao = new UserDAO();
	private SubjectDAO subjectDao = new SubjectDAO();
	
	// déclaration des liste a afficher dans les liste déroulantes
	private List<String> arrayGroupName;
	private List<String> arrayClassroomName;
	private List<String> arrayUserTeacherName;
	private List<String> arraySubjectName;

	/**
	 * Execution de l'ajout d'un horaire
	 */
	public String execute()
	{
		return showSchedule();
	}

	/**
	 * Méthode permettant d'afficher les horaires
	 * 
	 * @return
	 */
	@SkipValidation
	public String showSchedule()
	{
		forward = FORWARD_SUCCESS;
		ScheduleDAO scheduleDAO = new ScheduleDAO();
		this.listScheduleBean = new ArrayList<ScheduleBean>();
		try
		{
			List<ScheduleEntity> listScheduleEntity;
			if (this.scheduleBean != null && this.scheduleBean.getNameGroup() != null)
			{
				GroupEntity group = this.groupDao.getGroupByName(this.scheduleBean.getNameGroup());
				listScheduleEntity = scheduleDAO.getAllByGroup(group);
				if (listScheduleEntity == null)
				{
					listScheduleEntity = new ArrayList<>();
				}
			} 
			else
			{
				GroupEntity group = this.groupDao.getById(1);
				UserBean user = (UserBean) session.get("user");
				if (user != null)
				{
					group = this.groupDao.getGroupByName(user.getNameGroup());
					this.scheduleBean = new ScheduleBean();
					this.scheduleBean.setNameGroup(user.getNameGroup());
				}
				listScheduleEntity = scheduleDAO.getAllByGroup(group);
				if (listScheduleEntity == null)
				{
					listScheduleEntity = new ArrayList<>();
				}
			}
			for (ScheduleEntity scheduleEntity : listScheduleEntity)
			{
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				ScheduleBean scheduleBean = new ScheduleBean();
				scheduleBean.setId(scheduleEntity.getId());
				scheduleBean.setDayStart(simpleDateFormat.format(simpleDateFormat.parse(scheduleEntity.getDayStart())));
				scheduleBean.setDayEnd(simpleDateFormat.format(simpleDateFormat.parse(scheduleEntity.getDayEnd())));
				scheduleBean.setName(scheduleEntity.getName());
				scheduleBean.setComment(scheduleEntity.getComment());
				scheduleBean.setNameUserTeacher(scheduleEntity.getUserTeacher().getName());
				scheduleBean.setSubject(scheduleEntity.getSubject().getName());
				scheduleBean.setClassroom(scheduleEntity.getClassroom().getName());
				scheduleBean.setNameGroup(scheduleEntity.getGroup().getName());
				this.listScheduleBean.add(scheduleBean);
			}
			this.arrayGroupName = this.groupDao.getAllGroupName();
		} 
		catch (Exception e)
		{
			forward = generateError(e);
		}
		return forward;
	}

	/**
	 * Méthode permettant de valider les champs du formulaire
	 */
	public void validate()
	{
		this.arrayGroupName = this.groupDao.getAllGroupName();
		this.arrayClassroomName = this.classroomDao.getAllClassroomName();
		this.arrayUserTeacherName = this.userDao.getAllUserNameByGroup(this.groupDao.getGroupByName("Enseignant"));
		this.arraySubjectName = this.subjectDao.getAllSubjectName();
		scheduleBean.setArrayGroupName(groupDao.getAllGroupName());
		scheduleBean.setArrayClassroomName(classroomDao.getAllClassroomName());
		scheduleBean.setArraySubjectName(subjectDao.getAllSubjectName());
		scheduleBean.setArrayUserTeacher(userDao.getAllUserNameByGroup(groupDao.getGroupByName("Enseignant")));
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

	public List<String> getArrayUserTeacherName()
	{
		return arrayUserTeacherName;
	}

	public void setArrayUserTeacherName(List<String> arrayUserTeacherName)
	{
		this.arrayUserTeacherName = arrayUserTeacherName;
	}

	public List<String> getArraySubjectName()
	{
		return arraySubjectName;
	}

	public void setArraySubjectName(List<String> arraySubjectName)
	{
		this.arraySubjectName = arraySubjectName;
	}

	public String getDayMin()
	{
		return dayMin;
	}

	public void setDayMin(String dayMin)
	{
		this.dayMin = dayMin;
	}

	public String getDayMax()
	{
		return dayMax;
	}

	public void setDayMax(String dayMax)
	{
		this.dayMax = dayMax;
	}
	
}
