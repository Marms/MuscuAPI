package fr.df.muscu.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


//@Data
@Entity
public class Exercice {

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((exoPredef == null) ? 0 : exoPredef.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + numero;
		result = prime * result + ((series == null) ? 0 : series.hashCode());
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
		Exercice other = (Exercice) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (exoPredef == null) {
			if (other.exoPredef != null)
				return false;
		} else if (!exoPredef.equals(other.exoPredef))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero != other.numero)
			return false;
		if (series == null) {
			if (other.series != null)
				return false;
		} else if (!series.equals(other.series))
			return false;
		return true;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private ExoPredef exoPredef;
    
    @ElementCollection
    @CollectionTable(name="SERIES", joinColumns=@JoinColumn(name="Owner_id"))
     private List<Serie> series = new ArrayList<>();
    
    private int numero;
    
    private Date date;

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
