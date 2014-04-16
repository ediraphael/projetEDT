package actions.calendar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
	private String view;
	private ArrayList<String> listView = new ArrayList<String>();

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
		this.listView = new ArrayList<String>();
		this.listView.add(getText("label.type.calendar.normal"));
		this.listView.add(getText("label.type.calendar.compact"));
		this.listView.add(getText("label.type.calendar.resume"));
		ScheduleDAO scheduleDAO = new ScheduleDAO();
		this.listScheduleBean = new ArrayList<ScheduleBean>();
		try
		{
			List<ScheduleEntity> listScheduleEntity;
			GroupEntity group;
			if (this.scheduleBean != null && this.scheduleBean.getNameGroup() != null)
			{
				group = this.groupDao.getGroupByName(this.scheduleBean.getNameGroup());
			} else
			{
				group = this.groupDao.getById(1);
				UserBean user = (UserBean) session.get("user");
				if (user != null)
				{
					group = this.groupDao.getGroupByName(user.getNameGroup());
					this.scheduleBean = new ScheduleBean();
					this.scheduleBean.setNameGroup(user.getNameGroup());
				}

			}

			if (this.dayMin == null || "".equals(this.dayMin))
			{
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());

				int week = cal.get(Calendar.WEEK_OF_YEAR);
				int year = cal.get(Calendar.YEAR);

				// Get calendar, clear it and set week number and year.
				Calendar calendar = Calendar.getInstance();
				calendar.clear();
				calendar.set(Calendar.WEEK_OF_YEAR, week);
				calendar.set(Calendar.YEAR, year);
				// Now get the first day of week.
				Date date = calendar.getTime();
				this.dayMin = simpleDateFormat.format(date);
			}
			if (this.dayMax == null || "".equals(this.dayMax))
			{
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());

				int week = cal.get(Calendar.WEEK_OF_YEAR);
				int year = cal.get(Calendar.YEAR);

				// Get calendar, clear it and set week number and year.
				Calendar calendar = Calendar.getInstance();
				calendar.clear();
				calendar.set(Calendar.YEAR, year);
				calendar.set(Calendar.WEEK_OF_YEAR, week);
				calendar.set(Calendar.DAY_OF_WEEK, 8);
				Date date = calendar.getTime();
				this.dayMax = simpleDateFormat.format(date);
			}
			listScheduleEntity = scheduleDAO.getAllByGroupAndDay(group, this.dayMin, this.dayMax);
			if (listScheduleEntity == null)
			{
				listScheduleEntity = new ArrayList<>();
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
				scheduleBean.setColorSubject(scheduleEntity.getSubject().getColor());
				this.listScheduleBean.add(scheduleBean);
			}
			this.arrayGroupName = this.groupDao.getAllGroupName();
		} catch (Exception e)
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

	public String getView()
	{
		return view;
	}

	public void setView(String view)
	{
		this.view = view;
	}

	public ArrayList<String> getListView()
	{
		return listView;
	}

	public void setListView(ArrayList<String> listView)
	{
		this.listView = listView;
	}

	public String getDefaultViewValue()
	{
		if (this.view != null && !"".equals(this.view))
		{
			return this.view;
		} else
		{
			return this.listView.get(0);
		}
	}
}
