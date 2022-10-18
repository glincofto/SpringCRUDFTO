package com.capacitacionfto.crud.controller;

import com.capacitacionfto.crud.model.Invoice;
import com.capacitacionfto.crud.model.Product;
import com.capacitacionfto.crud.service.InvoiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/demo/invoices")
public class InvoiceController {

    @Resource
    private InvoiceService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Invoice invoice){
        return ResponseEntity.ok().body(service.add(invoice));
    }

    @PutMapping("/update")
    private ResponseEntity<?> update(@RequestBody Invoice invoice){
        return ResponseEntity.ok().body(service.update(invoice));
    }

    @GetMapping("/detail/{id}")
    private ResponseEntity<?> detail(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(service.detail(id));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    private ResponseEntity<?> list(){
        return ResponseEntity.ok().body(service.list());
    }
}
