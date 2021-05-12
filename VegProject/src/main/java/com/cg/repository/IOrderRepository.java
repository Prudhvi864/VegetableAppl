package com.cg.repository;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entities.Customer;
import com.cg.entities.Order;

/*
 * @Repository annotation is used to indicate that the class provides the mechanism 
 * for storage, retrieval, search, update and delete operation on objects.
 * */

/*
 * JpaRepository (Defined in Spring Data JPA) is the JPA specific Repository interface. 
 * 
 * Order is the entity that is being managed and the primary key of OrderNo is Integer.
 * */

@Repository

public interface IOrderRepository extends JpaRepository<Order,Integer>{


	
	
	/*@Query("SELECT order FROM Order order where order.customerId=:cat")
	public List<Order> viewAllOrders(@Param("cat") Customer custid);
	
	@Query("SELECT order FROM Order order where order.Date=:date")
	public List<Order> findAllByDate(@Param("date") Date date);
	
	//public Optional<Order> getOrderByNo(int orderNo);*/

	
	
	
	
	
	
	//tesing
	@Query("SELECT order FROM Order order where order.customerId=:customerId")
	public Optional<Order> findByCustomerId(@Param("customerId") int customerId);
	
	@Query("SELECT order FROM Order order where order.date=:date")
	public List<Order> findAllByDate(@Param("date") String date);

	
	
	
	
	

	
	

}
