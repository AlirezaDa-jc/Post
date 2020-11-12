package ir.ac.kntu.services.impl;

import ir.ac.kntu.Dao.PostRepository;
import ir.ac.kntu.Dao.impl.PostRepositoryImpl;
import ir.ac.kntu.base.services.impl.BaseServiceImpl;
import ir.ac.kntu.domains.City;
import ir.ac.kntu.domains.Post;
import ir.ac.kntu.services.PostService;

import java.util.List;

public class PostServiceImpl extends BaseServiceImpl<Post, Long, PostRepository> implements PostService {
    public PostServiceImpl() {
        PostRepository repository = new PostRepositoryImpl();
        super.setRepository(repository);
    }

    @Override
    public Post saveOrUpdate(Post post) throws IllegalArgumentException {
        Transportation.valueOf(post.getTransportation());
        Situation.valueOf(post.getSituation());
        if (post.getSender().getPostsFrom().size() > 5) {
            post.getSender().setDiscount(true);
            //If It Had Price We Could Have 10% Discount Here!!!!!!!!!!!!!!!!!!
        }
        return super.saveOrUpdate(post);
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

enum Transportation {
    GROUND("Ground"),
    AERIAL("Aerial"),
    MARITIME("Maritime");

    private final String transportation;

    private Transportation(String transportation) {
        this.transportation = transportation;
    }
}

enum Situation {
    SENT("Sent"),
    RECEIVED("Received"),
    STORE("In Store");

    private final String situation;

    private Situation(String situation) {
        this.situation = situation;
    }
}
