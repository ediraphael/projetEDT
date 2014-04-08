package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.org.persistence.GroupEntity;

public class GroupDAO {

	//nom de la database
	private final static String JPA_DATABASE = "ProjetEDT";
	//Cette entité permet d'acceder aux tables
	@PersistenceContext
	private EntityManager em;
	
	
	/**
	 * Methode permetant de sauvegarder un groupe
	 * @param name
	 */
	public void addGroup(String name)
	{
		em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
		GroupEntity group = new GroupEntity();
		group.setName(name);
		try 
		{
			getEntityManager().getTransaction().begin();
			getEntityManager().persist(group);
			getEntityManager().getTransaction().commit();
		} finally 
		{
			getEntityManager().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<GroupEntity> getAllGroup()
	{
		List<GroupEntity> listGroupEntity;
		try
		{
			em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
			Query q = em.createNamedQuery("GroupEntity.findAll");
			listGroupEntity = q.getResultList() != null ? (List<GroupEntity>) q.getResultList() : null;
		} finally
		{
			em.close();
		}
		return listGroupEntity;
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

	public GroupEntity getGroup(long id) {
		GroupEntity groupEntity;
		try
		{
			em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
			Query query = em.createNamedQuery("GroupEntity.findById").setParameter("id", id);
			groupEntity = query.getResultList() != null ? (GroupEntity) query.getResultList().get(0) : null;
		} finally
		{
			em.close();
		}
		return groupEntity;
	}

	public void removeGroup(GroupEntity groupEntity) {
		try 
		{
			em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
			em.getTransaction().begin();
			groupEntity = em.merge(groupEntity);
			em.remove(groupEntity);
			em.getTransaction().commit();
		} finally 
		{
			em.close();
		}
	}
}
