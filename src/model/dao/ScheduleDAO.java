package model.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.org.persistence.ScheduleEntity;

/**
 * 
 * @author thibault
 * 
 */
public class ScheduleDAO 
{
	// nom de la database
	private final static String JPA_DATABASE = "ProjetEDT";
	@PersistenceContext
	private EntityManager em;

	public ScheduleDAO() 
	{
		// TODO Auto-generated constructor stub
	}

	public ArrayList<ScheduleEntity> getAllSchedule() 
	{
		ArrayList<ScheduleEntity> schedules;
		try 
		{
			em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
			Query q = getEntityManager().createNamedQuery("ScheduleEntity.findAll");
			schedules = q.getResultList() != null ? (ArrayList<ScheduleEntity>) q.getResultList() : null;
		}
		finally 
		{
			getEntityManager().close();
		}
		return schedules;
	}

	/**
	 * Permet de récupérer et d'initialiser l'entity manager si celui ci est
	 * null
	 * 
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
