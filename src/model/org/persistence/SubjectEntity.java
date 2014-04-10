package model.org.persistence;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity correspondant à la table password_teacher
 * @author mickael
 *
 */
@Entity
@Table(name = "passwordTeacher")
@NamedQueries
({
	//définition de requetes simple appelable dans le DAO
    @NamedQuery(name = "PasswordTeacherEntity.find", query = "SELECT p.password FROM PasswordTeacherEntity p"),
})
public class SubjectEntity implements Serializable 
{
	//Serialization
	private static final long serialVersionUID = 1L;

	//Définition des colonnes de la table 
	@Id
	@Column(name="id_password_teacher")
	private long id;
	@Column(name="password")
	private String password;
	
	
	/**
	 * Getters et setters de cette entité user
	 * 
	 */
	public long getId() 
	{
		return id;
	}

	public void setId(long id) 
	{
		this.id = id;
	}
	
	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}
}