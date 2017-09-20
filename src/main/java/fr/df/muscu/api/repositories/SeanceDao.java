package fr.df.muscu.api.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import fr.df.muscu.api.model.Seance;

public interface SeanceDao extends CrudRepository<Seance, Integer> {

	Page<Seance> findAllByOrderByDateAsc(Pageable page);
}
