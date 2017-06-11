package fr.df.muscu.api.web.v1;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.df.muscu.api.model.Salle;
import fr.df.muscu.api.service.SalleService;

@RestController
public class SalleController {

	@Autowired
	private SalleService salleService;
	
	/**
	 * Lister les Salles
	 * @return
	 */
    @RequestMapping(value= "/v1/salle/list", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Collection<Salle> get() {
		Collection<Salle> list = salleService.list();
		System.out.println("Salle get size " + list.size());
		return list;
	}

    /**
     * CREATION d'une Salle
     * @param salle
     */
    @RequestMapping(value="/v1/salle", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Salle post(@RequestBody Salle salle) {
    	Salle save = salleService.save(salle);
    	System.out.println(save.getId());
    	return save;
    }
	
    /**
     * 
     * @param id
     */
    @RequestMapping(value="/v1/salle/{id}", method= RequestMethod.DELETE) //produces = {MediaType.APPLICATION_JSON_VALUE}
    public void deleteSalle(@PathVariable("id") Long id) {
    	salleService.delete(id);
    }
    
    
    /**
     * Permet de recuperer une salle avec son ID 
     * 
     * @param id
     * @return
     */
    @RequestMapping(value="/v1/salle/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Salle getSingle(@PathVariable("id") Long id) {
    	System.out.println("id = "+id);
    	Optional<Salle> exo = Optional.of(salleService.find(id));
    	if(exo.isPresent()) {
    		System.out.println(exo.get().getName());
    		return exo.get();
    	} else {
    		System.out.println("aucun exo ne possede cette id");
    	}
    	return null;
    }
}