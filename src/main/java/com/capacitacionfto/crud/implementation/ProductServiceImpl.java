package com.capacitacionfto.crud.implementation;

import com.capacitacionfto.crud.dto.ProductDTO;
import com.capacitacionfto.crud.mapper.ProductMapper;
import com.capacitacionfto.crud.model.Product;
import com.capacitacionfto.crud.repo.ProductRepo;
import com.capacitacionfto.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo repo;

    private ProductMapper mapper = new ProductMapper();

    public ProductServiceImpl(ProductRepo repo) {
        this.repo = repo;
    }

    @Override
    public ProductDTO add(Product product) {
        return mapper.mapProduct(repo.save(product));
    }

    @Override
    public ProductDTO update(Product product) {
        return mapper.mapProduct(repo.save(product));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public ProductDTO detail(Long id) {
        return mapper.mapProduct(repo.getById(id));
    }

    @Override
    public List<ProductDTO> list() {
        return mapper.listProduct(repo.findAll());
    }
}
