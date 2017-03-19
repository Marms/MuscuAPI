package fr.df.muscu.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


//@Data
@Entity
public class Exercice {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private ExoPredef exoPredef;
    
//    @ElementCollection
//    @CollectionTable(name="SERIES", joinColumns=@JoinColumn(name="Owner_id"))
    @OneToMany(cascade={CascadeType.ALL}) 
    private List<Serie> series = new ArrayList<>();
     
    
    private Date date;
    
    private int numero;

    /** temps de repos en secondes */
    private int repos;
    
	public int getRepos() {
		return repos;
	}

	public void setRepos(int repos) {
		this.repos = repos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ExoPredef getExoPredef() {
		return exoPredef;
	}

	public void setExoPredef(ExoPredef exoPredef) {
		this.exoPredef = exoPredef;
	}

	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    
}
