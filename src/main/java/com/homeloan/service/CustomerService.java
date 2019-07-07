package com.homeloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeloan.dto.HomeLoanDto;
import com.homeloan.model.Customer;
import com.homeloan.model.LoanDetails;
import com.homeloan.repository.CustomerRepository;
import com.homeloan.repository.HomeLoanRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	HomeLoanRepository homeLoanRepo;
	
	public HomeLoanDto addCustomer(Customer customer)
	{
		Customer customerSaved = customerRepo.save(customer);
		if(customerSaved != null)
			return new HomeLoanDto("Customer saved successfully");
		else
			return new HomeLoanDto("Customer Not saved successfully");
	}
	
	
	public HomeLoanDto HomeLoanCreation(LoanDetails loanDetails)
	{
		LoanDetails loanDetailsofCustomer = homeLoanRepo.save(loanDetails);
		
		if(loanDetailsofCustomer != null)
			return new HomeLoanDto("Application for Home Loan added successfully");
		else
			return new HomeLoanDto("Application for Home Loan not added successfully successfully");
	}

}
