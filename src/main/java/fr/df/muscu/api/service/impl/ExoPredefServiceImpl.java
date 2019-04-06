/**
 * 
 */
package fr.df.muscu.api.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.df.muscu.api.model.ExoPredef;
import fr.df.muscu.api.model.Id;
import fr.df.muscu.api.repositories.ExoPredefDao;
import fr.df.muscu.api.repositories.IdDao;
import fr.df.muscu.api.service.ExoPredefService;
import groovy.transform.IndexedProperty;

/**
 * @author FD
 *
 */
@Service
public class ExoPredefServiceImpl implements ExoPredefService{
    @Autowired private ExoPredefDao exoPredefDao;
   
    @PersistenceContext
    public EntityManager em;

    @Autowired
    private IdDao idDao;
    
    @Override
    public ExoPredef save (ExoPredef exo) {
        if (null == exo.getId()) {
        	Id id = new Id();
        	id.setComment("");
        	id = idDao.save(new Id());
        	exo.setId("A".concat(id.getId().toString()));
        }
        exoPredefDao.save(exo);
        return exo;
    }

    @Override
    public List<ExoPredef> list() {
        return (List<ExoPredef>) exoPredefDao.findAll();
    }
    
    
    @Override
    public ExoPredef find (String id) {
        return exoPredefDao.findOne(id);
    }

    @Override
    public void delete(ExoPredef exo) {

        delete(exo.getId());
    }

    @Override
    public void delete(String id) {
        exoPredefDao.delete(id);
        
    }

}
