package model.org.persistence;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="group")
@NamedQueries
({
	//définition de requêtes
	@NamedQuery(name = "GroupEntity.findAll", query = "Select group From GroupEntity group"),
	@NamedQuery(name = "GroupEntity.findById", query= "Select group FROM GroupEntity group WHERE group.id = :id"),
	@NamedQuery(name = "GroupEntity.findByName", query= "Select group FROM GroupEntity group WHERE group.name = :name")
})
public class GroupEntity implements Serializable
{

	
	private static final long serialVersionUID = 1L;
	/**
	 * Constructeur de la classe groupEntity
	 */
	public GroupEntity()
	{
		
	}
	
	//Définition des colonnes de la table
	@Id
	@Column(name="id_group")
	private long id;
	@Column(name="name")
	private String name;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
