package fr.df.muscu.api.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Exercice.class)
public abstract class Exercice_ {

	public static volatile SingularAttribute<Exercice, Date> date;
	public static volatile SingularAttribute<Exercice, ExoPredef> exoPredef;
	public static volatile SingularAttribute<Exercice, Integer> numero;
	public static volatile ListAttribute<Exercice, Serie> series;
	public static volatile SingularAttribute<Exercice, Integer> repos;
	public static volatile SingularAttribute<Exercice, Integer> id;

}

