/**
 * @author Alireza.d.a
 */

import ir.ac.kntu.Dao.BranchRepository;
import ir.ac.kntu.Dao.CustomerRepository;
import ir.ac.kntu.Dao.PostRepository;
import ir.ac.kntu.Dao.impl.BranchRepositoryImpl;
import ir.ac.kntu.Dao.impl.CityRepositoryImpl;
import ir.ac.kntu.Dao.impl.CustomerRepositoryImpl;
import ir.ac.kntu.Dao.impl.PostRepositoryImpl;
import ir.ac.kntu.domains.Branch;
import ir.ac.kntu.domains.City;
import ir.ac.kntu.domains.Customer;
import ir.ac.kntu.domains.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

class PostRepositoryImplTest extends PostRepositoryImpl {
    private static final PostRepository postRepository = new PostRepositoryImpl();
    private static final CustomerRepository customerRepository = new CustomerRepositoryImpl();
    private static final CityRepositoryImpl cityRepository = new CityRepositoryImpl();
    private static final BranchRepository branchRepository = new BranchRepositoryImpl();
    private static Post post;

    @BeforeAll
    static void beforeAll() {
        List<Customer> customers = customerRepository.findAll();
        String name = "firstPost";
        Customer sender = customers.get(0);
        Customer receiver = customers.get(1);
        Branch branch = branchRepository.findAll().get(0);
        City city = cityRepository.findAll().get(1);
        double weight = 7.55;
        String sendDate = "1399-01-15";
        String receiveDate = "1399-03-15";
        String situation = "STORE";
        String transportation = "AERIAL";
        String type = "VIP";
        post = new Post(name, type, weight, sendDate, receiveDate, transportation,
                situation, sender, receiver, branch, city);
        postRepository.saveOrUpdate(post);
    }

    @Order(1)
    @Test
    void testFindById() {
        Assertions.assertEquals(post, findById(post.getId()));
    }

    @Override
    protected Class<Post> getEntityClass() {
        return super.getEntityClass();
    }


}