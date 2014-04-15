package actions.group;

import java.util.ArrayList;
import java.util.List;

import model.dao.GroupDAO;
import model.org.persistence.GroupEntity;
import bean.GroupBean;
import actions.abstractAction.AbstractAction;

/**
 * Action sur les groupes
 * @author mickael
 *
 */
public class GroupAction extends AbstractAction
{
	//Serialization
	private static final long serialVersionUID = 1L;

	//bean de formulaire permettant le transfere des informations
	private GroupBean groupBean;
	private ArrayList<GroupBean> listGroupBean;

	private long id;
	
	//déclaration et initialisation des DAO
	private GroupDAO groupDAO = new GroupDAO();
	
	
	/**
	 * Execution de l'ajout d'un groupe
	 */
	public String execute()
	{
		forward = FORWARD_SUCCESS;
		try
		{
			GroupEntity g = new GroupEntity();
			g.setName(groupBean.getName());
			groupDAO.save(g);

			session.put("group", groupBean);
		}
		catch(Exception e)
		{
			forward = FORWARD_ERROR;
		}
		return forward;
	}

	
	/**
	 * Méthode permettant d'afficher la liste des groupes
	 * @return
	 */
	public String showGroup()
	{
		forward = FORWARD_SUCCESS;
		listGroupBean = new ArrayList<GroupBean>();
		try
		{
			List<GroupEntity> listGroupEntity = groupDAO.getAll();
			for (GroupEntity groupEntity : listGroupEntity)
			{
				GroupBean groupBean = new GroupBean();
				groupBean.setId(groupEntity.getId());
				groupBean.setName(groupEntity.getName());
				listGroupBean.add(groupBean);
			}
		} 
		catch (Exception e)
		{
			forward = FORWARD_ERROR;
		}
		return forward;
	}

	
	/**
	 * Méthode permettant de supprimer un groupe
	 * @return
	 */
	public String deleteGroup()
	{
		forward = FORWARD_SUCCESS;
		try
		{
			GroupEntity groupEntity = groupDAO.getById(id);
			groupDAO.delete(groupEntity);
		} 
		catch (Exception e)
		{
			forward = FORWARD_ERROR;
		}
		return forward;
	}

	
	/**
	 * Getters and setters
	 *
	 */
	public GroupBean getGroupBean() 
	{
		return groupBean;
	}

	public void setGroupBean(GroupBean groupBean) 
	{
		this.groupBean = groupBean;
	}

	public GroupDAO getGroupDAO() 
	{
		return groupDAO;
	}

	public void setGroupDAO(GroupDAO groupDAO) 
	{
		this.groupDAO = groupDAO;
	}

	public ArrayList<GroupBean> getListGroupBean() 
	{
		return listGroupBean;
	}

	public void setListGroupBean(ArrayList<GroupBean> listGroupBean) 
	{
		this.listGroupBean = listGroupBean;
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
