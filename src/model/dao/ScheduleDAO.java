package model.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.org.persistence.ClassroomEntity;
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
	
	/**
	 * Methode permetant de sauvegarder un horaire
	 * 
	 * @param name
	 */
	public void addSchedule(Date dayStart, Date dayEnd,String name,String comment,long idUserTeacher,long idSubject,long idClassroom,long idGroup)
	{
		em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
		EntityTransaction tx = em.getTransaction();
		ScheduleEntity schedule = new ScheduleEntity();
		schedule.setDayStart(dayStart);
		schedule.setDayEnd(dayEnd);
		schedule.setName(name);
		schedule.setComment(comment);
		schedule.setIdUserTeacher(idUserTeacher);
		schedule.setIdSubject(idSubject);
		schedule.setIdClassroom(idClassroom);
		schedule.setIdGroup(idGroup);
		try
		{
			tx.begin();
			em.persist(schedule);
			tx.commit();
		} finally
		{
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<ScheduleEntity> getAllSchedule() 
	{
		List<ScheduleEntity> schedules;
		try 
		{
			em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
			Query q = getEntityManager().createNamedQuery("ScheduleEntity.findAll");
			schedules = q.getResultList();
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
