package actions.group;

import java.util.ArrayList;
import java.util.List;

import model.dao.GroupDAO;
import model.org.persistence.GroupEntity;
import bean.GroupBean;
import actions.abstractAction.AbstractAction;

public class GroupAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//bean de formulaire permettant le transfere des informations
	private GroupBean groupBean;
	private long id;
	GroupDAO groupDAO = new GroupDAO();
	private ArrayList<GroupBean> listGroupBean;
	/**
	 * Execution de l'ajout d'un groupe
	 */
	public String execute()
	{
		//Sauf si il y a erreur, le traitement est considéré comme étant un succès
		forward = FORWARD_SUCCESS;
		try
		{
			//Sauvegarde du user renseigné dans le formulaire
			groupDAO.addGroup(groupBean.getName());

			session.put("group", groupBean);
		}
		catch(Exception e)
		{
			forward = FORWARD_ERROR;
		}
		return forward;
	}

	public String showGroup()
	{
		forward = FORWARD_SUCCESS;
		listGroupBean = new ArrayList<GroupBean>();
		try
		{
			List<GroupEntity> listGroupEntity = groupDAO.getAllGroup();
			for (GroupEntity groupEntity : listGroupEntity)
			{
				GroupBean groupBean = new GroupBean();
				groupBean.setId(groupEntity.getId());
				groupBean.setName(groupEntity.getName());
				listGroupBean.add(groupBean);
			}
		} catch (Exception e)
		{
			forward = FORWARD_ERROR;
		}
		return forward;
	}
	
	public String deleteGroup()
	{
		// Sauf si il y a erreur, le traitement est considéré comme étant un
		// succès
		forward = FORWARD_SUCCESS;
		try
		{
			GroupEntity groupEntity = groupDAO.getGroup(id);
			groupDAO.removeGroup(groupEntity);
		} catch (Exception e)
		{
			forward = FORWARD_ERROR;
		}
		return forward;
	}

	public GroupBean getGroupBean() {
		return groupBean;
	}

	public void setGroupBean(GroupBean groupBean) {
		this.groupBean = groupBean;
	}

	public GroupDAO getGroupDAO() {
		return groupDAO;
	}

	public void setGroupDAO(GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}

	public ArrayList<GroupBean> getListGroupBean() {
		return listGroupBean;
	}

	public void setListGroupBean(ArrayList<GroupBean> listGroupBean) {
		this.listGroupBean = listGroupBean;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
