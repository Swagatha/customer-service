package com.onlineshopping.customerserivce;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/customer/{custId}")
	public Optional<Customer> getCustomerDetails(@PathVariable Long custId) {
		//return new Customer(1101L,"Jim", "Morrison" , "jim@doors.com") ;
		return customerRepository.findById(custId);		
	}

	@GetMapping("/customers")
	public List<Customer> list() {	
		return customerRepository.findAll();
	}
	
	@PostMapping("/customers")
	public Customer create(@RequestBody Customer customer) {
		//return ShipwreckStub.create(shipwreck);
		return customerRepository.saveAndFlush(customer);		
	}
	
}
