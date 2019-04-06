package fr.df.muscu.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.df.muscu.api.model.Serie;
import fr.df.muscu.api.repositories.SerieDao;
import fr.df.muscu.api.service.SerieService;

@Service
public class SerieServiceImpl implements SerieService {
    @Autowired private SerieDao serieDao;
    
    @Override
    public Serie save(Serie se) {
    	return serieDao.save(se);
    }

    @Override
    public List<Serie> list() {
        return (List<Serie>) serieDao.findAll();
    }

    @Override
    public Serie find(Integer id) {
        return serieDao.findOne(id);
    }

    @Override
    public void delete(Serie se) {
        delete(se.getId());
    }

    @Override
    public void delete(Integer id) {
        serieDao.delete(id);
    }
}
