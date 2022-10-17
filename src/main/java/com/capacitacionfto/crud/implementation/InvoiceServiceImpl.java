package com.capacitacionfto.crud.implementation;

import com.capacitacionfto.crud.dto.InvoiceDTO;
import com.capacitacionfto.crud.dto.ProductDTO;
import com.capacitacionfto.crud.model.Invoice;
import com.capacitacionfto.crud.model.InvoiceItem;
import com.capacitacionfto.crud.repo.InvoiceRepo;
import com.capacitacionfto.crud.service.InvoiceService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Resource
    private InvoiceRepo repo;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public InvoiceDTO add(Invoice invoice) {
        Float total = 0f;
        for(InvoiceItem invoiceItem : invoice.getInvoiceItems()){
            invoiceItem.setInvoice(invoice);
            total = total + (invoiceItem.getQuantity() * invoiceItem.getProduct().getSalePrice());
        }
        invoice.setTotal(total);
        return mapper.map(repo.save(invoice), InvoiceDTO.class);
    }

    @Override
    public InvoiceDTO update(Invoice invoice) {
        return mapper.map(repo.save(invoice), InvoiceDTO.class);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public InvoiceDTO detail(Long id) {
        return mapper.map(repo.findById(id).get(), InvoiceDTO.class );
    }

    @Override
    public List<InvoiceDTO> list() {
        return mapper.map(repo.findAll(), new TypeToken<List<InvoiceDTO>>(){}.getType());
    }
}
