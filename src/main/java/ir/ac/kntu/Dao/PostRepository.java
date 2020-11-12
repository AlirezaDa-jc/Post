package ir.ac.kntu.Dao;

import ir.ac.kntu.base.repository.BaseRepository;
import ir.ac.kntu.domains.City;
import ir.ac.kntu.domains.Post;

import java.util.List;

public interface PostRepository extends BaseRepository<Post, Long> {

    List<Post> findPostsCity(City city, boolean flag);

    List<Post> findPostsCustomer(City city, boolean flag);
}
