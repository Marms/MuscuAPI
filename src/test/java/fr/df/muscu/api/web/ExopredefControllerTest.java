package fr.df.muscu.api.web;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import fr.df.muscu.api.model.ExoPredef;

public class ExopredefControllerTest {

	
	@Test
	public void test() {
		RestTemplate rest = new RestTemplate();
		ExoPredef exo = new ExoPredef();
		exo.setName("maem");
		exo.setComment("commonet");
		rest.postForEntity("http://localhost:9000/v1/exopredef", exo, Void.class);
	}

	@Test
	public void secondTest() {
		RestTemplate rest = new RestTemplate();
		ExoPredef test =  rest.getForEntity("http://localhost:9000/v1/exopredef", ExoPredef.class).getBody();
		String name = test.getName();
		Assert.assertTrue("test".equals(name));
	}

}
