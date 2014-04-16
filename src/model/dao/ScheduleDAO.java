package model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import model.org.persistence.GroupEntity;
import model.org.persistence.ScheduleEntity;

/**
 * Surcouche afin de rendre plus propre les accès en base
 * Cette classe DAO concerne les transactions pour les horaires
 * @author thibault
 * 
 */
public class ScheduleDAO extends AbstractDAO<ScheduleEntity>
{
	/**
	 * Surchage de la méthode abstraite pour lui préciser dans quel table trouver l'info
	 * @param id
	 */
	public ScheduleEntity getById(long id)
	{
		return getById(id, "ScheduleEntity.findById");
	}

	/**
	 * Surchage de la méthode abstraite pour lui préciser dans quel table trouver l'info
	 * 
	 */
	public List<ScheduleEntity> getAll()
	{
		return getAll("ScheduleEntity.findAll");
	}
	
	/**
	 * Methode getByGroup, permet de rechercher tout les schedules pour un group donnée
	 * @return List<ScheduleEntity>
	 */
	@SuppressWarnings("unchecked")
	public List<ScheduleEntity> getAllByGroup(GroupEntity group)
	{
		initEntityManager();
		List<ScheduleEntity> all = new ArrayList<ScheduleEntity>();
		try 
		{
			Query q=getEntityManager().createNamedQuery("ScheduleEntity.findByGroup").setParameter("group",group);
			all= (q.getResultList().size()!=0) ? (List<ScheduleEntity>) q.getResultList() : null ;
		} 
		finally 
		{
			getEntityManager().close();
		}
		return all;
	}
	
	/**
	 * Methode getByGroup, permet de rechercher tout les schedules pour un group donnée,date début et fin
	 * @return List<ScheduleEntity>
	 */
	@SuppressWarnings("unchecked")
	public List<ScheduleEntity> getAllByGroupAndDay(GroupEntity group, String dayStart, String dayEnd)
	{
		initEntityManager();
		List<ScheduleEntity> all = new ArrayList<ScheduleEntity>();
		try 
		{
			Query q=getEntityManager().createNamedQuery("ScheduleEntity.findByGroupAndDay").setParameter("group",group).setParameter("dayStart", dayStart).setParameter("dayEnd",dayEnd);
			all= (q.getResultList().size()!=0) ? (List<ScheduleEntity>) q.getResultList() : null ;
		} 
		finally 
		{
			getEntityManager().close();
		}
		return all;
	}
}
