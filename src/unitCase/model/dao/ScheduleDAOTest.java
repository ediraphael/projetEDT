package unitCase.model.dao;

import java.util.List;

import model.dao.ScheduleDAO;
import model.org.persistence.ScheduleEntity;

import org.junit.Assert;
import org.junit.Test;


/**
 * Classe de test du dao des horaires
 * @author mickael
 *
 */
public class ScheduleDAOTest 
{
	//déclaration de l'objet DAO afin d'appeler les méthodes à tester
	private ScheduleDAO scheduleDAO = new ScheduleDAO();

	/**
	 * Test de la méthode du DAO permetant de récupérer un user par son id
	 */
	@Test
	public void testGetById() 
	{
		ScheduleEntity s= scheduleDAO.getById(1);
		Assert.assertFalse("Soit la base est vide, soit la méthode ne fonctionne pas", (s==null));
	}
	
	/**
	 * Test de la méthode du DAO permetant de faire un update sur un user
	 */
	@Test
	public void testUpdate() 
	{
		ScheduleEntity s= scheduleDAO.getById(1);
		s.setComment("junit update");
		scheduleDAO.update(s);
	}
	
	/**
	 * Test de la méthode du DAO permetant supprimer un user
	 */
	@Test
	public void testDelete() 
	{
		ScheduleEntity s= scheduleDAO.getById(3);
		scheduleDAO.delete(s);
	}
	
	
	/**
	 * Test de la méthode du DAO permettant d'enregstrer un user
	 */
	@Test
	public void testSave() 
	{
		ScheduleEntity s = new ScheduleEntity() ;
		s.setComment("junit test save");
		scheduleDAO.save(s);
	}
	

	/**
	 * Test de la méthode du DAO permettant de récupérer tous les users
	 */
	@Test
	public void testGetAll()
	{
		List<ScheduleEntity> s= scheduleDAO.getAll();
		Assert.assertFalse("Soit la base est vide, soit la méthode ne fonctionne pas", (s==null));
	}
}
