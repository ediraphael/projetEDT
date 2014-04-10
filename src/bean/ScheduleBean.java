package bean;

import java.sql.Date;
import java.util.List;

public class ScheduleBean {

	private long id;
	private Date dayStart;
	private Date dayEnd;
	private String name;
	private String comment;
	private String nameUserTeacher;
	private String nameSubject;
	private String nameClassroom;
	private String nameGroup;
	private List<String> arrayGroupName;
	private List<String> arrayClassroomName;
	private List<String> arraySubjectName;
	private List<String> arrayUserTeacher;
	
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
	public String getNameUserTeacher() {
		return nameUserTeacher;
	}
	public void setNameUserTeacher(String nameUserTeacher) {
		this.nameUserTeacher = nameUserTeacher;
	}
	public String getNameSubject() {
		return nameSubject;
	}
	public void setSubject(String nameSubject) {
		this.nameSubject = nameSubject;
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
	public List<String> getArrayGroupName()
	{
		return arrayGroupName;
	}
	public void setArrayGroupName(List<String> arrayGroupName)
	{
		this.arrayGroupName = arrayGroupName;
	}
	public void setNameSubject(String nameSubject)
	{
		this.nameSubject = nameSubject;
	}
	public void setNameClassroom(String nameClassroom)
	{
		this.nameClassroom = nameClassroom;
	}
	public List<String> getArrayClassroomName()
	{
		return arrayClassroomName;
	}
	public void setArrayClassroomName(List<String> arrayClassroomName)
	{
		this.arrayClassroomName = arrayClassroomName;
	}
	public List<String> getArraySubjectName()
	{
		return arraySubjectName;
	}
	public void setArraySubjectName(List<String> arraySubjectName)
	{
		this.arraySubjectName = arraySubjectName;
	}
	public List<String> getArrayUserTeacher()
	{
		return arrayUserTeacher;
	}
	public void setArrayUserTeacher(List<String> arrayUserTeacher)
	{
		this.arrayUserTeacher = arrayUserTeacher;
	}
	
}
