/**
 * @author Alireza.d.a
 */

import ir.ac.kntu.Dao.CustomerRepository;
import ir.ac.kntu.Dao.impl.CustomerRepositoryImpl;
import ir.ac.kntu.domains.Customer;
import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerRepositoryImplTest extends CustomerRepositoryImpl {
    private static final CustomerRepository customerRepository = new CustomerRepositoryImpl();
    private static final Customer firstCustomer = new Customer("first", 123456789);
    private static final Customer secondCustomer = new Customer("second", 987654321);

    @BeforeAll
    static void beforeAll() {
        customerRepository.saveOrUpdate(firstCustomer);
        customerRepository.saveOrUpdate(secondCustomer);
    }

    @Order(1)
    @Test
    void testFindById() {
        Assertions.assertEquals(firstCustomer, findById(firstCustomer.getId()));
    }

    @Order(2)
    @Test
    void testFindAll() {
        List<Customer> customers = new LinkedList<>();
        customers.add(firstCustomer);
        customers.add(secondCustomer);
        assertEquals(customers, findAll());
    }


    @Override
    protected Class<Customer> getEntityClass() {
        return super.getEntityClass();
    }

}