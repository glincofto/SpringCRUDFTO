package com.capacitacionfto.crud.controller;

import com.capacitacionfto.crud.exception.RequestNotFoundException;
import com.capacitacionfto.crud.exception.RequestSystemException;
import com.capacitacionfto.crud.model.Customer;
import com.capacitacionfto.crud.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/demo")
public class CustomerController {
    @Resource
    private CustomerService service;

    @PostMapping("/add")
    private ResponseEntity<?> add(@RequestBody Customer customer){
        try{
            return ResponseEntity.status(200).body(service.add(customer));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update")
    private ResponseEntity<?> update(@RequestBody Customer customer) {
        try {
            return ResponseEntity.ok().body(service.update(customer));
        }catch (RequestNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/detail/{id}")
    private ResponseEntity<?> detail(@PathVariable("id") Long id){
        try{
            return ResponseEntity.ok().body(service.detail(id));
        }catch(RequestNotFoundException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> delete(@PathVariable("id") Long id){
        try{
            service.delete(id);
            return ResponseEntity.ok().build();
        }catch(RequestNotFoundException e){
            return  ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/list")
    private ResponseEntity<?> list(){
        return ResponseEntity.ok().body(service.list());
    }
}
