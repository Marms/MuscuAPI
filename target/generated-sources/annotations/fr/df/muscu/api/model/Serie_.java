package fr.df.muscu.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Serie.class)
public abstract class Serie_ {

	public static volatile SingularAttribute<Serie, Integer> numero;
	public static volatile SingularAttribute<Serie, Double> poids;
	public static volatile SingularAttribute<Serie, Double> leste;
	public static volatile SingularAttribute<Serie, Character> unilateral;
	public static volatile SingularAttribute<Serie, TypeNotation> type;
	public static volatile SingularAttribute<Serie, Double> minute;
	public static volatile SingularAttribute<Serie, Boolean> neg;
	public static volatile SingularAttribute<Serie, Integer> repos;
	public static volatile SingularAttribute<Serie, Boolean> forcer;
	public static volatile SingularAttribute<Serie, Serie> serie;
	public static volatile SingularAttribute<Serie, Double> nbRepeat;
	public static volatile SingularAttribute<Serie, String> comment;
	public static volatile SingularAttribute<Serie, Integer> id;
	public static volatile SingularAttribute<Serie, Double> seconde;

}

