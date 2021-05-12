package com.cg.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.cg.entities.Customer;
import com.cg.entities.Order;
import com.cg.exception.CustomerIdNotFoundException;
import com.cg.exception.DuplicateOrderNoFoundException;
import com.cg.exception.OrderDateNotFoundException;
import com.cg.exception.OrderNoNotFoundException;

public interface IOrderService {

	  /*public Order addOrder(Order order);
	  public Order viewOrder(int orderNo);
	  public Order updateOrderDetails(Order order);
	 
	  public List<Order> viewAllOrders(Customer custid);
	  public List<Order> viewOrderList();
	  public List<Order> cancelOrder(int orderNo);
	  
      public List<Order> viewOrderList(Date date);
	  Optional<Order> getOrderByNo(int orderNo);
	//public List<Order> addDate(Date date);*/
	  
	  //Testing 
	  
	  public Order createOrder(Order ord) throws DuplicateOrderNoFoundException,OrderNoNotFoundException,CustomerIdNotFoundException,OrderDateNotFoundException;
	  public Optional<Order> readOrderNo(Integer orderNo) throws OrderNoNotFoundException;
	  
	  public Optional<Order> readcustomerId(Integer custometId) throws CustomerIdNotFoundException;
	  public List<Order> viewOrderList(String date) throws OrderDateNotFoundException;
	  
	  //mockito tesing
	  public Order addOrder(Order order);
	  public Order updateOrderDetails(Order order);
	  public List<Order> cancelOrder(int orderNo);
}
