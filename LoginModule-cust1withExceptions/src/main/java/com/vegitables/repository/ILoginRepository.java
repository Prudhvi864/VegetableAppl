package com.vegitables.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vegitables.entities.Admin;
import com.vegitables.entities.Customer;

public interface ILoginRepository extends JpaRepository<Customer, Integer> {

	/* validating customer using emailId */
	@Query("select cm from Customer cm where cm.emailId=?1")
	Optional<Customer> findByEmailId(String email);

	/* validating admin using adminId */
	@Query("select am from Admin am where am.emailId=?1")
	Optional<Admin> findByAdminId(String email);
}
