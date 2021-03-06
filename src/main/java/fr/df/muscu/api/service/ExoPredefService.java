package fr.df.muscu.api.service;

import java.util.List;

import fr.df.muscu.api.model.ExoPredef;

public interface ExoPredefService {
    ExoPredef save(ExoPredef exo) ;
    List<ExoPredef> list();
    ExoPredef find (String id);
    void delete(ExoPredef exo);
    void delete(String id);
}
