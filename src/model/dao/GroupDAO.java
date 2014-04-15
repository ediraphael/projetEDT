package model.dao;

import java.util.List;

import javax.persistence.Query;

import model.org.persistence.GroupEntity;

/**
 * Surcouche afin de rendre plus propre les accès en base
 * Cette classe DAO concerne les transactions pour les groupes
 * @author mickael
 *
 */
public class GroupDAO extends AbstractDAO<GroupEntity>
{
	/**
	 * Surchage de la méthode abstraite pour lui préciser dans quel table trouver l'info
	 * @param id
	 */
	public GroupEntity getById(long id) 
	{
		return getById(id, "GroupEntity.findById");
	}
	
	/**
	 * Surchage de la méthode abstraite pour lui préciser dans quel table trouver l'info
	 * 
	 */
	public List<GroupEntity> getAll()
	{
		return getAll("GroupEntity.findAll");
	}
	
	/**
	 * Methode permetant de récupérer un groupe avec son nom 
	 * @param name
	 */
	public GroupEntity getGroupByName(String name)
	{
		initEntityManager();
		GroupEntity groupEntity;
		try
		{
			Query q = getEntityManager().createNamedQuery("GroupEntity.findByName").setParameter("name", name);
			groupEntity = (q.getResultList().size()!=0) ? (GroupEntity) q.getSingleResult() : null ;
		} finally
		{
			getEntityManager().close();
		}
		return groupEntity;
	}
	
	/**
	 * Methode permetant de récupérer les noms de tous les groupes
	 * @param name
	 */
	@SuppressWarnings("unchecked")
	public List<String> getAllGroupName()
	{
		initEntityManager();
		List<String> listGroupName;
		try
		{
			Query q = getEntityManager().createNamedQuery("GroupEntity.findAllName");
			listGroupName = (q.getResultList().size()!=0) ? (List<String>) q.getResultList() : null;
		} finally
		{
			getEntityManager().close();
		}
		return listGroupName;
	}
}
