package fr.df.muscu.api.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.df.muscu.api.model.Seance;

public interface SeanceDao extends CrudRepository<Seance, Integer> {

	List<Seance> findAllByOrderByDateAsc();
}
