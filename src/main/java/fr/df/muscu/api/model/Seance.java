package fr.df.muscu.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

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
    
    @ManyToOne
    private SeancePredef seancePredef;
    
    @OneToMany(cascade={CascadeType.ALL})
    private List<Exercice> exercices = new ArrayList<>();

    
    public Seance() {}
    
    
	public Seance(Date date) {
		super();
		this.date = date;
	}

	public Seance(Date date, SeancePredef seancePredef) {
		super();
		this.date = date;
		this.seancePredef = seancePredef;
	}


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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((exercices == null) ? 0 : exercices.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((seancePredef == null) ? 0 : seancePredef.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seance other = (Seance) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (exercices == null) {
			if (other.exercices != null)
				return false;
		} else if (!exercices.equals(other.exercices))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (seancePredef == null) {
			if (other.seancePredef != null)
				return false;
		} else if (!seancePredef.equals(other.seancePredef))
			return false;
		return true;
	}
    
    
}
