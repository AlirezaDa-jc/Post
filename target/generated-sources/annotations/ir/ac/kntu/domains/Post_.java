package ir.ac.kntu.domains;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Post.class)
public abstract class Post_ extends ir.ac.kntu.base.domains.BaseEntity_ {

	public static volatile SingularAttribute<Post, Customer> receiver;
	public static volatile SingularAttribute<Post, String> sendDate;
	public static volatile SingularAttribute<Post, Customer> sender;
	public static volatile SingularAttribute<Post, String> name;
	public static volatile SingularAttribute<Post, Double> weight;
	public static volatile SingularAttribute<Post, String> receiveDate;
	public static volatile SingularAttribute<Post, City> from;
	public static volatile SingularAttribute<Post, City> to;
	public static volatile SingularAttribute<Post, String> type;
	public static volatile SingularAttribute<Post, Branch> branch;
	public static volatile SingularAttribute<Post, String> situation;
	public static volatile SingularAttribute<Post, String> transportation;

}

