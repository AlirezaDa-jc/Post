package ir.ac.kntu.domains;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Branch.class)
public abstract class Branch_ extends ir.ac.kntu.base.domains.BaseEntity_ {

	public static volatile SingularAttribute<Branch, City> city;
	public static volatile SingularAttribute<Branch, Integer> employees;
	public static volatile ListAttribute<Branch, Post> posts;

}

