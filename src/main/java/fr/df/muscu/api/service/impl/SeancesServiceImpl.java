package fr.df.muscu.api.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Seance> list() {
        return (List<Seance>) seanceDao.findAll();
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

}