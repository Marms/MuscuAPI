package fr.df.muscu.api.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import fr.df.muscu.api.model.Exercice;
import fr.df.muscu.api.model.ExoPredef;

public interface ExerciceDao extends CrudRepository<Exercice  ,Integer>{
	 
	/**
	 *  retourne les exercices ayant l'exoPredef fournis en param
	 * @param exo
	 * @return
	 */
	Collection<Exercice> findByExoPredefOrderByDateAsc(ExoPredef exo);
}
