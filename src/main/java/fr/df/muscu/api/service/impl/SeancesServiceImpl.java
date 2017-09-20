package fr.df.muscu.api.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.df.muscu.api.model.Exercice;
import fr.df.muscu.api.model.Seance;
import fr.df.muscu.api.repositories.ExerciceDao;
import fr.df.muscu.api.repositories.SeanceDao;
import fr.df.muscu.api.service.SeanceService;

@Service
public class SeancesServiceImpl implements SeanceService {
    @Autowired private SeanceDao seanceDao;
    @Autowired private ExerciceDao exo;
    
    @Override
    public Seance save(Seance sc) {
    	if (null == sc.getDate()) {
    		sc.setDate(new Date());
    	}
    	for(Exercice ex : sc.getExercices()) {
    		exo.save(ex);
    	}
        return seanceDao.save(sc);
    }

    @Override
    public Page<Seance> list(Pageable page) {
        return (Page<Seance>) seanceDao.findAllByOrderByDateDesc(page);
    }

    @Override
    public Seance find(Integer id) {
        return seanceDao.findOne(id);
    }

    @Override
    public void delete(Seance exo) {
        delete(exo.getId());
    }

    @Override
    public void delete(Integer id) {
        seanceDao.delete(id);
    }

	@Override
	public void deleteExoFromSeance(Exercice ex, Integer scId) {
	    Seance sc = find(scId);
		sc.getExercices().remove(ex);
		save(sc);
	}
}