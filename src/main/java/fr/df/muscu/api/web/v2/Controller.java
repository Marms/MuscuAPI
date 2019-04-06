package fr.df.muscu.api.web.v2;

import fr.df.muscu.api.model.ExoPredef;
import fr.df.muscu.api.model.Seance;
import fr.df.muscu.api.model.SeancePredef;
import fr.df.muscu.api.web.v1.ExopredefController;
import fr.df.muscu.api.web.v1.SeanceController;
import fr.df.muscu.api.web.v1.SeancePredefController;
import fr.df.muscu.api.web.v2.model.ExerciceTemplateV2;
import fr.df.muscu.api.web.v2.model.SeanceTemplateV2;
import fr.df.muscu.api.web.v2.model.SeanceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

/**
 * Facade qui fais le lien entre la v1 et la v2
 */
@RestController
public class Controller {

    @Autowired
    private SeancePredefController scPredefCtrl;

    @Autowired
    private ExopredefController exopredefController;

    @Autowired
    private SeanceController seanceController;


    // OnSave SeanceV2
    // onFetch SeanceV2

    // onFetch scTemplate
    @RequestMapping(value = "/{id}/seances", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<SeanceV2> onFetchSeance(@PathVariable(name = "id") String id) throws Exception{
        Page<Seance> list = this.seanceController.get(null, null);
        List<SeanceV2> res = list.getContent().stream().map(SeanceV2::toV2)
                .collect(Collectors.toList());
        return res;
    }
    
    //onSave scTemplate n
    @RequestMapping(value = "/{id}/template-seances", method = RequestMethod.POST, produces = {
            MediaType.APPLICATION_JSON_VALUE })
    public void onSaveScTemplate(@PathVariable(name = "id") String id, @RequestBody SeanceTemplateV2[] templates){
        // transformation d'object v2 en v1
        List<SeanceTemplateV2> list = Arrays.asList(templates);
        List<SeancePredef> v1 = list.stream().map(t -> t.toV1())
                .collect(Collectors.toList());
        v1.stream().map(v -> scPredefCtrl.post(v)).collect(Collectors.toList());
    }

    // onFetch scTemplate
    @RequestMapping(value = "/{id}/template-seances", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<SeanceTemplateV2> onFetchScTemplate(@PathVariable(name = "id") String id) {
        Collection<SeancePredef> list = this.scPredefCtrl.get();
        List<SeanceTemplateV2> res = list.stream().map(SeanceTemplateV2::toV2)
                .collect(Collectors.toList());
        return res;
    }

    // onSave exoTemplate
    //yWMgEKxgXMTlO156xZpyFFBdzF02/template-seances.json
    public void onSaveExotemplate(){

    }
    //onFetch exoTemplate

    // onFetch scTemplate
    @RequestMapping(value = "/{id}/template-exercises", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ExerciceTemplateV2> onFetchExoTemplate(@PathVariable(name = "id") String id) {
        Collection<ExoPredef> list = this.exopredefController.get();
        List<ExerciceTemplateV2> res = list.stream().map(ExerciceTemplateV2::toV2)
                .collect(Collectors.toList());
        return res;
    }
}

