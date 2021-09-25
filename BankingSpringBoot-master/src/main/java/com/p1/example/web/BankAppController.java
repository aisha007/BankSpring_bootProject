package com.p1.example.web;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.p1.example.rest.customer.Customer;

@Controller
public class BankAppController {
	@Autowired
	protected WebCustomerService customerService;

	

	protected Logger logger = Logger.getLogger(BankAppController.class
			.getName());

	public BankAppController(WebCustomerService customerService) {
		this.customerService = customerService;
		
	}

	@RequestMapping("/displayAll")
	public String doDisplayAll(Model model) {

//		String sum = customerService.add(addend1, addend2);
		String customers = customerService.displayAll(); 
		logger.info("Customer Data: " +customers );
		model.addAttribute("json", customers );

		return "customers";
	}

	
}
