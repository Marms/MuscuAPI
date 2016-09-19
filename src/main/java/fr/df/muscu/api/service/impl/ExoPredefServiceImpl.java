/**
 * 
 */
package fr.df.muscu.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.df.muscu.api.model.ExoPredef;
import fr.df.muscu.api.repositories.ExoPredefDao;
import fr.df.muscu.api.service.ExoPredefService;

/**
 * @author FD
 *
 */
@Service
public class ExoPredefServiceImpl implements ExoPredefService{
    @Autowired private ExoPredefDao exoPredefDao;
   
    @Override
    public ExoPredef save (ExoPredef exo) {
        exoPredefDao.save(exo);
        return exo;
    }

    @Override
    public List<ExoPredef> list() {
        return (List<ExoPredef>) exoPredefDao.findAll();
    }
    
    
    @Override
    public ExoPredef find (Integer id) {
        return exoPredefDao.findOne(id);
    }

    @Override
    public void delete(ExoPredef exo) {

        delete(exo.getId());
    }

    @Override
    public void delete(Integer id) {
        exoPredefDao.delete(id);
        
    }

}
