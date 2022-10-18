package com.capacitacionfto.crud.mapper;

import com.capacitacionfto.crud.dto.CustomerDTO;
import com.capacitacionfto.crud.dto.InvoiceDTO;
import com.capacitacionfto.crud.model.Customer;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

public class CustomerMapper {

    private ModelMapper mapper = new ModelMapper();

    public CustomerMapper() {
    }

    public CustomerDTO mapCustomer(Customer customer){
        return mapper.map(customer, CustomerDTO.class);
    }

    public List<CustomerDTO> listCustomer(List<Customer> customers){
        return mapper.map(customers, new TypeToken<List<CustomerDTO>>() {}.getType());
    }
}
