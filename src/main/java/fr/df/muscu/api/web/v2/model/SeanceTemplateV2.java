package fr.df.muscu.api.web.v2.model;

import fr.df.muscu.api.model.SeancePredef;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class
SeanceTemplateV2 {
    public Integer id;
    String name;
    String comment;
    String imagePath;
    String type[];
    List<ExerciceTemplateV2> exoTemplateList = new ArrayList<>();

    public SeancePredef toV1() {
        SeancePredef s = new SeancePredef(this.name);
        // s.setId(id);

        s.setList(this.exoTemplateList.stream().map(
                e -> e.toV1()
        ).collect(Collectors.toList()));
        return s;
    }

    public static SeanceTemplateV2 toV2(SeancePredef s) {
        SeanceTemplateV2 v = new SeanceTemplateV2();
        v.setId(s.getId());
        v.setName(s.getName());
        List<ExerciceTemplateV2> ee = s.getList()
                .stream().map(e -> ExerciceTemplateV2.toV2(e))
                .collect(Collectors.toList());
        v.setExoTemplateList( ee);
        return v;
    }
}
