/*
 * @author Alireza.d.a
 */


package ir.ac.kntu.Dao.impl;

import ir.ac.kntu.Dao.PostRepository;
import ir.ac.kntu.base.repository.impl.BaseRepositoryImpl;
import ir.ac.kntu.domains.City;
import ir.ac.kntu.domains.Post;

import java.util.List;

public class PostRepositoryImpl extends BaseRepositoryImpl<Post, Long> implements PostRepository {
    @Override
    protected Class<Post> getEntityClass() {
        return Post.class;
    }

    @Override
    public List<Post> findPostsCity(City city, boolean flag) {
        return null;
    }

    @Override
    public List<Post> findPostsCustomer(City city, boolean flag) {
        return null;
    }

}
