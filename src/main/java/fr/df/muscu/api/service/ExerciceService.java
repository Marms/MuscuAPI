package fr.df.muscu.api.service;

import java.util.List;

import fr.df.muscu.api.model.Exercice;

public interface ExerciceService {
    Exercice save(Exercice exo) ;
    List<Exercice> list();
    Exercice find (Integer id);
    void delete(Exercice exo);
    void delete(Integer id);
}
