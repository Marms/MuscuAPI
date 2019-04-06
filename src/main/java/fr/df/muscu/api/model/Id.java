package fr.df.muscu.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Id {

	@javax.persistence.Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String comment;
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getId() {
		return id; 
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
}
