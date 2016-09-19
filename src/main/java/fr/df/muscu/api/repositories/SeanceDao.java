package fr.df.muscu.api.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.df.muscu.api.model.Seance;

public interface SeanceDao extends CrudRepository<Seance, Integer> {

}
