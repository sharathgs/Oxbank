package com.homeloan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.homeloan.dto.HomeLoanDto;
import com.homeloan.exception.HomeLoanException;
import com.homeloan.model.BankEmployeeDetails;
import com.homeloan.model.Customer;
import com.homeloan.model.LoanDetails;
import com.homeloan.repository.BankEmployeeRepository;
import com.homeloan.repository.CustomerRepository;
import com.homeloan.repository.HomeLoanRepository;

@Service
public class ManagerService {

	
	@Autowired
	HomeLoanRepository homeLoan;
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	BankEmployeeRepository empRepo;
	
	public List<LoanDetails> getCustomers(String status)
	{
		List<LoanDetails> homeLoanCustomers = homeLoan.findByStatus(status);
		return homeLoanCustomers;
	}
	
	public HomeLoanDto updateHomeLoan(int loanid,String changedStatus, int employeeId) throws HomeLoanException {
		Optional<LoanDetails> customer = homeLoan.findById(loanid);
		List<LoanDetails> loans = (List<LoanDetails>) customer.get();
		LoanDetails loan = customer.get();
		
		Optional<BankEmployeeDetails> officer = empRepo.findById(employeeId);
		
		if(loans.size() == 1)
		{
			if(loan.getCreditScore() > 900)
			{
				if(loan.getPendingEmi() == 0)
				{
					if(loan.getExpectedLoan() > (loan.getPropertyValue()/2))
					{
						if(officer.get().getEmployeeDesignation() == "officer" || officer.get().getEmployeeDesignation() == "manager")
						{
							loan.setStatus("approved");
							loan.setManagerId(officer.get().getId());
							homeLoan.save(loan);
						}else
						{
							throw new HomeLoanException("Only manager or officer can approve the loan");
						}
					}else {
						throw new HomeLoanException("The property value is less than expected");
					}
				}else {
					throw new HomeLoanException("EMI is still pending");
				}
			}else {
				throw new HomeLoanException("Credit score is less than 900");
			}
		}else {
			throw new HomeLoanException("Customer has already applied for loan");
		}
		
		return new HomeLoanDto("Loan approved");
	}
	
}
