package com.vegetableapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vegetableapp.entity.Billing;
@Repository
public interface BillingRepository extends JpaRepository<Billing,Integer>{

}
