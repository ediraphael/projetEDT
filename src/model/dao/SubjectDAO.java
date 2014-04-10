package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.org.persistence.PasswordTeacherEntity;


/**
 * Surcouche afin de rendre plus propre les accès en base
 * Cette classe DAO concerne les transaction pour le passwordTeacher
 * @author mickael
 *
 */
public class SubjectDAO 
{
	//nom de la database
	private final static String JPA_DATABASE = "ProjetEDT";
	//Cette entité permet d'acceder aux tables
	@PersistenceContext
	private EntityManager em;
	

	
	
	/**
	 * Methode permetant de le passwordTeacher
	 * Utile enregistrer un user du groupe enseignant
	 */
	public String getPasswordTeacher()
	{
		String pwd="";
		try 
		{
			em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
			Query q=getEntityManager().createNamedQuery("PasswordTeacherEntity.find");
			pwd= q.getResultList()!= null ? (String) q.getResultList().get(0) : "" ;
		} finally 
		{
			getEntityManager().close();
		}
		return pwd;
	}
	
		
	/**
	 * Permet d'update le passwordTeacher
	 * @param password
	 */
	public void updateUser(String pwd) 
	{
		PasswordTeacherEntity pEntity= new PasswordTeacherEntity();
		pEntity.setPassword(pwd);
		try 
		{
			em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
			getEntityManager().getTransaction().begin();
			getEntityManager().merge(pEntity);
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