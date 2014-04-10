package model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.org.persistence.GroupEntity;
import model.org.persistence.UserEntity;

/**
 * Surcouche afin de rendre plus propre les accès en base
 * Cette classe DAO concerne les transaction pour les users
 * @author mickael
 *
 */
public class UserDAO 
{
	//nom de la database
	private final static String JPA_DATABASE = "ProjetEDT";
	//Cette entité permet d'acceder aux tables
	@PersistenceContext
	private EntityManager em;
	

	@SuppressWarnings("unchecked")
	public List<UserEntity> getAllUser()
	{
		List<UserEntity> allUser = new ArrayList<UserEntity>();
		try 
		{
			em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
			Query q=getEntityManager().createNamedQuery("UserEntity.findAll");
			allUser= q.getResultList()!= null ? (List<UserEntity>) q.getResultList() : null ;
		} finally 
		{
			getEntityManager().close();
		}
		return allUser;
	}
	
	/**
	 * Methode permetant de récupérer un user avec email et password 
	 * Utile pour la connexion
	 * @param email
	 * @param password
	 */
	public UserEntity getUserByEmailAndPwd(String email, String password)
	{
		UserEntity user = new UserEntity();
		user.setEmail(email);
		user.setPassword(password);
		try 
		{
			em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
			Query q=getEntityManager().createNamedQuery("UserEntity.findByEmailAndPwd")
					.setParameter("email", email).setParameter("pwd", password);
			user= q.getResultList()!= null ? (UserEntity) q.getResultList().get(0) : null ;
		} finally 
		{
			getEntityManager().close();
		}
		return user;
	}
	
	/**
	 * Methode permetant de récupérer un user avec son nom 
	 * @param name
	 */
	public UserEntity getUserByName(String name)
	{
		UserEntity user = new UserEntity();
		user.setName(name);
		try 
		{
			em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
			Query q=getEntityManager().createNamedQuery("UserEntity.findByName")
					.setParameter("name", name);
			user= q.getResultList()!= null ? (UserEntity) q.getResultList().get(0) : null ;
		} finally 
		{
			getEntityManager().close();
		}
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getAllUserNameByGroup(GroupEntity group)
	{
		List<String> listGroupName;
		try 
		{
			em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
			Query q=getEntityManager().createNamedQuery("UserEntity.findAllNameByGroup")
					.setParameter("group", group);
			listGroupName= q.getResultList()!= null ? (List<String>) q.getResultList() : null ;
		} finally 
		{
			getEntityManager().close();
		}
		return listGroupName;
	}
	
	/**
	 * Methode permetant de sauvegarder un user
	 * @param email
	 * @param password
	 */
	public void addUser(UserEntity user)
	{
		em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
		
		try 
		{
			getEntityManager().getTransaction().begin();
			getEntityManager().persist(user);
			getEntityManager().getTransaction().commit();
		} finally 
		{
			getEntityManager().close();
		}
	}
	
	
	/**
	 * Permet de supprimer un user
	 * @param user 
	 */
	public void deleteUser(UserEntity user) 
	{
		try 
		{
			em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
			getEntityManager().getTransaction().begin();
			user = getEntityManager().merge(user);
			getEntityManager().remove(user);
			getEntityManager().getTransaction().commit();
		} finally 
		{
			getEntityManager().close();
		}
	}
		
	/**
	 * Permet d'update un user
	 * @param user
	 */
	public void updateUser(UserEntity user) 
	{
		try 
		{
			em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
			getEntityManager().getTransaction().begin();
			user = getEntityManager().merge(user);
			getEntityManager().getTransaction().commit();
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