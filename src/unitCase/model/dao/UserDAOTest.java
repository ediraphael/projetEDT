package unitCase.model.dao;

import model.dao.UserDAO;

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
		udao.addUser("test@gmail.com", "pwd");
	}

}
