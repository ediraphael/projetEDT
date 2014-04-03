package actions.group;

import java.util.Map;

import actions.abstractAction.AbstractAction;

public class GroupAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	//forward pour rediriger vers la bonne page
	private String forward;

	/**
	 * Execution de l'ajout d'un groupe
	 */
	public String execute()
	{
		//Sauf si il y a erreur, le traitement est considéré comme étant un succès
		forward = "SUCCESS";
		try
		{

		}
		catch(Exception e)
		{
			forward="ERROR";
		}
		return forward;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() 
	{
		return session;
	}

}
