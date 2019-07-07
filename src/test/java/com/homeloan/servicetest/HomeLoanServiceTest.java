package com.homeloan.servicetest;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.homeloan.dto.HomeLoanDto;
import com.homeloan.model.BankEmployeeDetails;
import com.homeloan.model.Customer;
import com.homeloan.model.LoanDetails;
import com.homeloan.repository.BankEmployeeRepository;
import com.homeloan.repository.CustomerRepository;
import com.homeloan.repository.HomeLoanRepository;
import com.homeloan.service.CustomerService;
import com.homeloan.service.ManagerService;

@RunWith(MockitoJUnitRunner.class)
public class HomeLoanServiceTest {
	
	@InjectMocks
	CustomerService customerService;
	
	@InjectMocks
	ManagerService managerService;
	
	@Mock
	CustomerRepository customerRepo;
	
	@Mock
	HomeLoanRepository homeLoan;
	
	@Mock
	BankEmployeeRepository bankRepo;
	
	@Test
	public void addCustomer()
	{
		Customer customer = new Customer();
		Mockito.when(customerRepo.save(customer)).thenReturn(customer);
		HomeLoanDto actualResponse = customerService.addCustomer(customer);
		Assert.assertEquals("Customer saved successfully", actualResponse.getMessage());
	}
	
	@Test
	public void approveLoanTest() {
		LoanDetails loan = getLoan();
		BankEmployeeDetails bankOfficer = getBankOfficerDetails();
		Customer customer = getCustomer();

		Mockito.when(homeLoan.findById((int) Mockito.anyLong())).thenReturn(Optional.of(loan));
		Mockito.when(bankRepo.findById((int) Mockito.anyLong())).thenReturn(Optional.of(bankOfficer));
		// Mockito.when(iLoanRepository.save(loan)).thenReturn(loan);
		HomeLoanDto actualResponse = managerService.updateHomeLoan(loan.getId(), "Active", bankOfficer.getId());
		Assert.assertEquals("Loan approved", actualResponse.getMessage());

	}
	
	public Customer getCustomer() {
		Customer customer = new Customer();
		customer.setId(1);
		customer.setCustomerAge(30);
		customer.setCustomerProfessional("SE");
		customer.setCustomerMartial("Single");
		customer.setCustomerPhone("6767676767");
		customer.setCustomerName("Giri");
		return customer;
	}
	
	
	public BankEmployeeDetails getBankOfficerDetails() {
		BankEmployeeDetails bankOfficer = new BankEmployeeDetails();
		bankOfficer.setId(1);
		bankOfficer.setEmployeeDesignation("Officer");
		bankOfficer.setEmployeeName("Priys");
		return bankOfficer;
	}
	
	public LoanDetails getLoan() {
		LoanDetails loan = new LoanDetails();
		loan.setId(1);
		loan.setAccountNumber("1111");
		loan.setCreditScore(950);
		loan.setPropertyValue(50000L);
		Customer customer = getCustomer();
		loan.setCustomer(customer);
		loan.setExpectedLoan(20000L);
		return loan;
	}
	
	
	
	

}
