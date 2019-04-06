package fr.df.muscu.api.web.v2.model;

import fr.df.muscu.api.model.Seance;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class SeanceV2 {


    Integer id;
    SeanceTemplateV2 template;
    List<ExerciseV2> exercises;
    Date date;
    String name;

    public Seance toV1() {
        Seance s = new Seance();
        s.setDate(this.date);
        s.setName(this.name);
        s.setSeancePredef(this.template.toV1());
        s.setExercices(this.exercises.stream().map(ExerciseV2::toV1).collect(Collectors.toList()));
        return s;
    }

    public static SeanceV2 toV2(Seance o) {
        SeanceV2 v = new SeanceV2();
        v.setDate(o.getDate());
        v.setExercises(o.getExercices().stream().map(ExerciseV2::toV2).collect(Collectors.toList()));
        v.setName(o.getName());
        v.setTemplate(SeanceTemplateV2.toV2(o.getSeancePredef()));
        v.setId(o.getId());
        return v;
    }
}
