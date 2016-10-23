package fr.df.muscu.api.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

/** Evolution possible : créer un Type d'exercice et des variante  */

@Data
@ToString
@Entity
public class ExoPredef {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private String comment;
    private String image;
    
    @ElementCollection(targetClass=TypeExo.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="typeExo")
    @Column(name="type") // Column name in person_interest
    private List<TypeExo> type;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<TypeExo> getType() {
		return type;
	}
	public void setType(List<TypeExo> type) {
		this.type = type;
	}
   	
}
