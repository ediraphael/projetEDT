package unitCase.model.dao;

import static org.junit.Assert.fail;

import java.util.List;

import model.dao.GroupDAO;

import org.junit.Assert;
import org.junit.Test;

public class GroupDAOTest 
{


	//déclaration de l'objet DAO afin d'appeler les méthodes à tester
	private GroupDAO groupDAO = new GroupDAO();

	@Test
	public void test() 
	{
		fail("Not yet implemented");
	}


	@Test
	public void testGetAllGroupName() 
	{
		List<String> result = groupDAO.getAllGroupName();
		Assert.assertFalse("Soit la base est vide, soit la méthode ne fonctionne pas", (result.size()==0 ));
	}

}
