package fr.df.muscu.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class SeancePredef {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private String name;
    
    @OneToMany(cascade=CascadeType.ALL)
    private List<ExoPredef> list = new ArrayList<>();

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

	public List<ExoPredef> getList() {
		return list;
	}

	public void setList(List<ExoPredef> list) {
		this.list = list;
	}
    
    
}
