package com.p1.example.rest.customer;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.p1.example.web.WebCustomerService;




@RestController
public class CustomerController {
	@Autowired
	private WebCustomerService service;

	@GetMapping("/displayAll")
	public String list(){
		Gson gson = new Gson();
		 
		 String jsonList = gson.toJson(service.listAll());
		return jsonList;
	}
	
	@GetMapping("customers/{id}")
	public ResponseEntity<Customer> get(@PathVariable Integer id){
		try{
			Customer customer = service.get(id);
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/customers")
	public void add(@RequestBody Customer customer){
		service.save(customer);
	}
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<?> update(@RequestBody Customer customer, @PathVariable Integer id){
		try{
			Customer existCustomer = service.get(id);
			service.save(customer);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}