package fr.df.muscu.api.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.df.muscu.api.model.Exercice;

public interface ExerciceDao extends CrudRepository<Exercice  ,Integer>{

}
