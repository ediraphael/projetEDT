package model.dao;

import java.util.List;

import javax.persistence.Query;

import model.org.persistence.GroupEntity;
import model.org.persistence.UserEntity;

/**
 * Surcouche afin de rendre plus propre les accès en base
 * Cette classe DAO concerne les transactions pour les users
 * @author mickael
 *
 */
public class UserDAO extends AbstractDAO<UserEntity> 
{
	/**
	 * Surchage de la méthode abstraite pour lui préciser dans quel table trouver l'info
	 * @param id
	 */
	public UserEntity getById(long id) 
	{
		return getById(id, "UserEntity.findById");
	}
	
	/**
	 * Surchage de la méthode abstraite pour lui préciser dans quel table trouver l'info
	 * 
	 */
	public List<UserEntity> getAll()
	{
		return getAll("UserEntity.findAll");
	}
	
	/**
	 * Methode permetant de récupérer un user avec email et password 
	 * Utile pour la connexion
	 * @param email
	 * @param password
	 */
	public UserEntity getUserByEmailAndPwd(String email, String password)
	{
		initEntityManager();
		UserEntity user = new UserEntity();
		user.setEmail(email);
		user.setPassword(password);
		try 
		{
			Query q=getEntityManager().createNamedQuery("UserEntity.findByEmailAndPwd")
					.setParameter("email", email).setParameter("pwd", password);
			user= (q.getResultList().size()!=0) ? (UserEntity) q.getSingleResult() : null ;
		} 
		finally 
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
		initEntityManager();
		UserEntity user = new UserEntity();
		user.setName(name);
		try 
		{
			Query q=getEntityManager().createNamedQuery("UserEntity.findByName").setParameter("name", name);
			user= (q.getResultList().size()!=0) ? (UserEntity) q.getSingleResult() : null ;
		} 
		finally 
		{
			getEntityManager().close();
		}
		return user;
	}
	
	/**
	 * Méthode permettant de trouver tous les users appartenant au même groupe 
	 * @param group
	 */
	@SuppressWarnings("unchecked")
	public List<String> getAllUserNameByGroup(GroupEntity group)
	{
		initEntityManager();
		List<String> listGroupName;
		try 
		{
			Query q=getEntityManager().createNamedQuery("UserEntity.findAllNameByGroup").setParameter("group", group);
			listGroupName= q.getResultList()!= null ? (List<String>) q.getResultList() : null ;
		} 
		finally 
		{
			getEntityManager().close();
		}
		return listGroupName;
	}
	
	/**
	 * Méthode permettant de savoir si le nom de la classroom existe deja 
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean existEmailUser(String email)
	{
		boolean res = false;
		
		initEntityManager();
		List<UserEntity> user;
		try 
		{
			Query q=getEntityManager().createNamedQuery("UserEntity.findByEmail").setParameter("email", email);
			user= (q.getResultList().size()!=0) ? (List<UserEntity>) q.getResultList() : null ;
		} 
		finally 
		{
			getEntityManager().close();
		}
		
		if(user!=null)
		{
			res=true;
		}
		return res;
	}
}