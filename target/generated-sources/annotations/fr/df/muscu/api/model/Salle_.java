package fr.df.muscu.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Salle.class)
public abstract class Salle_ {

	public static volatile SingularAttribute<Salle, String> name;
	public static volatile SingularAttribute<Salle, Long> id;
	public static volatile ListAttribute<Salle, ExoPredef> exoTemplates;
	public static volatile ListAttribute<Salle, SeancePredef> seanceTemplates;

}

