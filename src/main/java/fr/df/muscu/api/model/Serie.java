package fr.df.muscu.api.model;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.internal.util.Cloneable;

import lombok.Data;

/** object embarqué dans l'object Exercices **/
@Data
@Entity
public class Serie extends Cloneable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
    private Integer numero;
    private double poids;
    private double nbRepeat;
    /** temps repos avant series en secondes */
    private int repos;
    
    /**
     * NORMAL, DEGRADER, PDC, TIME, TRACTION
     */
    
    @Enumerated(EnumType.STRING)    
    private TypeNotation type;
    
    private Double minute;
    
    private Double seconde;
    
    private Double leste;
    
    private Boolean forcer;
    
    private Boolean neg;
    
    private String comment;
    

	private Character unilateral;
    
    @OneToOne
    private Serie serie;
    
	public Character getUnilateral() {
		return unilateral;
	}
	public void setUnilateral(Character unilateral) {
		this.unilateral = unilateral;
	}
	public int getRepos() {
		return repos;
	}
	public void setRepos(int repos) {
		this.repos = repos;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public double getPoids() {
		return poids;
	}
	public void setPoids(double poids) {
		this.poids = poids;
	}
	public double getNbRepeat() {
		return nbRepeat;
	}
	public void setNbRepeat(double nbRepeat) {
		this.nbRepeat = nbRepeat;
	}
    public Integer getId() {
    	return id;
    }
    public void setId(Integer id) {
    	this.id = id;
    }
    public Serie getSerie() {
    	return serie;
    }
    public void setSerie(Serie serie) {
    	this.serie = serie;
    }
	
	public TypeNotation getType() {
		return type;
	}
	public void setType(TypeNotation type) {
		this.type = type;
	}
	public Double getMinute() {
		return minute;
	}
	public void setMinute(Double minute) {
		this.minute = minute;
	}
	public Double getSeconde() {
		return seconde;
	}
	public void setSeconde(Double seconde) {
		this.seconde = seconde;
	}
	public Double getLeste() {
		return leste;
	}
	public void setLeste(Double leste) {
		this.leste = leste;
	}
	public Boolean getForcer() {
		return forcer;
	}
	public void setForcer(Boolean force) {
		this.forcer = force;
	}
	public Boolean getNeg() {
		return neg;
	}
	public void setNeg(Boolean neg) {
		this.neg = neg;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
