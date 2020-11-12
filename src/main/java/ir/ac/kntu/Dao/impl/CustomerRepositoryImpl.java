package ir.ac.kntu.Dao.impl;

import ir.ac.kntu.Dao.CustomerRepository;
import ir.ac.kntu.base.repository.impl.BaseRepositoryImpl;
import ir.ac.kntu.domains.Customer;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer, Long> implements CustomerRepository {

    @Override
    protected Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
