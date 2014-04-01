package model.org.persistence;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "user")
@NamedQueries
({
	//définition de requetes simple appelable dans le DAO
    @NamedQuery(name = "UserEntity.findAll", query = "SELECT u FROM UserEntity u"),
    @NamedQuery(name = "UserEntity.findById", query = "SELECT u FROM UserEntity u WHERE u.id = :id"),
    @NamedQuery(name = "UserEntity.findByEmail", query = "SELECT u FROM UserEntity u WHERE u.email = :email"),
    @NamedQuery(name = "UserEntity.findNextId", query = "select max(u.id)+1 from UserEntity u")
})
public class UserEntity implements Serializable 
{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur de la classe
	 */
	public UserEntity() 
	{
	}

	//Définition des colonnes de la table 
	@Id
	private long id;
	private String email;
	private String password;
	private long idGroupe;


	
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
	
	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public long getIdGroupe() 
	{
		return idGroupe;
	}

	public void setIdGroupe(long idGroupe) 
	{
		this.idGroupe = idGroupe;
	}

}