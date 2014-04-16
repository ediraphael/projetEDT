package actions.schedule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.dao.ClassroomDAO;
import model.dao.GroupDAO;
import model.dao.ScheduleDAO;
import model.dao.SubjectDAO;
import model.dao.UserDAO;
import model.org.persistence.ClassroomEntity;
import model.org.persistence.GroupEntity;
import model.org.persistence.ScheduleEntity;
import model.org.persistence.UserEntity;

import org.apache.struts2.interceptor.validation.SkipValidation;

import actions.abstractAction.AbstractAction;
import bean.ScheduleBean;

public class ScheduleAction extends AbstractAction
{
	// Serialization
	private static final long serialVersionUID = 1L;
	private long id;

	// bean de formulaire permettant le transfere des informations
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
			scheduleDAO.save(scheduleEntity);
		} catch (Exception e)
		{
			forward = generateError(e);
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
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ScheduleEntity scheduleEntity = new ScheduleEntity();
			scheduleEntity.setId(this.scheduleBean.getId());
			scheduleEntity.setDayStart(simpleDateFormat.format(simpleDateFormat.parse(this.scheduleBean.getDayStart())));
			scheduleEntity.setDayEnd(simpleDateFormat.format(simpleDateFormat.parse(this.scheduleBean.getDayEnd())));
			scheduleEntity.setName(this.scheduleBean.getName());
			scheduleEntity.setComment(this.scheduleBean.getComment());
			scheduleEntity.setUserTeacher(this.userDao.getUserByName(this.scheduleBean.getNameUserTeacher()));
			scheduleEntity.setSubject(this.subjectDao.getSubjectByName(this.scheduleBean.getNameSubject()));
			scheduleEntity.setClassroom(this.classroomDao.getClassroomByName(this.scheduleBean.getNameClassroom()));
			scheduleEntity.setGroup(this.groupDao.getGroupByName(this.scheduleBean.getNameGroup()));

			scheduleDAO.update(scheduleEntity);
		} catch (Exception e)
		{
			forward = generateError(e);
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
			ScheduleEntity scheduleEntity = scheduleDAO.getById(this.id);
			scheduleDAO.delete(scheduleEntity);
		} catch (Exception e)
		{
			forward = generateError(e);
		}
		return forward;
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
			List<ScheduleEntity> listScheduleEntity = scheduleDAO.getAll();
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
		} catch (Exception e)
		{
			forward = generateError(e);
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
		this.arraySubjectName = this.subjectDao.getAllSubjectName();
		return forward;
	}

	@SkipValidation
	public String getSchedule()
	{
		forward = FORWARD_SUCCESS;
		ScheduleDAO scheduleDAO = new ScheduleDAO();
		try
		{
			ScheduleEntity scheduleEntity = scheduleDAO.getById(this.getId());
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
			this.scheduleBean.setArraySubjectName(subjectDao.getAllSubjectName());
			this.scheduleBean.setArrayUserTeacher(userDao.getAllUserNameByGroup(groupDao.getGroupByName("Enseignant")));
			this.arrayGroupName = this.groupDao.getAllGroupName();
			this.arrayClassroomName = this.classroomDao.getAllClassroomName();
			this.arrayUserTeacherName = this.userDao.getAllUserNameByGroup(this.groupDao.getGroupByName("Enseignant"));
			this.arraySubjectName = this.subjectDao.getAllSubjectName();
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
		if (scheduleBean != null)
		{
			if ("".equals(scheduleBean.getName()))
			{
				addFieldError("error.name", getText("validator.field.empty"));
			}
			try
			{
				if (scheduleBean.getDayStart() == null || "".equals(scheduleBean.getDayStart()))
				{
					addFieldError("error.dayStart", getText("validator.field.empty"));
				}
			} catch (ParseException e)
			{
				addFieldError("error.dayStart", getText("validator.field.date.wrong"));
			}
			try
			{
				if (scheduleBean.getDayEnd() == null || "".equals(scheduleBean.getDayEnd()))
				{
					addFieldError("error.dayEnd", getText("validator.field.empty"));
				} else
				{
					if (scheduleBean.getDayStart() != null && !"".equals(scheduleBean.getDayStart()))
					{
						String dayStart = scheduleBean.getDayStart();
						String dayEnd = scheduleBean.getDayEnd();
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date dayStartDate = simpleDateFormat.parse(dayStart);
						Date dayEndDate = simpleDateFormat.parse(dayEnd);
						if (!dayStartDate.before(dayEndDate))
						{
							addFieldError("error.dayEnd", getText("validator.field.date.EndError"));
						}
					}
				}
			} catch (ParseException e)
			{
				addFieldError("error.dayEnd", getText("validator.field.date.wrong"));
			}
			// findIfClassroomExist
			try
			{
				if (!(scheduleBean.getDayEnd() == null || "".equals(scheduleBean.getDayEnd())) && !(scheduleBean.getDayEnd() == null || "".equals(scheduleBean.getDayEnd())))
				{
					String dayStart = scheduleBean.getDayStart();
					String dayEnd = scheduleBean.getDayEnd();
					ScheduleDAO scheduleDAO = new ScheduleDAO();
					ClassroomEntity classroom = classroomDao.getClassroomByName(this.scheduleBean.getNameClassroom());
					GroupEntity group = groupDao.getGroupByName(this.scheduleBean.getNameGroup());
					UserEntity user = userDao.getUserByName(this.scheduleBean.getNameUserTeacher());
					List<ScheduleEntity> listClassroom = scheduleDAO.findIfClassroomExist(classroom, dayStart, dayEnd);
					List<ScheduleEntity> listGroup = scheduleDAO.findIfGroupExist(group, dayStart, dayEnd);
					List<ScheduleEntity> listUser = scheduleDAO.findIfUserTeacherExist(user, dayStart, dayEnd);
					if (listClassroom != null && listClassroom.size() != 0)
					{
						addFieldError("error.classroom", getText("validator.classromm.already.use"));
					}
					if (listGroup != null && listGroup.size() != 0)
					{
						addFieldError("error.group", getText("validator.group.already.use"));
					}
					if (listUser != null && listUser.size() != 0)
					{
						addFieldError("error.userTeacher", getText("validator.userTeacher.already.use"));
					}
				}
			} catch (ParseException e)
			{
			}

		}

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
}
