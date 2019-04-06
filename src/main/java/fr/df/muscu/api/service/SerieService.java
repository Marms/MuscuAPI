package fr.df.muscu.api.service;

import java.util.List;

import fr.df.muscu.api.model.Seance;
import fr.df.muscu.api.model.Serie;
/**
 * @author Florent
 */
public interface SerieService {
    
    Serie save(Serie se) ;
    List<Serie> list();
    Serie find (Integer id);
    void delete(Serie serie);
    void delete(Integer id);
    
}
