package fr.df.muscu.api.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Seance.class)
public abstract class Seance_ {

	public static volatile SingularAttribute<Seance, Date> date;
	public static volatile SingularAttribute<Seance, SeancePredef> seancePredef;
	public static volatile ListAttribute<Seance, Exercice> exercices;
	public static volatile SingularAttribute<Seance, String> name;
	public static volatile ListAttribute<Seance, Salle> salles;
	public static volatile SingularAttribute<Seance, Integer> id;

}

