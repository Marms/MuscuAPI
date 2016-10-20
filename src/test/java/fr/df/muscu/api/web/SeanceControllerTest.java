package fr.df.muscu.api.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.mapping.Collection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import fr.df.muscu.api.model.Seance;
import fr.df.muscu.api.model.SeancePredef;

public class SeanceControllerTest {

	private static final String URL = "http://localhost:9000/v1";
	
	static Seance sc1, sc2;
	
	private static SeancePredef scp;
	List<Seance> list;
	RestTemplate rest;
	
	@BeforeClass
	public static void initSeancePredef () throws ParseException {
		RestTemplate rte = new RestTemplate();
		scp = new SeancePredef("pectoraux");
		scp = rte.postForEntity(URL + "/seancepredef/", scp, SeancePredef.class).getBody();
		
		sc1 = new Seance(new Date(), scp);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sc2 = new Seance(sdf.parse("2016-10-10"), scp);
		
	}
	
	@Before
	public void init() throws ParseException {
		list = new ArrayList<>();
		rest = new RestTemplate();
		
		list.add(sc1);
		list.add(sc2);
	}

	/**
	 * Test creation de seance 
	 */
	@Test
	public void testCreateSeance() {
		ResponseEntity<Seance> res = rest.postForEntity(URL + "/seance", list.get(0), Seance.class);
		Assert.assertTrue(res.getStatusCode().equals(HttpStatus.OK));
	}
	
	/**
	 * Test liste seance
	 */
	@Test
	public void testListSeance () {
		rest.postForEntity(URL + "/seance",  list.get(0), Seance.class);
		rest.postForEntity(URL + "/seance",  list.get(1), Seance.class);
	
		ResponseEntity res = rest.getForEntity(URL + "/seance/list", List.class);
		Assert.assertTrue(res.getStatusCode().equals(HttpStatus.OK));
		List<Seance> list = (List<Seance>) res.getBody();
		Assert.assertFalse(list.isEmpty());
	}
	
	/**
	 * Test update seance
	 * @throws ParseException 
	 */
	@Test
	public void TestUpdateSeance() throws ParseException {
		ResponseEntity<Seance> res = rest.postForEntity(URL + "/seance",  list.get(1), Seance.class);
		Seance sc = res.getBody();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		sc.setDate(sdf.parse("2015-01-10"));
		rest.postForEntity(URL + "/seance",  sc, Seance.class);
		
		res = rest.getForEntity(URL + "/seance/"+sc.getId(), Seance.class);
		Assert.assertTrue(res.getBody().getDate().equals(sc.getDate()));
	}
}
