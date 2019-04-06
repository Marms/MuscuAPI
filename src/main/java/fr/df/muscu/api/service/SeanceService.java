package fr.df.muscu.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.df.muscu.api.model.Exercice;
import fr.df.muscu.api.model.Seance;

public interface SeanceService {
    
    Seance save(Seance exo) ;
    Page<Seance> list(Pageable page);
    Seance find (Integer id);
    void delete(Seance exo);
    void delete(Integer id);
	void deleteExoFromSeance(Exercice ex, Integer scId);
    
}
