package fr.df.muscu.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.df.muscu.api.model.Exercice;
import fr.df.muscu.api.model.ExoPredef;

public interface ExerciceService {
    Exercice save(Exercice exo) ;
    List<Exercice> list();
    Exercice find (Integer id);
    void delete(Exercice exo);
    void delete(Integer id);
	Page<Exercice> listByExoPredef(Pageable page, ExoPredef exo);
}
