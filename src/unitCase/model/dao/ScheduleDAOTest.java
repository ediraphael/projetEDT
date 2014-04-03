package unitCase.model.dao;

import static org.junit.Assert.*;

import java.util.List;

import model.dao.ScheduleDAO;
import model.org.persistence.ScheduleEntity;

import org.junit.Test;

public class ScheduleDAOTest {

	//déclaration de l'objet DAO afin d'appeler les méthodes à tester
	private ScheduleDAO scheduleDAO = new ScheduleDAO();

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetAllSchedule() {
		List<ScheduleEntity> schedules = scheduleDAO.getAllSchedule();
		for (ScheduleEntity scheduleEntity : schedules) {
			scheduleEntity.getId();
			scheduleEntity.getName();
		}
	}

}
