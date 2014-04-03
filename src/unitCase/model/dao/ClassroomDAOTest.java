package unitCase.model.dao;

import java.util.List;

import model.dao.ClassroomDAO;
import model.org.persistence.ClassroomEntity;

import org.junit.Assert;
import org.junit.Test;

public class ClassroomDAOTest {

	//déclaration de l'objet DAO afin d'appeler les méthodes à tester
	private ClassroomDAO classroomDAO = new ClassroomDAO();
	
	@Test
	public void testGetAllClassroom() {
		List<ClassroomEntity> listeClassroom = classroomDAO.getAllClassroom();
		Assert.assertNotNull(listeClassroom);
		for (ClassroomEntity classroomEntity : listeClassroom)
		{
			Assert.assertNotNull(classroomEntity);
			System.out.println(classroomEntity.getId());
			System.out.println(classroomEntity.getName());
		}
	}

}
