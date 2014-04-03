package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class GroupDAO {

	//nom de la database
	private final static String JPA_DATABASE = "ProjetEDT";
	//Cette entité permet d'acceder aux tables
	@PersistenceContext
	private EntityManager em;
	
	
	/**
	 * Methode permetant de sauvegarder un user
	 * @param name
	 */
	public void addGroup(String name)
	{
		em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();

		try 
		{

		} finally 
		{
			getEntityManager().close();
		}
	}
	
	/**
	 * Permet de récupérer et d'initialiser l'entity manager si celui ci est null
	 * @return
	 */
	protected EntityManager getEntityManager() 
	{
		if (em == null) 
		{
			em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
		}
		return em;
	}
}
