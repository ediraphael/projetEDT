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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
