package actions.schedule;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.dao.ClassroomDAO;
import model.dao.GroupDAO;
import model.dao.ScheduleDAO;
import model.dao.SubjectDAO;
import model.dao.UserDAO;
import model.org.persistence.ScheduleEntity;

import org.apache.struts2.interceptor.validation.SkipValidation;

import actions.abstractAction.AbstractAction;
import bean.ScheduleBean;

public class ScheduleAction extends AbstractAction
{
	//Serialization
	private static final long serialVersionUID = 1L;
	private long id;
	
	//bean de formulaire permettant le transfere des informations
	private ScheduleBean scheduleBean;
	private ArrayList<ScheduleBean> listScheduleBean;
	
	// déclaration et initialisation des DAO
	private GroupDAO groupDao = new GroupDAO();
	private ClassroomDAO classroomDao = new ClassroomDAO();
	private UserDAO userDao = new UserDAO();
	private SubjectDAO subjectDao = new SubjectDAO();
	private List<String> arrayGroupName;
	private List<String> arrayClassroomName;
	private List<String> arrayUserTeacherName;
	private List<String> arraySubjectName;

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
			scheduleEntity.setUserTeacher(this.userDao.getUserByName(this.scheduleBean.getNameUserTeacher()));
			scheduleEntity.setSubject(this.subjectDao.getSubjectByName(this.scheduleBean.getNameSubject()));
			scheduleEntity.setClassroom(this.classroomDao.getClassroomByName(this.scheduleBean.getNameClassroom()));
			scheduleEntity.setGroup(this.groupDao.getGroupByName(this.scheduleBean.getNameGroup()));

			scheduleDAO.addSchedule(scheduleEntity);
		} catch (Exception e)
		{
			forward = FORWARD_ERROR;
		}
		return forward;
	}

	/**
	 * Méthode permettant d'update une horaire
	 * 
	 */
	public String updateSchedule()
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
			scheduleEntity.setUserTeacher(this.userDao.getUserByName(this.scheduleBean.getNameUserTeacher()));
			scheduleEntity.setSubject(this.subjectDao.getSubjectByName(this.scheduleBean.getNameSubject()));
			scheduleEntity.setClassroom(this.classroomDao.getClassroomByName(this.scheduleBean.getNameClassroom()));
			scheduleEntity.setGroup(this.groupDao.getGroupByName(this.scheduleBean.getNameGroup()));

			scheduleDAO.updateSchedule(scheduleEntity);
		} catch (Exception e)
		{
			e.printStackTrace();
			forward = FORWARD_ERROR;
		}
		return forward;
	}

	/**
	 * Méthode permettant de supprimer un horaire
	 * 
	 */
	@SkipValidation
	public String deleteSchedule()
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

	/**
	 * Méthode permettant d'afficher les horaires
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
			List<ScheduleEntity> listScheduleEntity = scheduleDAO.getAllSchedule();
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
		} catch (Exception e)
		{
			forward = FORWARD_ERROR;
		}
		return forward;
	}

	/**
	 * Méthode permettant de lancer la page d'ajout d'horaire en initialisant la
	 * liste des groupes
	 * 
	 * @return
	 */
	@SkipValidation
	public String openScheduleForm()
	{
		forward = FORWARD_SUCCESS;
		this.arrayGroupName = this.groupDao.getAllGroupName();
		this.arrayClassroomName = this.classroomDao.getAllClassroomName();
		this.arrayUserTeacherName = this.userDao.getAllUserNameByGroup(this.groupDao.getGroupByName("Enseignant"));
		this.arraySubjectName = this.subjectDao.getAllSubject();
		return forward;
	}
	
	@SkipValidation
	public String getSchedule()
	{
		forward = FORWARD_SUCCESS;
		ScheduleDAO scheduleDAO = new ScheduleDAO();
		try
		{
			ScheduleEntity scheduleEntity = scheduleDAO.getSchedule(this.id);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			this.scheduleBean = new ScheduleBean();
			this.scheduleBean.setId(scheduleEntity.getId());
			this.scheduleBean.setName(scheduleEntity.getName());
			this.scheduleBean.setDayStart(simpleDateFormat.format(simpleDateFormat.parse(scheduleEntity.getDayStart())));
			this.scheduleBean.setDayEnd(simpleDateFormat.format(simpleDateFormat.parse(scheduleEntity.getDayEnd())));
			this.scheduleBean.setComment(scheduleEntity.getComment());
			this.scheduleBean.setNameUserTeacher(scheduleEntity.getUserTeacher().getName());
			this.scheduleBean.setNameSubject(scheduleEntity.getSubject().getName());
			this.scheduleBean.setNameClassroom(scheduleEntity.getClassroom().getName());
			this.scheduleBean.setNameGroup(scheduleEntity.getGroup().getName());
			this.scheduleBean.setArrayGroupName(groupDao.getAllGroupName());
			this.scheduleBean.setArrayClassroomName(classroomDao.getAllClassroomName());
			this.scheduleBean.setArraySubjectName(subjectDao.getAllSubject());
			this.scheduleBean.setArrayUserTeacher(userDao.getAllUserNameByGroup(groupDao.getGroupByName("Enseignant")));
			this.arrayGroupName = this.groupDao.getAllGroupName();
			this.arrayClassroomName = this.classroomDao.getAllClassroomName();
			this.arrayUserTeacherName = this.userDao.getAllUserNameByGroup(this.groupDao.getGroupByName("Enseignant"));
			this.arraySubjectName = this.subjectDao.getAllSubject();
		} catch (Exception e)
		{
			forward = FORWARD_ERROR;
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
		this.arraySubjectName = this.subjectDao.getAllSubject();
		scheduleBean.setArrayGroupName(groupDao.getAllGroupName());
		scheduleBean.setArrayClassroomName(classroomDao.getAllClassroomName());
		scheduleBean.setArraySubjectName(subjectDao.getAllSubject());
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
}
