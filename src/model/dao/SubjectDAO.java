package model.dao;

import java.util.List;

import javax.persistence.Query;

import model.org.persistence.SubjectEntity;

/**
 * Surcouche afin de rendre plus propre les accès en base Cette classe DAO
 * concerne les transaction pour le subject
 * 
 * @author raphael
 * 
 */
public class SubjectDAO extends AbstractDAO<SubjectEntity>
{
	/**
	 * Surchage de la méthode abstraite pour lui préciser dans quel table trouver l'info
	 * @param id
	 */
	public SubjectEntity getById(long id) 
	{
		return getById(id, "SubjectEntity.findById");
	}
	
	/**
	 * Surchage de la méthode abstraite pour lui préciser dans quel table trouver l'info
	 * 
	 */
	public List<SubjectEntity> getAll()
	{
		return getAll("SubjectEntity.findAll");
	}
	
	/**
	 * Méthode permettant de récupérer un sujet par son nom
	 * 
	 */
	public SubjectEntity getSubjectByName(String name)
	{
		SubjectEntity subjectEntity;
		initEntityManager();
		try
		{
			Query q = getEntityManager().createNamedQuery("SubjectEntity.findByName").setParameter("name", name);
			subjectEntity = (q.getResultList().size()!=0) ? (SubjectEntity) q.getSingleResult() : null;
		} finally
		{
			getEntityManager().close();
		}
		return subjectEntity;
	}

	
	/**
	 * Méthode permettant de récupérer la liste des nom de sujets
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<String> getAllSubjectName()
	{
		List<String> listSubject;
		initEntityManager();
		try
		{
			Query q = getEntityManager().createNamedQuery("SubjectEntity.findAllName");
			listSubject = (q.getResultList().size()!=0) ? (List<String>) q.getResultList() : null;
		} finally
		{
			getEntityManager().close();
		}
		return listSubject;
	}
}