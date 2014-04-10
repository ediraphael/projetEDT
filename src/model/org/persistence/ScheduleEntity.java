package model.org.persistence;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "schedule")
@NamedQueries
({
	//définition de requetes simple appelable dans le DAO
    @NamedQuery(name = "ScheduleEntity.findAll", query = "SELECT u FROM ScheduleEntity u"),
    @NamedQuery(name = "ScheduleEntity.findById", query = "SELECT u FROM ScheduleEntity u WHERE u.id = :id"),
    @NamedQuery(name = "ScheduleEntity.findAllTeacher", query = "SELECT u FROM ScheduleEntity u "),
})
public class ScheduleEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ScheduleEntity() 
	{
		
	}
	
	//Définition des colonnes de la table
	
	@Id
	@Column(name="id_schedule")
	private long id;
	@Column(name="day_start")
	private Date dayStart;
	@Column(name="day_end")
	private Date dayEnd;
	@Column(name="name")
	private String name;
	@Column(name="comment")
	private String comment;
	@ManyToOne
	@JoinColumn(name="id_user_teacher")
	private UserEntity userTeacher;
	@ManyToOne
	@JoinColumn(name="id_subject")
	private SubjectEntity subject;
	@ManyToOne
	@JoinColumn(name="id_classroom")
	private ClassroomEntity classroom;
	@ManyToOne
	@JoinColumn(name="id_group_user")
	private GroupEntity group;

	
	// Getters et Setters
	
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
	public UserEntity getUserTeacher() {
		return userTeacher;
	}
	public void setUserTeacher(UserEntity userTeacher) {
		this.userTeacher = userTeacher;
	}
	public SubjectEntity getSubject() {
		return subject;
	}
	public void setSubject(SubjectEntity subject) {
		this.subject = subject;
	}
	public ClassroomEntity getClassroom() {
		return classroom;
	}
	public void setClassroom(ClassroomEntity classroom) {
		this.classroom = classroom;
	}
	public GroupEntity getGroup() {
		return group;
	}
	public void setGroup(GroupEntity group) {
		this.group = group;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
