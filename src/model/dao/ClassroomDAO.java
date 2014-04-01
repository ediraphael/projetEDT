package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import model.org.persistence.ClassroomEntity;
import model.org.persistence.UserEntity;

/**
 * Surcouche afin de rendre plus propre les accès en base
 * Cette classe DAO concerne les transaction pour classroom
 * @author raphael
 *
 */
public class ClassroomDAO 
{
	//Mise en place de la factory pour savoir dans quel base nous allons taper
	private final static  EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("ProjetEDT");
	//Cette entité permet d'acceder aux tables
	@PersistenceContext
	private EntityManager em;

	/**
	 * Methode permetant de sauvegarder une classe
	 * @param name
	 */
	public void addClassroom(String name)
	{
		em=FACTORY.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		ClassroomEntity classroom = new ClassroomEntity();
		classroom.setName(name);
		try 
		{
			tx.begin();
			em.persist(classroom);
			tx.commit();
		} finally {
			em.close();
		}
	}
}