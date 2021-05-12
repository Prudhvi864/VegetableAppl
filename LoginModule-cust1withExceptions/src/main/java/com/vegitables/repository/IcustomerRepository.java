package com.vegitables.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vegitables.entities.Customer;
@Repository
public interface IcustomerRepository extends JpaRepository<Customer,Integer>{

}
