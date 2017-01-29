package fr.df.muscu.api.web.v1;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.df.muscu.api.model.ExoPredef;
import fr.df.muscu.api.model.SeancePredef;
import fr.df.muscu.api.service.ExoPredefService;
import fr.df.muscu.api.service.SeancePredefService;

@RestController
public class SeancePredefController {

	@Autowired
	private SeancePredefService seancepredefService;
	
	@Autowired
	private ExoPredefService exopredefService;
	
	/**
	 * Lister les seancePredef
	 * @return
	 */
    @RequestMapping(value= "/v1/seancepredef/list", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Collection<SeancePredef> get() {
		Collection<SeancePredef> list = seancepredefService.list();
		System.out.println("seancepredef get size " + list.size());
		return list;
	}

    /**
     * CREATION d'une seancePredef
     * @param exo
     */
    @RequestMapping(value="/v1/seancepredef", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public SeancePredef post(@RequestBody SeancePredef exo) {
    	SeancePredef save = seancepredefService.save(exo);
    	System.out.println(save.getId());
    	return save;
    }
	
    /**
     * Ajout d'un exo a une seance predefinie
     * @param id
     * @param exo
     */
    @RequestMapping(value="/v1/seancepredef/{id}", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void addExoPredef(@PathVariable("id") int id, @RequestBody ExoPredef exo) {
    	SeancePredef seance = seancepredefService.find(id);
    	if (null != seance) {
    		seance.getList().add(exo);
    		seancepredefService.save(seance);    		
    		System.out.println(seance.getName() + " list exo " + seance.getList().size());
    	} else {
    		System.out.println("seance null");
    	}    	
    }
    
    /**
     * 
     * @param id
     * @param exoId
     */
    @RequestMapping(value="/v1/seancepredef/{id}/exopredef/{exoPredef}", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void addExoPredefById(@PathVariable("id") int id, @PathVariable("exoPredef") String  exoId) {
    	SeancePredef seance = seancepredefService.find(id);
    	if (null != seance) {
    		ExoPredef exoPredef = exopredefService.find(exoId);
    		if (null != exoPredef) {
    			seance.getList().add(exoPredef);
    			seancepredefService.save(seance);    		    			
    		} else {
    			System.out.println("exo null");
    		}
    		System.out.println(seance.getName() + " list exo " + seance.getList().size());
    	} else {
    		System.out.println("seance null");
    	}    	
    }
    
    @RequestMapping(value="/v1/seancepredef/{id}", method= RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void deleteSeancePredef(@PathVariable("id") Integer id) {
    	seancepredefService.delete(id);
    }
    
    /**
     * Delete
     * @param id
     * @param exoId
     */
    @RequestMapping(value="/v1/seancepredef/{id}/exopredef/{exoId}", method= RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void deleteExoPredefFromSeancePredef(@PathVariable("id") Integer id, @PathVariable("exoId") Integer exoId) {
    	SeancePredef seance = seancepredefService.find(id);
    	if (null != seance) {
    		// suppression de l'exoPredef de la seancePredef, un exoPredef peut faire partie d'une autre seancePredef
    		System.out.println("item list " + seance.getList().size()); 
    		seance.setList(seance.getList().stream().filter(x -> ! x.getId().equals(exoId)).collect(Collectors.toList()));
    		System.out.println("new item list " + seance.getList().size()); 
    		seancepredefService.save(seance);
    	} else {
    		System.out.println("seance null");
    	}
    }
    
    /**
     * Permet de recuperer une seance predefinie avec son ID 
     * 
     * @param id
     * @return
     */
    @RequestMapping(value="/v1/seancepredef/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody SeancePredef getSingle(@PathVariable("id") Integer id) {
    	System.out.println("id = "+id);
    	Optional<SeancePredef> exo = Optional.of(seancepredefService.find(id));
    	if(exo.isPresent()) {
    		System.out.println(exo.get().getName());
    		return exo.get();
    	} else {
    		System.out.println("aucun exo ne possede cette id");
    	}
    	return null;
    }
	
}
