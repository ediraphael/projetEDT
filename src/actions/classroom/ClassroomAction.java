package actions.classroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.dao.ClassroomDAO;
import model.org.persistence.ClassroomEntity;
import actions.abstractAction.AbstractAction;
import bean.ClassroomBean;

public class ClassroomAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;
	// bean de formulaire permettant le transfere des informations
	private ClassroomBean classroomBean;
	private ArrayList<ClassroomBean> listClassroomBean;

	/**
	 * Execution l'inscription en sauvegardant le user
	 */
	public String execute()
	{
		// Sauf si il y a erreur, le traitement est considéré comme étant un
		// succès
		forward = FORWARD_SUCCESS;
		ClassroomDAO classroomDao = new ClassroomDAO();
		try
		{
			// Sauvegarde du user renseigné dans le formulaire
			classroomDao.addClassroom(classroomBean.getName());
		} catch (Exception e)
		{
			forward = FORWARD_ERROR;
		}
		return forward;
	}

	public String showClassroom()
	{
		forward = FORWARD_SUCCESS;
		ClassroomDAO classroomDao = new ClassroomDAO();
		this.listClassroomBean = new ArrayList<ClassroomBean>();
		try
		{
			List<ClassroomEntity> listClassroomEntity = classroomDao.getAllClassroom();
			for (ClassroomEntity classroomEntity : listClassroomEntity)
			{
				ClassroomBean classroomBean = new ClassroomBean();
				classroomBean.setId(classroomEntity.getId());
				classroomBean.setName(classroomEntity.getName());
				this.listClassroomBean.add(classroomBean);
			}
		} catch (Exception e)
		{
			forward = FORWARD_ERROR;
		}
		this.classroomBean = this.listClassroomBean.get(0);
		return forward;
	}

	/**
	 * Méthode permetant la validation des champs
	 */
	public void validate()
	{
		if (classroomBean != null)
		{
			if ("".equals(classroomBean.getName()))
			{
				addFieldError("error.name", getText("validator.field.empty"));
			}
		}
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}

	public Map<String, Object> getSession()
	{
		return session;
	}

	/**
	 * Getters and setters
	 * 
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

	public ArrayList<ClassroomBean> getListClassroomBean()
	{
		return listClassroomBean;
	}

	public void setListClassroomBean(ArrayList<ClassroomBean> listClassroomBean)
	{
		this.listClassroomBean = listClassroomBean;
	}

}
