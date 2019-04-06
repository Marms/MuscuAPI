package fr.df.muscu.api.web.v1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jayway.jsonpath.Option;

import fr.df.muscu.api.model.ExoPredef;
import fr.df.muscu.api.service.ExoPredefService;

@RestController
public class ExopredefController {

	@Autowired
	private ExoPredefService exoPredefService;
	
    @RequestMapping(value= "/v1/exopredef/list", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Collection<ExoPredef> get() {
		Collection<ExoPredef> list = exoPredefService.list();
		System.out.println("ExoPRedef get size " + list.size());
		return list;
	}

    @RequestMapping(value="/v1/exopredef", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void post(@RequestBody ExoPredef exo) {
    	ExoPredef save = exoPredefService.save(exo);
    	System.out.println(save.getId());
    }
	
    
    @RequestMapping(value="/v1/exopredef/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ExoPredef getSingle(@PathVariable("id") String id) {
    	System.out.println("id = "+id);
    	Optional<ExoPredef> exo = Optional.of(exoPredefService.find(id));
    	if(exo.isPresent()) {
    		System.out.println(exo.get().getName());
    		return exo.get();
    	} else {
    		System.out.println("aucun exo ne possede cette id");
    	}
    	return null;
    	
    }
	
}
