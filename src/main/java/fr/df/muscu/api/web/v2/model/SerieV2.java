package fr.df.muscu.api.web.v2.model;

import fr.df.muscu.api.model.Serie;
import lombok.Data;

@Data
public class SerieV2 {
    Double weight;
    Double repetition;
    Integer id;


    public Serie toV1() {
        Serie v = new Serie();
        v.setNbRepeat(this.repetition);
        v.setPoids(this.weight);
        v.setId(this.id);
        return v;
    }

    public static SerieV2 toV2(Serie o) {
        SerieV2 s = new SerieV2();
        s.setId(o.getId());
        s.setRepetition(o.getNbRepeat());
        s.setWeight(o.getPoids());
        return s;
    }
}