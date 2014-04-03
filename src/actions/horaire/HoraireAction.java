package actions.horaire;

import actions.abstractAction.AbstractAction;

public class HoraireAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Execution de l'ajout d'un horaire
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
			forward = FORWARD_ERROR;
		}
		return forward;
	}

}
