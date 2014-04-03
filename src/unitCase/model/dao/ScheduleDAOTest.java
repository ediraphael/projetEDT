package unitCase.model.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.dao.ScheduleDAO;
import model.dao.UserDAO;
import model.org.persistence.ScheduleEntity;

import org.junit.Test;

public class ScheduleDAOTest {

	//déclaration de l'objet DAO afin d'appeler les méthodes à tester
	private ScheduleDAO scheduleDAO = new ScheduleDAO();
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	public void testGetAllSchedule() {
		ArrayList<ScheduleEntity> schedules = scheduleDAO.getAllSchedule();
		for (ScheduleEntity scheduleEntity : schedules) {
			System.out.println(scheduleEntity.getId());
			System.out.println(scheduleEntity.getName());
		}
	}

}
