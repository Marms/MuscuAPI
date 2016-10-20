package fr.df.muscu.api.web.v1;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.df.muscu.api.model.Seance;
import fr.df.muscu.api.service.SeanceService;

@RestController
public class SeanceController {

	@Autowired
	private SeanceService seanceService;
	

	/**
	 * Permet de retourner les exercices appartenant a une seance fournis en parametre
	 * 
	 * @param scId
	 * @return
	 */
    @RequestMapping(value= "/v1/seance/list", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Collection<Seance> get() {
		Collection<Seance> list = seanceService.list();
		System.out.println("seance size " + list.size());
		return list;
	}
    
    /**
	 * Permet de recuperer une seance par son id
	 * 
	 * @param scId
	 * @return
	 */
    @RequestMapping(value= "/v1/seance/{seanceId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Seance get(@PathVariable("seanceId") Integer scId) {
    	return seanceService.find(scId);
	}

    
    /**
     * Permet de creer une seance 
     */
    @RequestMapping(value ="/v1/seance", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}) 
    public @ResponseBody Seance createSeance(@RequestBody Seance sc) {
    	return seanceService.save(sc);
    }

    /**
     * Modifie une seance TODO a supprimer ? 
     * @param sc
     */
    @RequestMapping(value = "/v1/seance", method = RequestMethod.PATCH, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void update(@RequestBody Seance sc) {
    	seanceService.save(sc);
    }

}
