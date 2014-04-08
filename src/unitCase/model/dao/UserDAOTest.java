package unitCase.model.dao;

import model.dao.UserDAO;
import model.org.persistence.UserEntity;

import org.junit.Test;


/**
 * Classe de test du dao des users
 * @author mickael
 *
 */
public class UserDAOTest 
{
	//déclaration de l'objet DAO afin d'appeler les méthodes à tester
	private UserDAO udao = new UserDAO();
	
	
	/**
	 * Test de la méthode du DAO permettant d'enregstrer un user
	 */
	@Test
	public void testAddUser() 
	{
		UserEntity u = new UserEntity("micka@gmail.com", "test", "micka", "FARDILHA",1) ;
		udao.addUser(u);
	}
	
	/**
	 * Test de la méthode du DAO permettant de trouver un user pour l'authentification
	 */
	@Test
	public void testGetUserByEmailAndPwd() 
	{
		UserEntity u= udao.getUserByEmailAndPwd("noname@univ-angers.fr", "noname");
		u.getEmail();
	}
	
	/**
	 * Test de la méthode du DAO permetant supprimer un user
	 */
	@Test
	public void testDeleteUser() 
	{
		UserEntity u= udao.getUserByEmailAndPwd("test@gmail.com", "pwd");
		udao.deleteUser(u);
	}
	
	/**
	 * Test de la méthode du DAO permetant de faire un update sur un user
	 */
	@Test
	public void testUpdateUser() 
	{
		UserEntity u= udao.getUserByEmailAndPwd("micka@gmail.com", "test");
		u.setPassword("toto");
		udao.updateUser(u);
	}
}
