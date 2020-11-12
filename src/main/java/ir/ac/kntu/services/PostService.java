package ir.ac.kntu.services;

import ir.ac.kntu.base.services.BaseService;
import ir.ac.kntu.domains.City;
import ir.ac.kntu.domains.Post;

import java.util.List;

public interface PostService extends BaseService<Post, Long> {

    List<Post> findPostsCity(City city, boolean flag);

    List<Post> findPostsCustomer(City city, boolean flag);

}
