package fr.df.muscu.api.web.v2.model;

import fr.df.muscu.api.model.Exercice;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ExerciseV2 {

    ExerciceTemplateV2 template;
    List<SerieV2> series;
    Integer id;


    public Exercice toV1() {
        Exercice e = new Exercice();
        e.setExoPredef(this.template.toV1());
        e.setSeries(this.series.stream().map(s -> s.toV1()).collect(Collectors.toList()));
        e.setId(this.id);
        return e;
    }


    public static ExerciseV2 toV2(Exercice o) {
        ExerciseV2 v = new ExerciseV2();
        v.setId(o.getId());
        v.setSeries(o.getSeries().stream().map(SerieV2::toV2).collect(Collectors.toList()));
        v.setTemplate(ExerciceTemplateV2.toV2(o.getExoPredef()));

        return v;
    }
}
