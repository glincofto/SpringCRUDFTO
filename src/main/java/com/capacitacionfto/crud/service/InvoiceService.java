package com.capacitacionfto.crud.service;

import com.capacitacionfto.crud.dto.InvoiceDTO;
import com.capacitacionfto.crud.model.Invoice;

import java.util.List;

public interface InvoiceService {
    InvoiceDTO add(Invoice invoice);

    InvoiceDTO update(Invoice invoice);

    void delete(Long id);

    InvoiceDTO detail(Long id);

    List<InvoiceDTO> list();
}
