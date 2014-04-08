package actions.group;

import model.dao.GroupDAO;
import bean.GroupBean;
import actions.abstractAction.AbstractAction;

public class GroupAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//bean de formulaire permettant le transfere des informations
	private GroupBean groupBean;
	GroupDAO groupDAO = new GroupDAO();

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


}
