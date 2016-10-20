package fr.df.muscu.api.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.df.muscu.api.model.ExoPredef;
import fr.df.muscu.api.service.ExoPredefService;
import fr.df.muscu.api.service.impl.ExoPredefServiceImpl;
import fr.sport.muscu.api.Config;
import fr.sport.muscu.api.Main;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Config.class,  Main.class,
        ExoPredefServiceImpl.class })
public class TestExoPredefService {

    @Autowired private ExoPredefService exo;
   
    ExoPredef ex1, ex2;
    
    @Before
    public void setup() {
        ex1 = new ExoPredef();
        ex1.setComment("comment");
        ex1.setName("name");
        ex1.setImage("Image");
        
        
        ex2 = new ExoPredef();
        ex2.setComment("comment2");
        ex2.setName("name2");
        ex2.setImage("image");
        
    }
    @Test
    public void testSave() {

        exo.save(ex1);
        Assert.assertNotNull(ex1.getId());
    }

    @Test
    public void testList() {
        exo.save(ex1);
        exo.save(ex2);
        
        List<ExoPredef> list = exo.list();
        Assert.assertTrue(list.size()> 1);
    }
    
    @Test
    public void testDelete() {
        exo.save(ex1);
        exo.delete(ex1);
        Assert.assertTrue(exo.find(ex1.getId()) == null);
    }
   
}
