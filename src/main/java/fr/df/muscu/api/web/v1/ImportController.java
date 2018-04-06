package fr.df.muscu.api.web.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.df.muscu.api.model.ExoPredef;
import fr.df.muscu.api.model.Seance;
import fr.df.muscu.api.model.SeancePredef;
import fr.df.muscu.api.service.ExoPredefService;
import fr.df.muscu.api.service.SeancePredefService;
import fr.df.muscu.api.service.SeanceService;

@RestController
public class ImportController {

    @Autowired private SeanceService seanceSvc;
    @Autowired private ExoPredefService exoPredefSvc;
    @Autowired private SeancePredefService seancePredefSvc;



    /**
     * Ajoute une serie a l'exercice
     *
     * @throws Exception
     **/
    @RequestMapping(value = "/v1/import/template-seance/list", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody List<SeancePredef> importSeanceTypes(@RequestBody List<SeancePredef> seancePredefs) throws Exception {
        for (SeancePredef sc: seancePredefs) {
            seancePredefSvc.save(sc);
        }
        return seancePredefs;
    }

    // [{"id":"A1","name":"DEV COUCHE HALTERE","comment":null,"image":null,"type":["PECTORAUX"]},{"id":"A10","name":"BICEPS CURL GIRONDA","comment":null,"image":null,"type":["BRAS"]},{"id":"A100","name":"CURL INVERSE haltere","comment":null,"image":null,"type":["BRAS"]},{"id":"A101","name":"PRESSE ÉPAULE","comment":null,"image":null,"type":["EPAULES"]},{"id":"A102","name":"Trapèze inférieur suspendu","comment":null,"image":null,"type":["DOS"]},{"id":"A103","name":"KNEELING LE CURL","comment":null,"image":null,"type":["JAMBES"]},{"id":"A104","name":"Standing leg curl","comment":null,"image":null,"type":["JAMBES"]},{"id":"A105","name":"FLEXION BICEPS MACHINE","comment":null,"image":null,"type":["BRAS"]},{"id":"A106","name":"EXTENSION TRICEPS MACHINE","comment":null,"image":null,"type":["BRAS"]},{"id":"A107","name":"TRiceps haut machine","comment":null,"image":null,"type":["BRAS"]},{"id":"A108","name":"MTS ROWING","comment":null,"image":null,"type":["DOS"]},{"id":"A109","name":"Trapèze inférieur DIPS","comment":null,"image":null,"type":["DOS"]},{"id":"A11","name":"BICEPS CURL EZ","comment":null,"image":null,"type":["BRAS"]},{"id":"A110","name":"LOW ROW machine","comment":null,"image":null,"type":["DOS"]},{"id":"A111","name":"PULL OVER MACHINE","comment":null,"image":null,"type":["DOS"]},{"id":"A112","name":"Shoulder press","comment":null,"image":null,"type":["EPAULES"]},{"id":"A113","name":"Extension lateral machine","comment":null,"image":null,"type":["EPAULES"]},{"id":"A114","name":"Deltoid antérieure fly machine","comment":null,"image":null,"type":["EPAULES"]},{"id":"A115","name":"PRESSE pêc fly","comment":null,"image":null,"type":["PECTORAUX"]},{"id":"A116","name":"PRESSE pecs horizontal","comment":null,"image":null,"type":["PECTORAUX"]},{"id":"A117","name":"Warm up","comment":null,"image":null,"type":["PECTORAUX"]},{"id":"A118","name":"Developpe assis machine (incliné)","comment":null,"image":null,"type":["PECTORAUX"]},{"id":"A119","name":"Iso lateral décline press","comment":null,"image":null,"type":["PECTORAUX"]},{"id":"A12","name":"BICEPS PRISE MARTEAU","comment":null,"image":null,"type":["BRAS"]},{"id":"A120","name":"Mollets debout machine","comment":null,"image":null,"type":["MOLLET"]},{"id":"A121","name":"Abduction des hanches","comment":null,"image":null,"type":["JAMBES"]},{"id":"A122","name":"Adduction des hanches","comment":null,"image":null,"type":["JAMBES"]},{"id":"A123","name":"DEV nuque","comment":null,"image":null,"type":["EPAULES"]},{"id":"A124","name":"DEV couché serré","comment":null,"image":null,"type":["BRAS"]},{"id":"A125","name":"Reverse dips","comment":null,"image":null,"type":["BRAS"]},{"id":"A126","name":"Back deltoid","comment":null,"image":null,"type":["EPAULES"]},{"id":"A127","name":"Fentes","comment":null,"image":null,"type":["JAMBES"]},{"id":"A128","name":"Abcoaster","comment":null,"image":null,"type":["ABDO"]},{"id":"A129","name":"Curl barre","comment":null,"image":null,"type":["BRAS"]},{"id":"A13","name":"TRICEPS POULIE HAUTE Corde","comment":null,"image":null,"type":["BRAS"]},{"id":"A130","name":"Curl poulie superlent","comment":null,"image":null,"type":["BRAS"]},{"id":"A131","name":"Extensions, allongé superlent","comment":null,"image":null,"type":["BRAS"]},{"id":"A132","name":"Curl poulie allongé","comment":null,"image":null,"type":["BRAS"]},{"id":"A133","name":"Developpe couché serré","comment":null,"image":null,"type":["BRAS"]},{"id":"A134","name":"Developpe couché serré","comment":null,"image":null,"type":["BRAS"]},{"id":"A135","name":"Curl poulie","comment":null,"image":null,"type":["BRAS"]},{"id":"A136","name":"Ecarté incliné","comment":null,"image":null,"type":["PECTORAUX"]},{"id":"A137","name":"SDT Tendu","comment":null,"image":null,"type":["JAMBES","DOS"]},{"id":"A138","name":"Dev incl haltères","comment":null,"image":null,"type":["PECTORAUX"]},{"id":"A139","name":"Triceps barre front poulie","comment":null,"image":null,"type":["BRAS"]},{"id":"A14","name":"TRICEPS K1","comment":null,"image":null,"type":["BRAS"]},{"id":"A140","name":"Triceps barre poulie haute","comment":null,"image":null,"type":[]},{"id":"A141","name":"Curl rotation","comment":null,"image":null,"type":["BRAS"]},{"id":"A142","name":"Curl poulie assis","comment":null,"image":null,"type":["BRAS"]},{"id":"A143","name":"Biceps debout barrz","comment":null,"image":null,"type":["BRAS"]},{"id":"A144","name":"Développé nuque guidé","comment":null,"image":null,"type":["EPAULES"]},{"id":"A145","name":"Antepulsion","comment":null,"image":null,"type":["EPAULES"]},{"id":"A146","name":"Épaule rowing supination","comment":null,"image":null,"type":["EPAULES"]},{"id":"A147","name":"mauei","comment":null,"image":null,"type":[]},{"id":"A15","name":"ECARTE POULIE","comment":"debout poulie haute","image":null,"type":["PECTORAUX"]},{"id":"A16","name":"DEV MILITAIRE ASSIS","comment":"","image":null,"type":["EPAULES"]},{"id":"A17","name":"TRICEPS HALTERE ASSIS","comment":"","image":null,"type":["BRAS"]},{"id":"A18","name":"OISEAU-SHRUG","comment":"","image":null,"type":["EPAULES"]},{"id":"A19","name":"TRACTION","comment":"","image":null,"type":["DOS"]},{"id":"A2","name":"DEV COUCHE BANC","comment":null,"image":null,"type":["PECTORAUX"]},{"id":"A20","name":"TIRAGE BARRE ROWING","comment":"","image":null,"type":["DOS"]},{"id":"A21","name":"TIRAGE NUQUE","comment":"","image":null,"type":["DOS"]},{"id":"A22","name":"TIRAGE PRISE SERRE","comment":"tirage prise triangle","image":null,"type":["DOS"]},{"id":"A23","name":"BICEPS POULIE VIS A VIS","comment":"","image":null,"type":["BRAS"]},{"id":"A24","name":"OBLIQUE POULIE","comment":"","image":null,"type":["DOS"]},{"id":"A25","name":"OBLIQUE HALTERE","comment":"","image":null,"type":["DOS"]},{"id":"A26","name":"SOULEVER DE TERRE","comment":"","image":null,"type":["DOS"]},{"id":"A27","name":"TIRAGE ASSIS POULIS BASSE PRISE SERRE","comment":"low row","image":null,"type":["DOS"]},{"id":"A28","name":"DEV HARNOLD","comment":"","image":null,"type":["EPAULES"]},{"id":"A29","name":"ELEVATION LATERALE POULIE","comment":"","image":null,"type":["EPAULES"]},{"id":"A3","name":"aueaie","comment":"auie","image":null,"type":["PECTORAUX"]},{"id":"A30","name":"TIRAGE MENTON","comment":"","image":null,"type":["EPAULES"]},{"id":"A31","name":"ELEVATION HORIZONTALE","comment":"","image":null,"type":["EPAULES"]},{"id":"A32","name":"ELEVATION HORIZONTALE POULIS","comment":"","image":null,"type":["EPAULES"]},{"id":"A33","name":"TIRAGE VERTICALE","comment":"","image":null,"type":["EPAULES"]},{"id":"A34","name":"TIRAGE COUDE OUVERT POULIE","comment":"rowing coude ouvert poulie","image":null,"type":["EPAULES"]},{"id":"A35","name":"TRICEPS BARRE FRONT","comment":"rowing coude ouvert poulie","image":null,"type":["BRAS"]},{"id":"A36","name":"SQUAT","comment":"","image":null,"type":["JAMBES"]},{"id":"A37","name":"PRESSE","comment":"","image":null,"type":["JAMBES"]},{"id":"A38","name":"CRUNCH","comment":"","image":null,"type":["ABDO"]},{"id":"A39","name":"MOLLET POID DU CORP","comment":"","image":null,"type":["JAMBES"]},{"id":"A4","name":"auie","comment":null,"image":null,"type":["ABDO"]},{"id":"A40","name":"PULL OVER INCLINE","comment":"","image":null,"type":["DOS"]},{"id":"A41","name":"PULL OVER POULIE HAUTE","comment":"","image":null,"type":["DOS"]},{"id":"A42","name":"EXTENSION JAMBE AVANT","comment":"","image":null,"type":["JAMBES"]},{"id":"A43","name":"EXTENSION JAMBE ARRIERE","comment":"","image":null,"type":["JAMBES"]},{"id":"A44","name":"GAINAGE","comment":"","image":null,"type":["ABDO"]},{"id":"A45","name":"TIRAGE HAUT MACHINE SUPINATION","comment":null,"image":null,"type":["DOS"]},{"id":"A46","name":"TIRAGE HAUT MACHINE PRONATION","comment":null,"image":null,"type":["DOS"]},{"id":"A47","name":"VELO ELLIPTIQUE","comment":null,"image":null,"type":["JAMBES"]},{"id":"A48","name":"DEVELOPPE DEVANT BARRE ASSIS","comment":null,"image":null,"type":["PECTORAUX","BRAS"]},{"id":"A49","name":"DEVELOPPE ASSIS HALTERE","comment":"dev militaire sans dossier","image":null,"type":["PECTORAUX"]},{"id":"A5","name":"DEV COUCHE DECLINE MACHINE","comment":null,"image":null,"type":["PECTORAUX"]},{"id":"A50","name":"BANC A LOMBAIRE","comment":"","image":null,"type":["DOS"]},{"id":"A51","name":"DEV HALTERE + OISEAU BANC INCLINE","comment":null,"image":null,"type":["EPAULES"]},{"id":"A52","name":"TRICEPS BARRE FRONT","comment":null,"image":null,"type":["BRAS"]},{"id":"A53","name":"TRICEPS EXTENSION TETE","comment":"triceps haltere au dessus de la tete","image":null,"type":["BRAS"]},{"id":"A54","name":"MOLLETS ASSIS","comment":"","image":null,"type":["JAMBES","MOLLET"]},{"id":"A55","name":"BICEPS CURL HALTERE","comment":"","image":null,"type":["BRAS"]},{"id":"A56","name":"TIRAGE ROWING","comment":"Prise pronation","image":null,"type":["DOS"]},{"id":"A57","name":"ABDOS RELEVE DE BASSIN","comment":null,"image":null,"type":["ABDO"]},{"id":"A58","name":"GAINAGE COTE","comment":null,"image":null,"type":["ABDO"]},{"id":"A59","name":"EXTENSION JAMBE ASSIS","comment":null,"image":null,"type":["JAMBES"]},{"id":"A6","name":"ECARTE MACHINE","comment":null,"image":null,"type":["PECTORAUX"]},{"id":"A60","name":"CXWorks","comment":null,"image":null,"type":["ABDO","JAMBES"]},{"id":"A61","name":"Rameur machine","comment":"","image":null,"type":["DOS"]},{"id":"A62","name":"LOMBAIRES","comment":null,"image":null,"type":["DOS"]},{"id":"A63","name":"éabpo","comment":null,"image":null,"type":["ABDO"]},{"id":"A64","name":null,"comment":null,"image":null,"type":[]},{"id":"A65","name":null,"comment":null,"image":null,"type":[]},{"id":"A66","name":"OISEAU BANC INCLINE","comment":null,"image":null,"type":["EPAULES"]},{"id":"A67","name":"Mollets presse","comment":null,"image":null,"type":["MOLLET"]},{"id":"A68","name":"INFRA ÉPINEUX STOP","comment":null,"image":null,"type":["DOS"]},{"id":"A69","name":"EXTENSION DEBOUT","comment":null,"image":null,"type":["MOLLET"]},{"id":"A7","name":"ECARTE COUCHE","comment":null,"image":null,"type":["PECTORAUX"]},{"id":"A70","name":"RELEVER JAMBE BARRE","comment":null,"image":null,"type":["ABDO"]},{"id":"A71","name":"ELEVATION LATERALE HALTERE","comment":null,"image":null,"type":["EPAULES"]},{"id":"A72","name":"ELEVATION LATERALE HALTERE, penche en avant","comment":null,"image":null,"type":["EPAULES"]},{"id":"A73","name":"DEV INCLINE BARRE","comment":null,"image":null,"type":["PECTORAUX"]},{"id":"A74","name":"CROSS OVER","comment":null,"image":null,"type":["PECTORAUX"]},{"id":"A75","name":"Rowing Assis poules unilatérale","comment":null,"image":null,"type":["DOS"]},{"id":"A76","name":"Hack squat","comment":null,"image":null,"type":["JAMBES"]},{"id":"A77","name":"Hack squat","comment":null,"image":null,"type":["JAMBES"]},{"id":"A78","name":null,"comment":null,"image":null,"type":["JAMBES"]},{"id":"A79","name":"Legs curl allonge","comment":null,"image":null,"type":["JAMBES"]},{"id":"A8","name":"DIPS","comment":null,"image":null,"type":["BRAS"]},{"id":"A80","name":"Chameaux","comment":null,"image":null,"type":["JAMBES"]},{"id":"A81","name":"Crunches latéraux","comment":"","image":null,"type":["ABDO"]},{"id":"A82","name":"Rotation latérales","comment":null,"image":null,"type":["ABDO"]},{"id":"A83","name":"Oiseau poulis","comment":null,"image":null,"type":["EPAULES"]},{"id":"A84","name":"Crunch banc","comment":null,"image":null,"type":["ABDO"]},{"id":"A85","name":"Rowing Assis poulis","comment":null,"image":null,"type":["DOS"]},{"id":"A87","name":"TEST","comment":"Comment","image":null,"type":["ABDO"]},{"id":"A88","name":"Tirage Rowing large","comment":null,"image":null,"type":["DOS"]},{"id":"A89","name":"Cure debout machine","comment":null,"image":null,"type":["JAMBES"]},{"id":"A9","name":"BICEPS BANC INCLINE","comment":null,"image":null,"type":["BRAS"]},{"id":"A90","name":"Avant bras haltères","comment":null,"image":null,"type":["BRAS"]},{"id":"A91","name":"Avant bras curl ez","comment":null,"image":null,"type":["BRAS"]},{"id":"A93","name":"POMPES","comment":null,"image":null,"type":["PECTORAUX"]},{"id":"A94","name":"HIGH ROW (machine)","comment":null,"image":null,"type":["DOS"]},{"id":"A95","name":"Shrug","comment":null,"image":null,"type":["DOS"]},{"id":"A96","name":"Tirage Rowing tbar","comment":null,"image":null,"type":["DOS"]},{"id":"A97","name":"DEV INCLINÉ MACHINE","comment":null,"image":null,"type":["PECTORAUX"]},{"id":"A98","name":"Les curl couche","comment":null,"image":null,"type":["JAMBES"]},{"id":"A99","name":"CURL INVERSE EZ","comment":null,"image":null,"type":["BRAS"]}]
    /**
     * Ajoute une serie a l'exercice
     *
     * @throws Exception
     **/
    @RequestMapping(value = "/v1/import/template-exo/list", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody List<ExoPredef> importExo(@RequestBody List<ExoPredef> exoPredefs) throws Exception {
        for (ExoPredef sc: exoPredefs) {
            exoPredefSvc.save(sc);
        }
        return exoPredefs;
    }

    /**
     * Ajoute une serie a l'exercice
     *
     * @throws Exception
     **/
    @RequestMapping(value = "/v1/import/seance/list", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody List<Seance> importSeances(@RequestBody List<Seance> seances) throws Exception {
        for (Seance sc : seances) {
            seanceSvc.save(sc);
        }
        return seances;
    }

}
