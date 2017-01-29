package fr.df.muscu.api.repositories;

import org.springframework.data.domain.Slice;
import org.springframework.data.repository.CrudRepository;

import fr.df.muscu.api.model.Id;

public interface IdDao extends CrudRepository<Id, Integer> {
}
