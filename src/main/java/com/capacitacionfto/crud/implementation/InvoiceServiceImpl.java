package com.capacitacionfto.crud.implementation;

import com.capacitacionfto.crud.dto.InvoiceDTO;
import com.capacitacionfto.crud.mapper.InvoiceMapper;
import com.capacitacionfto.crud.model.Invoice;
import com.capacitacionfto.crud.model.InvoiceItem;
import com.capacitacionfto.crud.repo.InvoiceRepo;
import com.capacitacionfto.crud.service.InvoiceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Resource
    private InvoiceRepo repo;

    private InvoiceMapper mapper = new InvoiceMapper();

    public InvoiceServiceImpl(InvoiceRepo repo) {
        this.repo = repo;
    }

    @Override
    public InvoiceDTO add(Invoice invoice) {
        Float total = 0f;
        for(InvoiceItem invoiceItem : invoice.getInvoiceItems()){
            invoiceItem.setInvoice(invoice);
            total = total + (invoiceItem.getQuantity() * invoiceItem.getProduct().getSalePrice());
        }
        invoice.setTotal(total);
        return mapper.mapInvoice(repo.save(invoice));
    }

    @Override
    public InvoiceDTO update(Invoice invoice) {
        return mapper.mapInvoice(repo.save(invoice));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public InvoiceDTO detail(Long id) {
        return mapper.mapInvoice(repo.getById(id));
    }

    @Override
    public List<InvoiceDTO> list() {
        return mapper.listInvoice(repo.findAll());
    }
}
