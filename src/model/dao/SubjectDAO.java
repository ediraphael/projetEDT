package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.org.persistence.GroupEntity;
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
	
	@SuppressWarnings("unchecked")
	public List<String> getAllSubject()
	{
		List<String> listSubject;
		try 
		{
			em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
			Query q=getEntityManager().createNamedQuery("PasswordTeacherEntity.find");
			listSubject= q.getResultList() != null ? (List<String>) q.getResultList().get(0) : null;
		} finally 
		{
			getEntityManager().close();
		}
		return listSubject;
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