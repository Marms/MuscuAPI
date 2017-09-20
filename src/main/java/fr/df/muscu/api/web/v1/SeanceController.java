package fr.df.muscu.api.web.v1;

import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.df.muscu.api.model.Exercice;
import fr.df.muscu.api.model.ExoPredef;
import fr.df.muscu.api.model.Salle;
import fr.df.muscu.api.model.Seance;
import fr.df.muscu.api.service.ExoPredefService;
import fr.df.muscu.api.service.SeanceService;

@RestController
public class SeanceController {

	@Autowired
	private SeanceService seanceService;
	@Autowired
	private ExoPredefService exoPredefService;
	

	/**
	 * Permet de retourner les exercices appartenant a une seance fournis en parametre
	 * 
	 * @param scId
	 * @return
	 */
    @RequestMapping(value= "/v1/seance/list", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Page<Seance> get(@RequestParam(value = "page", required = false) Integer offset,
            @RequestParam(value = "per_page", required = false) Integer limit)
                    throws URISyntaxException {
		Page<Seance> page = seanceService.list(
				PaginationUtil.generatePageRequest(offset, limit));
		
		System.out.println("seance size " + page.getNumberOfElements());
		return page;
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
    	// gestion de la date de la seance TODO
    	return seanceService.save(sc);
    }

    /**
     * Permet d'ajouter un exoPredef a la seance
     * @return l'exercice cree.
     * @throws Exception 
     */
    @RequestMapping(value ="/v1/seance/{seanceId}/exoPredef/{exoPredefId}", method = RequestMethod.POST)
    public @ResponseBody Exercice addExerciceToSeance(@PathVariable("seanceId") Integer scId, @PathVariable("exoPredefId") String expId) throws Exception {
    	Seance sc = seanceService.find(scId);
    	if (null == sc) {
    		throw new Exception("La seance n'existe pas");
    	}
    	ExoPredef exoP = exoPredefService.find(expId);
    	if (null == exoP) {
    		throw new Exception("Le template d'exercice n'existe pas");
    	}
    	Exercice ex = new Exercice();
    	ex.setExoPredef(exoP);
    	sc.getExercices().add(ex);
    	
    	seanceService.save(sc);
    	return ex;
    }
    
    
    
    /**
     * Modifie une seance TODO a supprimer ? 
     * @param sc
     */
    @RequestMapping(value = "/v1/seance", method = RequestMethod.PATCH, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void update(@RequestBody Seance sc) {
    	seanceService.save(sc);
    }

    /**
     * Ajoute des salle à la seance
     * @throws Exception 
     */
    @RequestMapping(value="/v1/seance/{scId}/salle", method = RequestMethod.POST)
    public void addSallesToSeance(@PathVariable("scId") Integer scId, @RequestBody List<Salle> salles) throws Exception {
    	Seance sc = seanceService.find(scId);
    	if (null == sc) {
    		throw new Exception("La seance n'existe pas");
    	}
    	// ne garder que les salles non présente dans la nouvelle list
   		sc.setSalles(sc.getSalles().stream().filter(x -> !salles.contains(x)).collect(Collectors.toList()));
   		sc.getSalles().addAll(salles);
   		seanceService.save(sc);
    }
}
