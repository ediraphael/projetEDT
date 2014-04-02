package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import transitionObject.dto.UserDTO;
import model.org.persistence.UserEntity;

/**
 * Surcouche afin de rendre plus propre les accès en base
 * Cette classe DAO concerne les transaction pour les users
 * @author mickael
 *
 */
public class UserDAO 
{
	//Mise en place de la factory pour savoir dans quel base nous allons taper
	private final static  EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("ProjetEDT");
	//Cette entité permet d'acceder aux tables
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Methode permetant de sauvegarder un user
	 * @param email
	 * @param password
	 */
	public void addUser(String email, String password, long idGroupe)
	{
		em=FACTORY.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		UserEntity user = new UserEntity();
		user.setEmail(email);
		user.setPassword(password);
		user.setIdGroupe(idGroupe);
		try 
		{
			tx.begin();
			em.persist(user);
			tx.commit();
		} finally {
			em.close();
		}
	}
	
	/**
	 * Methode permetant de sauvegarder un user
	 * @param email
	 * @param password
	 */
	public UserDTO getUser(String email, String password)
	{
		UserDTO userResult = null;
		em=FACTORY.createEntityManager();
		UserEntity user = new UserEntity();
		user.setEmail(email);
		user.setPassword(password);
		try 
		{
			Query q=em.createNamedQuery("UserEntity.findByEmailAndPwd")
					.setParameter("email", email).setParameter("pwd", password);
			
			if(q.getResultList().get(0) !=null)
			{

			}
			else
			{
				
			}
		} finally {
			em.close();
		}
		return userResult;
	}
}