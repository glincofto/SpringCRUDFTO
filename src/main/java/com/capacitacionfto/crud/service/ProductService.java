package com.capacitacionfto.crud.service;

import com.capacitacionfto.crud.dto.ProductDTO;
import com.capacitacionfto.crud.model.Product;

import java.util.List;

public interface ProductService {
    ProductDTO add(Product product);

    ProductDTO update(Product product);

    void delete(Long id);

    ProductDTO detail(Long id);

    List<ProductDTO> list();
}
