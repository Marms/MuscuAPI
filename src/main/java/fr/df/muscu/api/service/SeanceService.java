package fr.df.muscu.api.service;

import java.util.List;

import fr.df.muscu.api.model.Exercice;
import fr.df.muscu.api.model.Seance;

public interface SeanceService {
    
    Seance save(Seance exo) ;
    List<Seance> list();
    Seance find (Integer id);
    void delete(Seance exo);
    void delete(Integer id);
	void deleteExoFromSeance(Exercice ex, Integer scId);
    
}
