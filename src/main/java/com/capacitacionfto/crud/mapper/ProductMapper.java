package com.capacitacionfto.crud.mapper;

import com.capacitacionfto.crud.dto.ProductDTO;
import com.capacitacionfto.crud.model.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

public class ProductMapper {
    private ModelMapper mapper = new ModelMapper();

    public ProductMapper() {
    }
    public ProductDTO mapProduct(Product product){
        return mapper.map(product, ProductDTO.class);
    }
    public List<ProductDTO> listProduct(List<Product> products){
        return mapper.map(products, new TypeToken<List<ProductDTO>>(){}.getType());
    }

}
