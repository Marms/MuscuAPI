package fr.df.muscu.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Salle {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
    
	@OneToMany(cascade={CascadeType.ALL})
	private List<ExoPredef> exoTemplates;
    
    @OneToMany(cascade={CascadeType.ALL})
	private List<SeancePredef> seanceTemplates;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ExoPredef> getExoTemplates() {
		return exoTemplates;
	}
	public void setExoTemplates(List<ExoPredef> exoTemplate) {
		this.exoTemplates = exoTemplate;
	}
	public List<SeancePredef> getSeanceTemplates() {
		return seanceTemplates;
	}
	public void setSeanceTemplates(List<SeancePredef> seanceTemplate) {
		this.seanceTemplates = seanceTemplate;
	}
	
	
	
}
