package actions.classroom;

import java.util.ArrayList;
import java.util.List;

import model.dao.ClassroomDAO;
import model.org.persistence.ClassroomEntity;
import actions.abstractAction.AbstractAction;
import bean.ClassroomBean;


/**
 * Action sur les salles
 * @author mickael
 *
 */
public class ClassroomAction extends AbstractAction
{
	//Serialization
	private static final long serialVersionUID = 1L;
	//déclaration et initialisation des DAO
	ClassroomDAO classroomDao = new ClassroomDAO();
	// bean de formulaire permettant le transfere des informations
	private ClassroomBean classroomBean;
	private ArrayList<ClassroomBean> listClassroomBean;
	//récupération de l'id pour afficher en mode modification une salle
	private long id;

	/**
	 * Execution la sauvegarde d'une salle 
	 */
	public String execute()
	{
		forward = FORWARD_SUCCESS;
		try
		{
			ClassroomEntity c = new ClassroomEntity();
			c.setName(classroomBean.getName());
			// Sauvegarde du user renseigné dans le formulaire
			classroomDao.save(c);
		} catch (Exception e)
		{
			forward = FORWARD_ERROR;
		}
		return forward;
	}
	
	/**
	 * Méthode permettant d'update une salle 
	 */
	public String updateClassroom()
	{
		// Sauf si il y a erreur, le traitement est considéré comme étant un
		// succès
		forward = FORWARD_SUCCESS;
		ClassroomDAO classroomDao = new ClassroomDAO();
		try
		{
			ClassroomEntity classroomEntity = new ClassroomEntity();
			classroomEntity.setId(this.classroomBean.getId());
			classroomEntity.setName(this.classroomBean.getName());
			classroomDao.update(classroomEntity);
		} catch (Exception e)
		{
			forward = FORWARD_ERROR;
		}
		return forward;
	}
	
	
	/**
	 * Méthode permettant de supprimer une salle
	 */
	public String deleteClassroom()
	{
		// Sauf si il y a erreur, le traitement est considéré comme étant un
		// succès
		forward = FORWARD_SUCCESS;
		ClassroomDAO classroomDao = new ClassroomDAO();
		try
		{
			ClassroomEntity classroomEntity = classroomDao.getById(this.id);
			classroomDao.delete(classroomEntity);
		} catch (Exception e)
		{
			forward = FORWARD_ERROR;
		}
		return forward;
	}
	
		
	/**
	 * Méthode permettant d'afficher la liste des salles 
	 * @return
	 */
	public String showClassroom()
	{
		forward = FORWARD_SUCCESS;
		ClassroomDAO classroomDao = new ClassroomDAO();
		this.listClassroomBean = new ArrayList<ClassroomBean>();
		try
		{
			List<ClassroomEntity> listClassroomEntity = classroomDao.getAll();
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
		return forward;
	}

	/**
	 * Méthode permettant de récupérer la salle selectionné pour l'afficher en mode modification
	 * 
	 */
	public String getClassroom()
	{
		forward = FORWARD_SUCCESS;
		ClassroomDAO classroomDao = new ClassroomDAO();
		try
		{
			ClassroomEntity classroomEntity = classroomDao.getById(this.id);
			this.classroomBean = new ClassroomBean();
			this.classroomBean.setId(classroomEntity.getId());
			this.classroomBean.setName(classroomEntity.getName());
		} catch (Exception e)
		{
			forward = FORWARD_ERROR;
		}
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

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}
	
}
