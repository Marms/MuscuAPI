package fr.df.muscu.api.web.v2.model;

import fr.df.muscu.api.model.Serie;
import fr.df.muscu.api.model.TypeNotation;
import lombok.Data;

@Data
public class SerieV2 {
    Double weight;
    Double repetition;
    Integer id;
    Integer number;
    Boolean negative;
    Boolean force;
    String comment;
    Double minute;
    Double seconde;
    String notation;

    public Serie toV1() {
        Serie v = new Serie();
        v.setNbRepeat(this.repetition);
        v.setPoids(this.weight);
        v.setId(this.id);
        v.setNumero(this.number);
        v.setComment(this.comment);
        v.setMinute(this.minute);
        v.setSeconde(this.seconde);
        v.setType(TypeNotation.valueOf(this.notation));
        return v;
    }

    public static SerieV2 toV2(Serie o) {
        SerieV2 s = new SerieV2();
        s.setId(o.getId());
        s.setRepetition(o.getNbRepeat());
        s.setWeight(o.getPoids());
        s.setNumber(o.getNumero());
        s.setComment(o.getComment());
        s.setMinute(o.getMinute());
        s.setSeconde(o.getSeconde());
        s.setNotation(o.getType().toString());
        return s;
    }
}