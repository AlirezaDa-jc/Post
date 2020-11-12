/*
 * @author Alireza.d.a
 */

package ir.ac.kntu.services.impl;

import ir.ac.kntu.Dao.CustomerRepository;
import ir.ac.kntu.Dao.impl.CustomerRepositoryImpl;
import ir.ac.kntu.base.services.impl.BaseServiceImpl;
import ir.ac.kntu.domains.Customer;
import ir.ac.kntu.services.CustomerService;

public class CustomerServiceImpl extends BaseServiceImpl<Customer, Long, CustomerRepository> implements CustomerService {
    public CustomerServiceImpl() {
        CustomerRepository repository = new CustomerRepositoryImpl();
        super.setRepository(repository);
    }

    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }

}
