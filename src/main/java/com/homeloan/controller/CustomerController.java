package com.homeloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homeloan.dto.HomeLoanCreation;
import com.homeloan.dto.HomeLoanDto;
import com.homeloan.model.Customer;
import com.homeloan.model.LoanDetails;
import com.homeloan.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	@PostMapping("/customer")
	public ResponseEntity<HomeLoanDto>  customer(@RequestBody Customer customer)
	{
		return new ResponseEntity<HomeLoanDto>(customerService.addCustomer(customer), HttpStatus.CREATED);
	}
	
	@PostMapping("/customer/homeloan")
	public ResponseEntity<HomeLoanDto> applyHomeLoan(@RequestBody LoanDetails loanDetails)
	{
		return new ResponseEntity<HomeLoanDto>(customerService.HomeLoanCreation(loanDetails), HttpStatus.CREATED);
	}
	
}
