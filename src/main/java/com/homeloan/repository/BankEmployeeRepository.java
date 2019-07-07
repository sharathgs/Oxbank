package com.homeloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homeloan.model.BankEmployeeDetails;

@Repository
public interface BankEmployeeRepository extends JpaRepository<BankEmployeeDetails, Integer> {

}
