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
import fr.df.muscu.api.model.Serie;
import fr.df.muscu.api.service.ExerciceService;
import fr.df.muscu.api.service.SeanceService;

@RestController
public class SerieController {

	@Autowired
	private ExerciceService exerciceService;

	@Autowired
	private SeanceService seanceService;
	

	/**
	 * Permet de retourner les serie appartenant a un exercice d'une serie fournis en parametre
	 * 
	 * @param scId
	 * @return
	 * @throws Exception 
	 */
    @RequestMapping(value= "/v1/seance/{seanceId}/exercice/{exerciceId}/serie/list", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Collection<Serie> get(@PathVariable("seanceId") Integer scId, @PathVariable("exerciceId") Integer exId) throws Exception {
    	Exercice ex = getExercice(exId);
		Collection<Serie> list = ex.getSeries();
		System.out.println("Exercice size " + list.size());
		return list;
	}

    /** Ajoute une serie a l'exercice 
     * @throws Exception **/
    @RequestMapping(value="/v1/seance/{seanceId}/exercice/{exerciceId}/serie", method= RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Serie addSerieToExercice (@PathVariable("seanceId") Integer scId, @PathVariable("exerciceId") Integer exId, @RequestBody Serie serie) throws Exception {
    	Exercice ex = getExercice(exId);
    	Collection<Serie> series = ex.getSeries();
    	serie.setNumero(series.size());
    	series.add(serie);
    	exerciceService.save(ex);
    	return serie;
    }
    
    /**
     * Update une serie 
     * @param scId seanceID non utilise
     * @param exId exerciceID
     * @param serie la serie a modifier
     * @return 
     * @throws Exception 
     */
    @RequestMapping(value="/v1/seance/{seanceId}/exercice/{exerciceId}/serie/{serieId}", method= RequestMethod.PATCH, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Serie updateSerie (@PathVariable("seanceId") Integer scId, @PathVariable("exerciceId") Integer exId, @PathVariable("serieId") Integer serieId, @RequestBody Serie serie) throws Exception {
    	Exercice ex = getExercice(exId);
        Serie s = getSerie(ex, serie);
        s.setPoids(serie.getPoids());
        s.setNbRepeat(serie.getNbRepeat());
        s.setRepos(serie.getRepos());
        s.setSerie(serie.getSerie());
        exerciceService.save(ex);
        return s;    	
    }
   
    @RequestMapping(value="/v1/seance/{seanceId}/exercice/{exerciceId}/serie/{numero}", method= RequestMethod.DELETE)
    public @ResponseBody Exercice deleteSerie(@PathVariable("seanceId") Integer scId, @PathVariable("exerciceId") Integer exId, @PathVariable("numero") Integer numero) throws Exception {
    	Exercice ex = getExercice(exId);
    	// modification des numero de serie de la serie
    	Serie s = ex.getSeries().get(numero);
    	for (int i= numero +1; i < ex.getSeries().size(); i++) {
    		ex.getSeries().get(i).setNumero(i-1);
    	}
    	ex.getSeries().remove(s);
    	if (ex.getSeries().size() == 0) {
    		exerciceService.delete(ex);
    	} else {    		
    		exerciceService.save(ex);
    	}
    	return ex;
    }

    private Exercice getExercice(Integer exId) throws Exception {
    	Exercice ex = exerciceService.find(exId);
    	if (null == ex) {
    		throw new Exception("l'exercice n existe pas");
    	}
    	return ex;
    }

    private Serie getSerie(Exercice ex, Serie serie) throws Exception{
   	 	if (null == serie.getNumero()) {
        	throw new Exception("la serie n'existe pas");
        }
   	 	return ex.getSeries().get(serie.getNumero());
    }
}
