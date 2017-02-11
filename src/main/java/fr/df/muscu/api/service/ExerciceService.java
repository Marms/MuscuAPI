package fr.df.muscu.api.service;

import java.util.Collection;
import java.util.List;

import fr.df.muscu.api.model.Exercice;
import fr.df.muscu.api.model.ExoPredef;

public interface ExerciceService {
    Exercice save(Exercice exo) ;
    List<Exercice> list();
    Exercice find (Integer id);
    void delete(Exercice exo);
    void delete(Integer id);
	Collection<Exercice> listByExoPredef(ExoPredef exo);
}
