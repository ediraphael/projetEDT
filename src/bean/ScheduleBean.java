package bean;

import java.sql.Date;

public class ScheduleBean {

	private long id;
	private Date dayStart;
	private Date dayEnd;
	private String name;
	private String comment;
	private String nameUserTeacher;
	private long idSubject;
	private String nameClassroom;
	private String nameGroup;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDayStart() {
		return dayStart;
	}
	public void setDayStart(Date dayStart) {
		this.dayStart = dayStart;
	}
	public Date getDayEnd() {
		return dayEnd;
	}
	public void setDayEnd(Date dayEnd) {
		this.dayEnd = dayEnd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getIdUserTeacher() {
		return nameUserTeacher;
	}
	public void setUserTeacher(String nameUserTeacher) {
		this.nameUserTeacher = nameUserTeacher;
	}
	public long getIdSubject() {
		return idSubject;
	}
	public void setIdSubject(long idSubject) {
		this.idSubject = idSubject;
	}
	public String getNameClassroom() {
		return nameClassroom;
	}
	public void setClassroom(String nameClassroom) {
		this.nameClassroom = nameClassroom;
	}
	public String getNameGroup() {
		return nameGroup;
	}
	public void setNameGroup(String nameGroup) {
		this.nameGroup = nameGroup;
	}
	
}
