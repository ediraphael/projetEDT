package bean;

import java.sql.Date;

public class ScheduleBean {

	private long id;
	private Date dayStart;
	private Date dayEnd;
	private String name;
	private String comment;
	private long idUserTeacher;
	private long idSubject;
	private long idClassroom;
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
	public long getIdUserTeacher() {
		return idUserTeacher;
	}
	public void setIdUserTeacher(long idUserTeacher) {
		this.idUserTeacher = idUserTeacher;
	}
	public long getIdSubject() {
		return idSubject;
	}
	public void setIdSubject(long idSubject) {
		this.idSubject = idSubject;
	}
	public long getIdClassroom() {
		return idClassroom;
	}
	public void setIdClassroom(long idClassroom) {
		this.idClassroom = idClassroom;
	}
	public String getNameGroup() {
		return nameGroup;
	}
	public void setNameGroup(String nameGroup) {
		this.nameGroup = nameGroup;
	}
	
}
