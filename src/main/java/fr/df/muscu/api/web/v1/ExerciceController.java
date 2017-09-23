package fr.df.muscu.api.web.v1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
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
import fr.df.muscu.api.model.Seance;
import fr.df.muscu.api.model.Serie;
import fr.df.muscu.api.service.ExerciceService;
import fr.df.muscu.api.service.ExoPredefService;
import fr.df.muscu.api.service.SeanceService;
import fr.df.muscu.api.service.SerieService;

@RestController
public class ExerciceController {

	@Autowired
	private ExerciceService exerciceService;

	@Autowired
	private ExoPredefService exoPredefService;

	@Autowired
	private SeanceService seanceService;

	@Autowired
	private SerieService serieSvc;
	/**
	 * Permet de retourner les exercices appartenant a une seance fournis en
	 * parametre
	 * 
	 * @param scId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1/seance/{seanceId}/exercice/list", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody Collection<Exercice> get(@PathVariable("seanceId") Integer scId) throws Exception {
		Seance sc = seanceService.find(scId);
		if (null == sc) {
			throw new Exception("la seance n'existe pas");
		}
		Collection<Exercice> list = sc.getExercices();
		System.out.println("Exercice size " + list.size());
		return list;
	}

	@RequestMapping(value = "/v1/seance/{seanceId}/exercice", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody Exercice addExerciceToSeance(@PathVariable("seanceId") Integer scId, @RequestBody Exercice exo)
			throws Exception {
		Seance sc = seanceService.find(scId);
		if (null == sc) {
			throw new Exception("la seance n'existe pas " + scId);
		}
		sc.getExercices().add(exo);
		seanceService.save(sc);
		return exo;
	}

	/**
	 * Renvoi l'exercice correspondant a l'exerciceId, si l'exercice n'existe
	 * pas, recherche un exercice dans la seance dont l'exoPredef.id = exoId si
	 * il exist renvoi l'exo sinon verifie que l exoId correspond a un
	 * exoTemplate existant creer un nouveau exercice dans al seance
	 * 
	 * @param scId
	 * @param exId
	 *            peut etre un exerciceId est un exoPredefId
	 * @return
	 * @throws Exception
	 *             si la seance n existe pas si l exercice n'existe pas ni le
	 *             template
	 */
	@RequestMapping(value = "/v1/seance/{seanceId}/exercice/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody Exercice getExercice(@PathVariable("seanceId") Integer scId, @PathVariable("id") String exId)
			throws Exception {
		Exercice exo = null;
		if (StringUtils.isNumeric(exId)) {
			// il s'agit d'un exercice
			exo = exerciceService.find(Integer.valueOf(exId));
			if (null == exo) {
				throw new Exception("l'exercice n'existe pas");
			}

		} else {
			System.out.println("ID recup de type exoPredef");
			// recupere le template dans la seance
			Seance sc = seanceService.find(scId);
			if (null == sc) {
				throw new Exception("la seance n'existe pas " + scId);
			}
			Optional<Exercice> ex = sc.getExercices().stream().filter((x) -> x.getExoPredef().getId().equals(exId))
					.findFirst();
			if (ex.isPresent()) {
				System.out.println("exercice present dans la seance");
				return ex.get();
			} else {
				System.out.println("ajout d'un exercice ");
				ExoPredef template = exoPredefService.find(exId);
				if (null == template) {
					throw new Exception("Impossible de creer un exercice dont le template n existe pas" + exId);
				}
				exo = new Exercice(); // TODO creer constructeur
				exo.setExoPredef(template);
				exo.setDate(new Date());
				exo.setNumero(sc.getExercices().size());
				sc.getExercices().add(exo);
				seanceService.save(sc);
			}
		}
		return exo;
	}
	
	 /**
     * Permet de recuperer toutes les series effectuee sur ce template
     * si le seancePredefId est fournit ne recupere uniquement les serie effectuee ce template pour le type de seance 
     */
    @RequestMapping(value= "/v1/exercice/{exoPredefId}/list", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Page<Exercice> getOldSerie(@PathVariable("exoPredefId") String exoPredefId, @RequestParam(value="scPredefId", required=false) String scPredefId 
			,@RequestParam(value = "page", required = false) Integer offset
			,   @RequestParam(value = "per_page", required = false) Integer limit
			) throws Exception {
    	Page<Exercice> list;
    	if (null != scPredefId) {
    		System.out.println("recherche par seance");
    		// recherche de toutes les seance
    		throw new Exception("not implemented yet");
    		// recuperation de tout les exercices comportant le scId
    	} else {
    		ExoPredef exo = exoPredefService.find(exoPredefId);
    		if (null == exo) {
    			throw new Exception("l exoPredef n'existe pas");
    		}
    		//recuperation de tout les exercice ayant cet exoPredefId;
    		list = exerciceService.listByExoPredef(PaginationUtil.generatePageRequest(offset, limit), exo);
    	}
    	System.out.println("Exercice size " + list.getNumberOfElements());
		return list;
	}
    
    @RequestMapping(value="/v1/seance/{seanceId}/exercice/{exerciceId}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Exercice deleteExo(@PathVariable("seanceId") Integer seanceId, @PathVariable("exerciceId") Integer exerciceId) throws Exception {
    	// recuperation de l'exo
    	Exercice ex = exerciceService.find(exerciceId);
    	if (null == ex) {
    		throw new Exception("l exercice n'existe pas");
    	}
    	// suppression de tous les exercices
    	List<Serie> listSerie = ex.getSeries();
    	
    	ex.setSeries(new ArrayList<>());
    	exerciceService.save(ex);
    	if (null != listSerie && listSerie.size() > 0) {
    	for (Serie s:listSerie) {
    		serieSvc.delete(s.getId());
    	}}
    	// suppression de l'exo
    	Seance seance = seanceService.find(seanceId);
    	seance.getExercices().remove(ex);
    	seanceService.save(seance);
    	exerciceService.delete(ex);
    	return ex;
    	
    }
}