package ir.ac.kntu.domains;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Customer.class)
public abstract class Customer_ extends ir.ac.kntu.base.domains.BaseEntity_ {

	public static volatile ListAttribute<Customer, Post> postsTo;
	public static volatile SingularAttribute<Customer, Long> nationalCode;
	public static volatile SingularAttribute<Customer, String> name;
	public static volatile SingularAttribute<Customer, Boolean> discount;
	public static volatile ListAttribute<Customer, Post> postsFrom;

}

