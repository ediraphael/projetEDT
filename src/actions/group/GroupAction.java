package actions.group;

import bean.GroupBean;
import actions.abstractAction.AbstractAction;

public class GroupAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//bean de formulaire permettant le transfere des informations
	private GroupBean groupBean;
	/**
	 * Execution de l'ajout d'un groupe
	 */
	public String execute()
	{
		//Sauf si il y a erreur, le traitement est considéré comme étant un succès
		forward = FORWARD_SUCCESS;
		try
		{

		}
		catch(Exception e)
		{
			forward="ERROR";
		}
		return forward;
	}


}
