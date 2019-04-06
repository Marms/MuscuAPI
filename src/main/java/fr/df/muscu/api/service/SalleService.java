package fr.df.muscu.api.service;

import java.util.List;

import fr.df.muscu.api.model.Salle;

public interface SalleService {
    
    Salle save(Salle exo) ;
    List<Salle> list();
    void delete(Salle exo);
	Salle find(Long id);
	void delete(Long id);
    
}
