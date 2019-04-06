package fr.df.muscu.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.df.muscu.api.model.SeancePredef;
import fr.df.muscu.api.repositories.SeancePredefDao;
import fr.df.muscu.api.service.SeancePredefService;

@Service
public class SeancePredefServiceImpl implements SeancePredefService{

    @Autowired private SeancePredefDao seancePredefDao;
    @Override
    public SeancePredef save(SeancePredef seancePredef) {
      return seancePredefDao.save(seancePredef);
    }

    @Override
    public List<SeancePredef> list() {
        
        return (List<SeancePredef>) seancePredefDao.findAll();
    }

    @Override
    public SeancePredef find(Integer id) {
        return seancePredefDao.findOne(id);
    }

    @Override
    public void delete(SeancePredef seancePredef) {
        delete(seancePredef.getId());
    }

    @Override
    public void delete(Integer id) {
        seancePredefDao.delete(id);
    }
}
