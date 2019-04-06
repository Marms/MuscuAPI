package fr.df.muscu.api.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.df.muscu.api.model.Exercice;
import fr.df.muscu.api.model.ExoPredef;
import fr.df.muscu.api.model.Seance;
import fr.df.muscu.api.model.Serie;
import fr.df.muscu.api.service.impl.ExerciceServiceImpl;
import fr.df.muscu.api.service.impl.ExoPredefServiceImpl;
import fr.df.muscu.api.service.impl.SeancesServiceImpl;
import fr.sport.muscu.api.Config;
import fr.sport.muscu.api.Main;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Config.class,  Main.class,
        ExerciceServiceImpl.class , SeancesServiceImpl.class, ExoPredefServiceImpl.class})

public class TestSeanceService {
    @Autowired private ExerciceService exerciceService;
    @Autowired private ExoPredefService exoService;
    @Autowired private SeanceService seanceService;

    Seance sc;
    Exercice sp1, sp2;
    ExoPredef ex1;
    Serie s;

    @Before
    public void setup() {
        sc = new Seance();
        sc.setDate(new Date());
        
        sp1 = new Exercice();
        sp2 = new Exercice();
        
        ex1 = new ExoPredef();
        ex1.setComment("comment");
        ex1.setName("Dev couche");
        ex1.setImage("Image");
  
        exoService.save(ex1);
        sp1.setExoPredef(ex1);
 
        s = new Serie();
        s.setNbRepeat(10);
        s.setPoids(100);
        s.setNumero(1);
        
        sp1.getSeries().add(s);
        
        Serie s2 = new Serie();
        s2.setNbRepeat(10);
        s2.setPoids(222);
        s2.setNumero(1);
        sp2.getSeries().add(s2);
        
        sc.getExercices().add(sp1);
        sc.getExercices().add(sp2);
    }
 
    @Test
    public void testSave() {
        seanceService.save(sc);
        Assert.assertNotNull(sc.getId());    
        System.out.println( "\n" + sc);
    }

    @Test
    public void testList() {
        seanceService.save(sc);
        
//        Assert.assertTrue(list.size()> 0);
    }

    @Test
    public void testDelete() {
        seanceService.save(sc);
        Assert.assertNotNull(sc.getId());
        seanceService.delete(sc);
        Assert.assertTrue(seanceService.find(sc.getId()) == null);

    }
}
