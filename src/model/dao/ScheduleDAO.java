package model.dao;

import java.util.List;

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
		return getById(id, "ScheduleEntity.findAll");
	}

	/**
	 * Surchage de la méthode abstraite pour lui préciser dans quel table trouver l'info
	 * 
	 */
	public List<ScheduleEntity> getAll()
	{
		return getAll("ScheduleEntity.findAll");
	}
}
