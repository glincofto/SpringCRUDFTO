package com.capacitacionfto.crud.implementation;

import com.capacitacionfto.crud.model.Customer;
import com.capacitacionfto.crud.model.Invoice;
import com.capacitacionfto.crud.model.InvoiceItem;
import com.capacitacionfto.crud.model.Product;
import com.capacitacionfto.crud.repo.InvoiceRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class InvoiceServiceImplTest {

    private AutoCloseable autoCloseable;

    @Mock
    private InvoiceRepo repo;

    @InjectMocks
    private InvoiceServiceImpl service;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        service = new InvoiceServiceImpl(repo);
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void add() {
        Invoice invoice = generateInvoice();
        //when
        service.add(invoice);
        //then
        verify(repo).save(invoice);
    }

    @Test
    void update() {
        Invoice invoice = mockFindById(5L);
        invoice.setInvoiceNumber(231);
        //when
        service.update(invoice);
        //then
        verify(repo).save(invoice);
    }

    @Test
    void delete() {
        Invoice invoice = mockFindById(2L);
        //when
        service.delete(invoice.getId());
        //then
        verify(repo).deleteById(2L);
    }

    @Test
    void detail() {
        Invoice invoice = mockFindById(1L);
        //when
        service.detail(invoice.getId());
        //then
        verify(repo).getById(1L);
    }

    @Test
    void list() {
        //when
        service.list();
        //then
        verify(repo).findAll();
    }

    private Invoice generateInvoice(){
        Invoice invoiceMock = new Invoice();
        Set<InvoiceItem> itemsMock = new HashSet<>();

        itemsMock.add(generateInvoiceItem());

        invoiceMock.setId(1L);
        invoiceMock.setInvoiceNumber(123);
        invoiceMock.setInvoiceItems(itemsMock);
        invoiceMock.setDate(LocalDate.now());
        invoiceMock.setCustomer(generateCustomer());

        doReturn(invoiceMock).when(repo).save(invoiceMock);
        return invoiceMock;
    }

    private Customer generateCustomer(){
        Customer customerMock = new Customer();
        customerMock.setId(1L);
        customerMock.setName("Ivan");
        customerMock.setLastname("Fernandez");
        customerMock.setMail("ivan.fernandez@gmail.com");

        return customerMock;
    }

    private InvoiceItem generateInvoiceItem(){
        InvoiceItem itemMock = new InvoiceItem();
        itemMock.setId(1L);
        itemMock.setQuantity(5);
        itemMock.setProduct(generateProduct());
        return itemMock;
    }

    private Product generateProduct(){
        Product productMock = new Product();
        productMock.setId(1L);
        productMock.setCode("AABC");
        productMock.setName("anteojos");
        productMock.setSalePrice(100F);
        productMock.setDescription("Anteojos de sol");

        return productMock;
    }
    private Invoice mockFindById(Long id){
        Invoice mock = generateInvoice();
        mock.setId(id);
        doReturn(mock).when(repo).getById(id);
        return mock;
    }

}