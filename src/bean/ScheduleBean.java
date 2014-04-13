package bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	public String getDayStart() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(dayStart);
	}
	public void setDayStart(String dayStart) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try
		{
			this.dayStart = simpleDateFormat.parse(dayStart);
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getDayEnd() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(dayEnd);
	}
	public void setDayEnd(String dayEnd) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try
		{
			this.dayEnd = simpleDateFormat.parse(dayEnd);
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
