package com.homeloan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.homeloan.model.LoanDetails;

@Repository
public interface HomeLoanRepository extends JpaRepository<LoanDetails, Integer> {
	
	@Query(value = "SELECT * FROM loan u WHERE u.status = ?1", nativeQuery = true)
	List<LoanDetails> findByStatus(String status);

}
