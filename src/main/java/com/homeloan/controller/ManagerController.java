package com.homeloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homeloan.dto.HomeLoanDto;
import com.homeloan.exception.HomeLoanException;
import com.homeloan.model.LoanDetails;
import com.homeloan.service.ManagerService;

import net.bytebuddy.implementation.bytecode.Throw;

@RestController
public class ManagerController {
	
	@Autowired
	ManagerService managerService;
	
	@PutMapping("/approvemanager")
	public ResponseEntity<HomeLoanDto>  approveLoan(@RequestParam int loanId,
			@RequestParam String status,@RequestParam int employeeid)
	{
		return new ResponseEntity<HomeLoanDto>(managerService.updateHomeLoan(loanId, status, employeeid), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/homeloandetails")
	public ResponseEntity<List<LoanDetails>> getHomeLoan(@RequestParam String status) throws HomeLoanException
	{
		List<LoanDetails> listOfCustomers = managerService.getCustomers(status);
		return new ResponseEntity<List<LoanDetails>>(listOfCustomers, HttpStatus.FOUND);
	}

}
