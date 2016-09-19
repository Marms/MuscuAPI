package fr.df.muscu.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Nullable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
public class Seance {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
  
    private Date date;
    
    @OneToOne
    @Nullable
    private SeancePredef seancePredef;
    
    @OneToMany(cascade=CascadeType.ALL)
    private List<Exercice> exercices = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public SeancePredef getSeancePredef() {
		return seancePredef;
	}

	public void setSeancePredef(SeancePredef seancePredef) {
		this.seancePredef = seancePredef;
	}

	public List<Exercice> getExercices() {
		return exercices;
	}

	public void setExercices(List<Exercice> exercices) {
		this.exercices = exercices;
	}
    
    
}
