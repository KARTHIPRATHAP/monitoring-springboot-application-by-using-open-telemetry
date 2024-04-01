package com.devprobelms.controller;

import com.devprobelms.entity.Customer;
import com.devprobelms.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/customer")
public class MsOneController {

    private final RestTemplate restTemplate;
    private final CustomerRepository customerRepository;

    public MsOneController(RestTemplate restTemplate, CustomerRepository customerRepository) {
        this.restTemplate = restTemplate;
        this.customerRepository = customerRepository;
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Customer> post(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerRepository.save(customer));
    }
    @GetMapping(path = "/all")
    public ResponseEntity<Object> post() {
        return ResponseEntity.ok(customerRepository.findAll());
    }
    

    @GetMapping(path = "/rest")
    public ResponseEntity<String> get() {
        return restTemplate.getForEntity("http://localhost:8082/get", String.class);
    }
}
