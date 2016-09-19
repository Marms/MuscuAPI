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

import fr.df.muscu.api.model.ExoPredef;
import fr.df.muscu.api.model.SeancePredef;
import fr.df.muscu.api.service.impl.ExoPredefServiceImpl;
import fr.df.muscu.api.service.impl.SeancePredefServiceImpl;
import fr.sport.muscu.api.Config;
import fr.sport.muscu.api.Main;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Config.class,  Main.class,
        SeancePredefServiceImpl.class })

public class TestSeancePredef {
    @Autowired private SeancePredefService seanceService;
    
    SeancePredef sp1, sp2;
    ExoPredef ex1, ex2;
    
    @Before
    public void setup() {
        sp1 = new SeancePredef();
        sp1.setName("name");
        
        sp2 = new SeancePredef();   
        sp2.setName("name2");
        
        ex1 = new ExoPredef();
        ex1.setComment("comment");
        ex1.setName("name");
        ex1.setImage("Image");
        
        ex2 = new ExoPredef();
        ex2.setComment("comment2");
        ex2.setName("name2");
        ex2.setImage("image");

        sp1.getList().add(ex1);
        sp1.getList().add(ex2);

    }
    @Test
    public void testSave() {

        seanceService.save(sp1);
        Assert.assertNotNull(sp1.getId());
        System.out.println(sp1);
    }

    @Test
    public void testList() {
        seanceService.save(sp1);
        seanceService.save(sp2);
        
        List<SeancePredef> list = seanceService.list();
        Assert.assertTrue(list.size()> 1);
    }
    
    @Test
    public void testDelete() {
        seanceService.save(sp1);
        seanceService.delete(sp1);
        Assert.assertTrue(seanceService.find(sp1.getId()) == null);

    }
}
