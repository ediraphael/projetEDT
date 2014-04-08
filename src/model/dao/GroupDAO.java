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
	
	@SuppressWarnings("unchecked")
	public List<String> getAllGroupName()
	{
		List<String> listGroupName;
		try
		{
			em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
			Query q = em.createNamedQuery("GroupEntity.findAllName");
			listGroupName = q.getResultList() != null ? (List<String>) q.getResultList() : null;
		} finally
		{
			em.close();
		}
		return listGroupName;
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
