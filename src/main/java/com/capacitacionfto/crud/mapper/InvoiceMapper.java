package com.capacitacionfto.crud.mapper;

import com.capacitacionfto.crud.dto.InvoiceDTO;
import com.capacitacionfto.crud.model.Invoice;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

public class InvoiceMapper {
    private ModelMapper mapper = new ModelMapper();

    public InvoiceMapper() {
    }

    public InvoiceDTO mapInvoice(Invoice invoice){
        return mapper.map(invoice, InvoiceDTO.class);
    }

    public List<InvoiceDTO> listInvoice(List<Invoice> invoices){
        return mapper.map(invoices, new TypeToken<List<InvoiceDTO>>() {}.getType());
    }

}
