package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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