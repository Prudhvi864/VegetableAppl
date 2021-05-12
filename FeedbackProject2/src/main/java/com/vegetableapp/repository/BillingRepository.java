package com.vegetableapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*
 * @Repository annotation is used to indicate that the class provides the mechanism 
 * for storage, retrieval, search, update and delete operation on objects.
 *
 *
 * JpaRepository (Defined in Spring Data JPA) is the JPA specific Repository interface. 
 * 
 * Billing  is the entity that is being managed and the primary key of BillingID is Integer.
 */
import com.vegetableapp.entity.Billing;
@Repository
public interface BillingRepository extends JpaRepository<Billing,Integer>{

}
