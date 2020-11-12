package ir.ac.kntu.domains;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(City.class)
public abstract class City_ extends ir.ac.kntu.base.domains.BaseEntity_ {

	public static volatile ListAttribute<City, Post> postsTo;
	public static volatile SingularAttribute<City, String> name;
	public static volatile ListAttribute<City, Post> postsFrom;
	public static volatile SetAttribute<City, Branch> branches;
	public static volatile SingularAttribute<City, String> coordination;

}

