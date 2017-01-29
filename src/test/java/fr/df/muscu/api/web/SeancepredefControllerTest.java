package fr.df.muscu.api.web;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import fr.df.muscu.api.model.ExoPredef;
import fr.df.muscu.api.model.SeancePredef;

public class SeancepredefControllerTest {

	private static final String URL = "http://localhost:9000/v1";
	
	SeancePredef seance = new SeancePredef();
	
	
	@Test
	public void test() {
		RestTemplate rest = new RestTemplate();
		
		seance.setName("pec/dos");
//		
		rest.postForEntity(URL + "/seancepredef", seance, Void.class);
	}

	@Test
	public void secondTest() {
		RestTemplate rest = new RestTemplate();
		SeancePredef test =  rest.getForEntity(URL + "/seance/list", SeancePredef.class).getBody();
		
		String name = test.getName();
		Assert.assertTrue("pec/dos".equals(name));
	}
	
	@Test
	public void testAddExoPredef() {
		RestTemplate rest = new RestTemplate();
		
		ExoPredef exo = new ExoPredef();
		exo.setName("maem");
		exo.setComment("commonet");
		
		rest.postForEntity(URL + "/seancepredef/7", exo,Void.class);
	}


	@Test
	public void testSaveSeanceWithNewExoPredef() {
		RestTemplate rest = new RestTemplate();
		
		ExoPredef exo = new ExoPredef();
		exo.setName("squat");
		exo.setComment("commentaire");
		
		SeancePredef test = new SeancePredef();
		test.setName("jambes");
		test.getList().add(exo);
		rest.postForEntity(URL + "/seancepredef", test,Void.class);
	}
	

	@Test
	public void testSaveSeanceWithExistingExoPredef() {
		RestTemplate rest = new RestTemplate();
		
		ExoPredef exo = new ExoPredef();
		exo.setId("1");
		
		SeancePredef test = new SeancePredef();
		test.setName("epaule");
		test.getList().add(exo);
		rest.postForEntity(URL + "/seancepredef", test,Void.class);
	}

}
