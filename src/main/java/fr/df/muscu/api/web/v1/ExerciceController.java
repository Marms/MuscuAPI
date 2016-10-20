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

import fr.df.muscu.api.model.Exercice;
import fr.df.muscu.api.model.Seance;
import fr.df.muscu.api.service.ExerciceService;
import fr.df.muscu.api.service.SeanceService;

@RestController
public class ExerciceController {

	@Autowired
	private ExerciceService exerciceService;

	@Autowired
	private SeanceService seanceService;
	

	/**
	 * Permet de retourner les exercices appartenant a une seance fournis en parametre
	 * 
	 * @param scId
	 * @return
	 */
    @RequestMapping(value= "/v1/seance/{seanceId}/exercice/list", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Collection<Exercice> get(@PathVariable("seanceId") Integer scId) {
    	Seance sc = seanceService.find(scId);
    	if (null == sc) {
    		System.out.println("la seance n'existe pas");
    		return null;
    	}
		Collection<Exercice> list = sc.getExercices();
		System.out.println("Exercice size " + list.size());
		return list;
	}

    @RequestMapping(value="/v1/seance/{seanceId}/exercice", method= RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Exercice addExerciceToSeance (@PathVariable("seanceId") Integer scId, @RequestBody Exercice exo) {
    	Seance sc = seanceService.find(scId);
    	if (null == sc) {
    		System.out.println("la seance n'existe pas");
    		return null;
    	}
    	sc.getExercices().add(exo);
    	seanceService.save(sc);
    	return exo; //TODO check si id valorise
    }
    //TODO ajouter update exercice mettre les methods dans le controller de seance
   
}
