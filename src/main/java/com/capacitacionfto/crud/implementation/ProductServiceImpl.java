package com.capacitacionfto.crud.implementation;

import com.capacitacionfto.crud.dto.ProductDTO;
import com.capacitacionfto.crud.model.Product;
import com.capacitacionfto.crud.repo.ProductRepo;
import com.capacitacionfto.crud.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo repo;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public ProductDTO add(Product product) {
        return mapper.map(repo.save(product), ProductDTO.class);
    }

    @Override
    public ProductDTO update(Product product) {
        return mapper.map(repo.save(product), ProductDTO.class);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public ProductDTO detail(Long id) {
        return mapper.map(repo.findById(id).get(), ProductDTO.class);
    }

    @Override
    public List<ProductDTO> list() {
        return mapper.map(repo.findAll(), new TypeToken<List<ProductDTO>>(){}.getType());
    }
}
