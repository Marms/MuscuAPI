package fr.df.muscu.api.service;

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
import fr.df.muscu.api.model.SeancePredef;
import fr.df.muscu.api.model.Serie;
import fr.df.muscu.api.repositories.ExerciceDao;
import fr.df.muscu.api.service.impl.ExerciceServiceImpl;
import fr.df.muscu.api.service.impl.ExoPredefServiceImpl;
import fr.sport.muscu.api.Config;
import fr.sport.muscu.api.Main;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Config.class,  Main.class,
        ExerciceServiceImpl.class , ExoPredefServiceImpl.class})
public class TestExercice {
    @Autowired private ExerciceService exerciceService;
    @Autowired private ExoPredefService exoService;
    
    Exercice sp1, sp2;
    ExoPredef ex1;
    Serie s;
    
    @Before
    public void setup() {
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
    }
 
    @Test
    public void testSave() {
        exerciceService.save(sp1);
        Assert.assertNotNull(sp1.getId());    

        exerciceService.save(sp2);
        Assert.assertNotNull(sp2.getId());
        System.out.println(sp1);
        System.out.println(sp2);
    }

    @Test
    public void testList() {
        exerciceService.save(sp1);
        exerciceService.save(sp2);
        
        List<Exercice> list = exerciceService.list();
        Assert.assertTrue(list.size()> 1);
    }

    @Test
    public void testDelete() {
        exerciceService.save(sp1);
        Assert.assertNotNull(sp1.getId());
        exerciceService.delete(sp1);
        Assert.assertTrue(exerciceService.find(sp1.getId()) == null);

    }

}
