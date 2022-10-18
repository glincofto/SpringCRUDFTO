package com.capacitacionfto.crud.implementation;

import com.capacitacionfto.crud.dto.CustomerDTO;
import com.capacitacionfto.crud.exception.RequestNotFoundException;
import com.capacitacionfto.crud.exception.RequestSystemException;
import com.capacitacionfto.crud.exception.RequestValidationException;
import com.capacitacionfto.crud.mapper.CustomerMapper;
import com.capacitacionfto.crud.model.Customer;
import com.capacitacionfto.crud.repo.CustomerRepo;
import com.capacitacionfto.crud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    private CustomerMapper mapper = new CustomerMapper();

    @Override
    public Customer add(Customer customer) {
        dataValidation(customer);
        try{
            return repo.save(customer);
        }catch(DataAccessException e){
            throw new RequestSystemException("Ocurrio un error en la base de datos");
        }
    }

    @Override
    public Customer update(Customer customer) {
        Optional<Customer> customerOptional = repo.findById(customer.getId());
        if(customerOptional.isPresent()){
            return repo.save(customer);
        }else{
            throw new RequestNotFoundException("Cliente no encontrado");
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Customer> customerOptional = repo.findById(id);
        if(customerOptional.isPresent()){
            repo.delete(customerOptional.get());
        }else{
            throw new RequestNotFoundException("Cliente no encontrado");
        }
    }

    @Override
    public Customer detail(Long id) {
        Optional<Customer> customerOptional = repo.findById(id);
        if(customerOptional.isPresent()){
            return customerOptional.get();
        }else{
            throw new RequestNotFoundException("Cliente no encontrado");
        }
    }

    @Override
    public List<CustomerDTO> list() {
        return mapper.listCustomer(repo.findAll());
    }

    private void dataValidation(Customer customer){
        if(customer.getName() == null || customer.getName().isEmpty()){
            throw new RequestValidationException("Debe ingresar un nombre para el cliente");
        }
        if(customer.getMail() == null || customer.getMail().isEmpty()){
            throw new RequestValidationException("Debe ingresar un mail para el cliente");
        }
    }
}
