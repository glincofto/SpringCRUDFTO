package com.capacitacionfto.crud.dto;

import com.capacitacionfto.crud.model.Customer;

import java.time.LocalDate;
import java.util.Set;

public class InvoiceDTO {
    private Long id;

    private Integer invoiceNumber;
    private LocalDate date;
    private LocalDate expirationDate;
    private CustomerDTO customer;
    private Set<InvoiceItemDTO> invoiceItems;
    private Float total;

    public InvoiceDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Set<InvoiceItemDTO> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(Set<InvoiceItemDTO> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}
