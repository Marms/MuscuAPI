package fr.df.muscu.api.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.df.muscu.api.model.Exercice;
import fr.df.muscu.api.repositories.ExerciceDao;
import fr.df.muscu.api.service.ExerciceService;

@Service
public class ExerciceServiceImpl implements ExerciceService {
	
	
    @Autowired private ExerciceDao exerciceDao;
    
    @Override
    public Exercice save(Exercice exo) {

        return exerciceDao.save(exo);
    }

    @Override
    public List<Exercice> list() {
        return (List<Exercice>) exerciceDao.findAll();
        
    }

    @Override
    public Exercice find(Integer id) {

        return exerciceDao.findOne(id);
    }

    @Override
    public void delete(Exercice exo) {
        delete(exo.getId());
        
    }

    @Override
    public void delete(Integer id) {
        exerciceDao.delete(id);
    }

}
