package fr.df.muscu.api.repositories;

import org.springframework.data.repository.CrudRepository;
import fr.df.muscu.api.model.Serie;

public interface SerieDao extends CrudRepository<Serie, Integer> {

}
