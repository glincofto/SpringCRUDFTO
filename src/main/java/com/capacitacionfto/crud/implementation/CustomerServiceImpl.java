package com.capacitacionfto.crud.implementation;

import com.capacitacionfto.crud.model.Customer;
import com.capacitacionfto.crud.repo.CustomerRepo;
import com.capacitacionfto.crud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Override
    public Customer add(Customer customer) {
        return repo.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        Optional<Customer> customerOptional = repo.findById(customer.getId());
        if(customerOptional.isEmpty()){
            return null;
        }
        return repo.save(customer);
    }

    @Override
    public void delete(Long id) {
        Optional<Customer> customerOptional = repo.findById(id);
        if(customerOptional.isEmpty())
            repo.delete(customerOptional.get());
    }

    @Override
    public Customer detail(Long id) {
        Optional<Customer> customerOptional = repo.findById(id);
        if(customerOptional.isEmpty()){
            return null;
        }
        return customerOptional.get();
    }

    @Override
    public List<Customer> list() {
        return repo.findAll();
    }
}
