package com.homeloan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "loan")
public class LoanDetails {
	
	@Id
	@GeneratedValue
	private int id;
	private int creditScore;
	private Long expectedLoan;
	private Long propertyValue;
	private Double pendingEmi;
	private String status;
	private int managerId;
	private String accountNumber;
	
	@OneToMany
	private Customer customer;
	
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	public Long getExpectedLoan() {
		return expectedLoan;
	}
	public void setExpectedLoan(Long expectedLoan) {
		this.expectedLoan = expectedLoan;
	}
	public Long getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(Long propertyValue) {
		this.propertyValue = propertyValue;
	}
	public Double getPendingEmi() {
		return pendingEmi;
	}
	public void setPendingEmi(Double pendingEmi) {
		this.pendingEmi = pendingEmi;
	}
	
	

}
