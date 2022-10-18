package com.capacitacionfto.crud.service;

import com.capacitacionfto.crud.dto.CustomerDTO;
import com.capacitacionfto.crud.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer add(Customer customer);

    Customer update(Customer customer);

    void delete(Long id);

    Customer detail(Long id);

    List<CustomerDTO> list();
}
