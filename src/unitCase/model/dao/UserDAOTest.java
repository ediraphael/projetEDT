package unitCase.model.dao;

import java.util.List;

import model.dao.GroupDAO;
import model.dao.UserDAO;
import model.org.persistence.GroupEntity;
import model.org.persistence.UserEntity;

import org.junit.Assert;
import org.junit.Test;


/**
 * Classe de test du dao des users
 * @author mickael
 *
 */
public class UserDAOTest 
{
	//déclaration des objets DAO afin d'appeler les méthodes à tester
	private UserDAO udao = new UserDAO();
	private GroupDAO gdao = new GroupDAO();
	
	/**
	 * Test de la méthode du DAO permetant de récupérer un user par son id
	 */
	@Test
	public void testGetById() 
	{
		UserEntity u= udao.getById(5);
		Assert.assertFalse("Soit la base est vide, soit la méthode ne fonctionne pas", (u==null));
	}
	
	/**
	 * Test de la méthode du DAO permetant de faire un update sur un user
	 */
	@Test
	public void testUpdate() 
	{
		UserEntity u= udao.getById(1);
		u.setPassword("toto");
		udao.update(u);
	}
	
	/**
	 * Test de la méthode du DAO permetant supprimer un user
	 */
	@Test
	public void testDelete() 
	{
		UserEntity u= udao.getById(6);
		udao.delete(u);
	}
	
	
	/**
	 * Test de la méthode du DAO permettant d'enregstrer un user
	 */
	@Test
	public void testSave() 
	{
		UserEntity u = new UserEntity() ;
		GroupEntity g = gdao.getById(1);
		u.setFirstName("toto");
		u.setName("Toto");
		u.setEmail("Toto@univ-angers.fr");
		u.setPassword("toto");
		u.setGroupe(g);
		udao.save(u);
	}
	

	/**
	 * Test de la méthode du DAO permettant de récupérer tous les users
	 */
	@Test
	public void testGetAll()
	{
		List<UserEntity> u= udao.getAll();
		Assert.assertFalse("Soit la base est vide, soit la méthode ne fonctionne pas", (u==null));
	}
	
	
	/**
	 * Test de la méthode du DAO permettant de trouver un user par son nom
	 */
	@Test
	public void testGetUserByName() 
	{
		UserEntity u= udao.getUserByName("Coffinet");
		Assert.assertFalse("Soit la base est vide, soit la méthode ne fonctionne pas", (u==null || u.getId()<0));
	}
	
	/**
	 * Test de la méthode du DAO permettant de trouver tous les users du meme groupe
	 */
	@Test
	public void testGetAllUserNameByGroup() 
	{
		List<String> u= udao.getAllUserNameByGroup(gdao.getById(2));
		Assert.assertFalse("Soit la base est vide, soit la méthode ne fonctionne pas", (u==null));
	}
	

	/**
	 * Test de la méthode du DAO permettant de trouver un user pour l'authentification
	 */
	@Test
	public void testGetUserByEmailAndPwd() 
	{
		UserEntity u= udao.getUserByEmailAndPwd("mickael.fardilha@univ-angers.fr" , "fardilha");
		Assert.assertFalse("Soit la base est vide, soit la méthode ne fonctionne pas", (u==null || u.getId()<0));
	}
}
