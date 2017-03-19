package fr.df.muscu.api.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import org.crsh.plugin.Embedded;
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
    
    
}
