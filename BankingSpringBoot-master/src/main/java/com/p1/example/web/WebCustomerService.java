package com.p1.example.web;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.p1.example.rest.customer.Customer;
import com.p1.example.rest.customer.CustomerRepository;



@Service
@Transactional
public class WebCustomerService {
	
	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;
	private CustomerRepository repo;
	protected String serviceUrl;
	
	public WebCustomerService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	
	public String displayAll() {
		return restTemplate.getForObject(serviceUrl + "/displayAll", String.class);
		
	}
	
	public List<Customer> listAll(){
		return repo.findAll();
	}
	
	public void save(Customer customer){
		repo.save(customer);
	}
	
	public Customer get(Integer id){
		return repo.findById(id).get();
	}
	
	public void delete(Integer id){
		repo.deleteById(id);
	}
}
