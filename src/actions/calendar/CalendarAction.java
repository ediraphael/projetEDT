package actions.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

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
	private Long view;
	private TreeMap<Long,String> listView = new TreeMap<Long,String>();

	// bean de formulaire permettant le transfere des informations
	private ScheduleBean scheduleBean;
	private ArrayList<ScheduleBean> listScheduleBean;

	// déclaration et initialisation des DAO
	private GroupDAO gdao = new GroupDAO();
	private ClassroomDAO cdao = new ClassroomDAO();
	private UserDAO udao = new UserDAO();
	private SubjectDAO sdao = new SubjectDAO();
	private ScheduleDAO scdao = new ScheduleDAO();


	// déclaration des liste a afficher dans les liste déroulantes
	private TreeMap<Long, String> mapGroup;
	private TreeMap<Long, String> mapClassroom;
	private TreeMap<Long, String> mapTeacher;
	private TreeMap<Long, String> mapSubject;

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
		this.listView = new TreeMap<Long,String>();
		this.listView.put(NORMAL,getText("label.type.calendar.normal"));
		this.listView.put(COMPACT, getText("label.type.calendar.compact"));
		this.listView.put(RESUME,getText("label.type.calendar.resume"));
		this.listScheduleBean = new ArrayList<ScheduleBean>();
		try
		{
			List<ScheduleEntity> listScheduleEntity;
			GroupEntity group;
			if (this.scheduleBean != null && this.scheduleBean.getIdGroup() != 0)
			{
				group = this.gdao.getById(this.scheduleBean.getIdGroup());
			} else
			{
				group = this.gdao.getById(1);
				UserBean user = (UserBean) session.get(USER);
				if (user != null)
				{
					group = this.gdao.getById(user.getIdGroup());
					this.scheduleBean = new ScheduleBean();
					this.scheduleBean.setIdGroup(user.getIdGroup());
				}

			}

			if (this.dayMin == null || "".equals(this.dayMin))
			{
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
				this.dayMin = SIMPLE_DATE_FORMAT.format(date);
			}
			if (this.dayMax == null || "".equals(this.dayMax))
			{
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
				this.dayMax = SIMPLE_DATE_FORMAT.format(date);
			}
			if(group.getId()==GROUP_ID_TEACHER || group.getId()==GROUP_ID_ETU)
			{
				listScheduleEntity = scdao.getAllByGroupAndDay(group, this.dayMin, this.dayMax);
			}
			else
			{
				GroupEntity groupEtu=gdao.getById(GROUP_ID_ETU);
				listScheduleEntity = scdao.getAllByGroupAndDayWithEtu(group,groupEtu, this.dayMin, this.dayMax);
			}
			
			if (listScheduleEntity == null)
			{
				listScheduleEntity = new ArrayList<>();
			}
			for (ScheduleEntity scheduleEntity : listScheduleEntity)
			{
				ScheduleBean scheduleBean = new ScheduleBean();
				scheduleBean.convertEntityToBean(scheduleEntity);
				scheduleBean.setMapGroup(gdao.getAllGroupForMap());
				scheduleBean.setMapClassroom(cdao.getAllClassroomForMap());
				scheduleBean.setMapSubject(sdao.getAllSubjectForMap());
				scheduleBean.setMapTeacher(udao.getAllTeacherForMap());
				this.listScheduleBean.add(scheduleBean);
			}
			this.mapGroup = this.gdao.getAllGroupForMap();
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
		this.mapGroup = this.gdao.getAllGroupForMap();
		this.mapClassroom = this.cdao.getAllClassroomForMap();
		this.mapTeacher = this.udao.getAllTeacherForMap();
		this.mapSubject = this.sdao.getAllSubjectForMap();
		scheduleBean.setMapGroup(gdao.getAllGroupForMap());
		scheduleBean.setMapClassroom(cdao.getAllClassroomForMap());
		scheduleBean.setMapSubject(sdao.getAllSubjectForMap());
		scheduleBean.setMapTeacher(udao.getAllTeacherForMap());
	}

	/**
	 * Getters and setters
	 * 
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

	public Long getView()
	{
		return view;
	}

	public void setView(Long view)
	{
		this.view = view;
	}


	public long getDefaultViewValue()
	{
		if (this.view != null && this.view!=0)
		{
			return this.view;
		} 
		else
		{
			return 0l;
		}
	}

	public TreeMap<Long, String> getMapGroup() 
	{
		return mapGroup;
	}

	public void setMapGroup(TreeMap<Long, String> mapGroup) 
	{
		this.mapGroup = mapGroup;
	}

	public TreeMap<Long, String> getMapClassroom() 
	{
		return mapClassroom;
	}

	public void setMapClassroom(TreeMap<Long, String> mapClassroom) 
	{
		this.mapClassroom = mapClassroom;
	}

	public TreeMap<Long, String> getMapTeacher() 
	{
		return mapTeacher;
	}

	public void setMapTeacher(TreeMap<Long, String> mapTeacher) 
	{
		this.mapTeacher = mapTeacher;
	}

	public TreeMap<Long, String> getMapSubject() 
	{
		return mapSubject;
	}

	public void setMapSubject(TreeMap<Long, String> mapSubject)
	{
		this.mapSubject = mapSubject;
	}

	public TreeMap<Long, String> getListView() 
	{
		return listView;
	}

	public void setListView(TreeMap<Long, String> listView) 
	{
		this.listView = listView;
	}
}
