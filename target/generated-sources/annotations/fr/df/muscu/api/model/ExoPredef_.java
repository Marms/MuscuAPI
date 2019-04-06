package fr.df.muscu.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ExoPredef.class)
public abstract class ExoPredef_ {

	public static volatile SingularAttribute<ExoPredef, String> image;
	public static volatile SingularAttribute<ExoPredef, String> name;
	public static volatile SingularAttribute<ExoPredef, String> comment;
	public static volatile SingularAttribute<ExoPredef, String> id;
	public static volatile ListAttribute<ExoPredef, TypeExo> type;

}

