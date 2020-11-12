/*
 * @author Alireza.d.a
 */


package ir.ac.kntu.Dao.impl;

import ir.ac.kntu.Dao.PostRepository;
import ir.ac.kntu.base.repository.impl.BaseRepositoryImpl;
import ir.ac.kntu.domains.Post;

public class PostRepositoryImpl extends BaseRepositoryImpl<Post, Long> implements PostRepository {
    @Override
    protected Class<Post> getEntityClass() {
        return Post.class;
    }

}
