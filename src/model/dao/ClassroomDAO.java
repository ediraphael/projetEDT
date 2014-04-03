package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.org.persistence.ClassroomEntity;

/**
 * Surcouche afin de rendre plus propre les accès en base Cette classe DAO
 * concerne les transaction pour classroom
 * 
 * @author raphael
 * 
 */
public class ClassroomDAO
{
	// Mise en place de la factory pour savoir dans quel base nous allons taper
	private final static String JPA_DATABASE = "ProjetEDT";
	// Cette entité permet d'acceder aux tables
	@PersistenceContext
	private EntityManager em;

	/**
	 * Methode permetant de sauvegarder une classe
	 * 
	 * @param name
	 */
	public void addClassroom(String name)
	{
		em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
		EntityTransaction tx = em.getTransaction();
		ClassroomEntity classroom = new ClassroomEntity();
		classroom.setName(name);
		try
		{
			tx.begin();
			em.persist(classroom);
			tx.commit();
		} finally
		{
			em.close();
		}
	}

	public void removeClassroom(long id)
	{
		em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
		EntityTransaction tx = em.getTransaction();
		ClassroomEntity classroom = new ClassroomEntity();
		classroom.setId(id);
		try
		{
			tx.begin();
			em.remove(classroom);
			tx.commit();
		} finally
		{
			em.close();
		}
	}

	public void updateClassroom(ClassroomEntity classroom)
	{
		try
		{
			em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
			em.getTransaction().begin();
			classroom = em.merge(classroom);
			em.getTransaction().commit();
		} finally
		{
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<ClassroomEntity> getAllClassroom()
	{
		List<ClassroomEntity> listClassroomEntity;
		try
		{
			em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
			Query q = em.createNamedQuery("ClassroomEntity.findAll");
			listClassroomEntity = q.getResultList() != null ? (List<ClassroomEntity>) q.getResultList() : null;
		} finally
		{
			em.close();
		}
		return listClassroomEntity;
	}

	public ClassroomEntity getClassroom(long id)
	{
		ClassroomEntity classroomEntity;
		try
		{
			em = Persistence.createEntityManagerFactory(JPA_DATABASE).createEntityManager();
			Query q = em.createNamedQuery("ClassroomEntity.findById").setParameter("id", id);
			classroomEntity = q.getResultList() != null ? (ClassroomEntity) q.getResultList().get(0) : null;
		} finally
		{
			em.close();
		}
		return classroomEntity;
	}
}