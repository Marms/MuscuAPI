package fr.df.muscu.api.web.v2.model;

import fr.df.muscu.api.model.ExoPredef;
import lombok.Data;
import org.springframework.util.CollectionUtils;

@Data
public class ExerciceTemplateV2 {

    public String id;
    public String name;
    public String imagePath;
    public String comment;
    public String type;

    public ExoPredef toV1() {

        ExoPredef p = new ExoPredef();
        p.setId(String.valueOf(this.id));
        p.setName(this.name);
        p.setImage(this.imagePath);
        p.setComment(this.comment);
        String[] types = new String[1];
        //TODO p.setType(types);
        return p;

    }

    public static ExerciceTemplateV2 toV2(ExoPredef p) {
        ExerciceTemplateV2 t = new ExerciceTemplateV2();
        t.setComment(p.getComment());
        t.setId(p.getId());
        t.setName(p.getName());
        t.setImagePath(p.getImage());
        if (!CollectionUtils.isEmpty(p.getType())) {
            t.setType(p.getType().get(0).name());
        }
        return t;
    }

}
