package fr.df.muscu.api.model;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.crsh.plugin.Embedded;
import org.hibernate.internal.util.Cloneable;

import lombok.Data;

/** object embarqué dans l'object Exercices **/
@Data
@Embeddable
public class Serie extends Cloneable {

    private int numero;
    private double poids;
    private double nbRepeat;
    /** temps repos avant series en secondes */
    private int repos;
    
	public int getRepos() {
		return repos;
	}
	public void setRepos(int repos) {
		this.repos = repos;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
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
