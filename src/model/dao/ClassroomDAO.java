package model.dao;

import java.util.List;

import javax.persistence.Query;

import model.org.persistence.ClassroomEntity;

/**
 * Surcouche afin de rendre plus propre les accès en base Cette classe DAO
 * concerne les transaction pour classroom
 * 
 * @author raphael
 * 
 */
public class ClassroomDAO extends AbstractDAO<ClassroomEntity>
{
	
	/**
	 * Surchage de la méthode abstraite pour lui préciser dans quel table trouver l'info
	 * @param id
	 */
	public ClassroomEntity getById(long id) 
	{
		return getById(id, "ClassroomEntity.findById");
	}
	
	/**
	 * Surchage de la méthode abstraite pour lui préciser dans quel table trouver l'info
	 * 
	 */
	public List<ClassroomEntity> getAll()
	{
		return getAll("ClassroomEntity.findAll");
	}
	
	/**
	 * Méthode permettant de récupérer la liste de tous les noms des salles
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<String> getAllClassroomName()
	{
		initEntityManager();
		List<String> listClassroomName;
		try
		{
			Query q = getEntityManager().createNamedQuery("ClassroomEntity.findAllName");
			listClassroomName = (q.getResultList().size()!=0) ? (List<String>) q.getResultList() : null ;
		} finally
		{
			getEntityManager().close();
		}
		return listClassroomName;
	}

	/**
	 * Méthode permettant de récupérer une salle grace à son nom
	 * 
	 */
	public ClassroomEntity getClassroomByName(String name)
	{
		initEntityManager();
		ClassroomEntity classroomEntity;
		try
		{
			Query q = getEntityManager().createNamedQuery("ClassroomEntity.findByName").setParameter("name", name);
			classroomEntity = (q.getResultList().size()!=0) ? (ClassroomEntity) q.getSingleResult() : null ;
		} finally
		{
			getEntityManager().close();
		}
		return classroomEntity;
	}
}