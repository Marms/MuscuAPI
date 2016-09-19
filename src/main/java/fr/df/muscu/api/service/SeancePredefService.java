package fr.df.muscu.api.service;

import java.util.List;

import fr.df.muscu.api.model.SeancePredef;

public interface SeancePredefService {

    SeancePredef save(SeancePredef seancePredef); 
    List<SeancePredef> list();
    SeancePredef find(Integer id);
    void delete(SeancePredef seancePredef);
    void delete(Integer id);
}
