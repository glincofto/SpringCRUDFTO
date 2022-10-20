package com.capacitacionfto.crud.implementation;

import com.capacitacionfto.crud.model.Product;
import com.capacitacionfto.crud.repo.ProductRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class ProductServiceImplTest {

    private AutoCloseable autoCloseable;

    @Mock
    private ProductRepo repo;

    @InjectMocks
    private ProductServiceImpl service;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        service = new ProductServiceImpl(repo);
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void add() {
        Product product = generateProduct();
        //when
        service.add(product);
        //then
        verify(repo).save(product);
    }

    @Test
    void update() {
        Product product = mockFindById(2L);
        product.setName("Gafas");
        //when
        service.update(product);
        //then
        verify(repo).save(product);
    }

    @Test
    void delete() {
        Product product = mockFindById(5L);
        //when
        service.delete(product.getId());
        //then
        verify(repo).deleteById(5L);
    }

    @Test
    void detail() {
        Product product = mockFindById(20L);
        //when
        service.detail(product.getId());
        //then
        verify(repo).getById(20L);
    }

    @Test
    void list() {
        //when
        service.list();
        //then
        verify(repo).findAll();
    }

    private Product generateProduct(){
        Product mockProduct = new Product();
        mockProduct.setName("Anteojos");
        mockProduct.setDescription("Anteojos de sol para la vista");
        mockProduct.setStock(10);
        mockProduct.setSalePrice(2990F);
        mockProduct.setId(1L);
        mockProduct.setCode("AAB344");

        doReturn(mockProduct).when(repo).save(mockProduct);
        return mockProduct;
    }
    private Product mockFindById(Long id){
        Product mock = new Product();
        mock.setId(id);
        mock.setName("Anteojos");
        mock.setDescription("Anteojos de sol para la vista");
        mock.setStock(10);
        mock.setSalePrice(2990F);
        doReturn(mock).when(repo).getById(id);
        doReturn(mock).when(repo).save(mock);
        return mock;
    }
}