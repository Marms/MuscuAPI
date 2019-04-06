package fr.df.muscu.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.df.muscu.api.model.Salle;
import fr.df.muscu.api.repositories.SalleDao;
import fr.df.muscu.api.service.SalleService;

@Service
public class SalleServiceImpl implements SalleService {
	@Autowired
	private SalleDao SalleDao;

    @Override
    public Salle save(Salle sc) {
        return SalleDao.save(sc);
    }

    @Override
    public List<Salle> list() {
        return (List<Salle>) SalleDao.findAll();
    }

    @Override
    public Salle find(Long id) {
        return SalleDao.findOne(id);
    }

    @Override
    public void delete(Salle exo) {
        delete(exo.getId());
    }

    @Override
    public void delete(Long id) {
        SalleDao.delete(id);
    }

}