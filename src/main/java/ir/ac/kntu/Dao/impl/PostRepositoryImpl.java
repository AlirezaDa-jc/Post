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

//    @Override
//    public List<Post> findByRoute(Route route) {
//        em.getTransaction().begin();
//        TypedQuery<Post> query = em.createQuery(
//                "SELECT u FROM Post u where u.route=:route",
//                Post.class);
//
//        query.setParameter("route", route);
//        List<Post> resultList = query.getResultList();
//        em.getTransaction().commit();
//        if (resultList.size() > 0) {
//            return resultList;
//        }
//        return null;
//    }
}
