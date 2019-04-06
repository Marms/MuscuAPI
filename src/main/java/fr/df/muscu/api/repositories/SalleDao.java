package fr.df.muscu.api.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.df.muscu.api.model.Salle;

public interface SalleDao extends CrudRepository<Salle, Long> {

	List<Salle> findAll();
}
