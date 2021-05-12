package com.cg.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Customer;
import com.cg.entities.Order;
import com.cg.exception.CustomerIdNotFoundException;
import com.cg.exception.DuplicateOrderNoFoundException;
import com.cg.exception.OrderDateNotFoundException;
import com.cg.exception.OrderNoNotFoundException;
import com.cg.service.IOrderService;

/*
 * Web Controller deals with HTTP requests and HTTP responses.
 * */


@RestController
@RequestMapping("/rest/order")
public class OrderController {
	@Autowired
	private IOrderService orderservice;
/*	//adding order details 
	@PostMapping(path="/addorder",produces = "application/json")  //@PostMapping annotation maps to HTTP POST method.
	public ResponseEntity<Order> addOrder(@RequestBody Order order){
		Optional<Order> result1 = orderservice.getOrderByNo(order.getOrderNo());
		if(result1.isPresent()) {
			throw new DuplicateOrderNoFoundException("Duplicate Order Number Found .");
		} else {
		orderservice.addOrder(order);
		}
		return new ResponseEntity<Order>(order,HttpStatus.OK);
	}
	//update order details
	@PutMapping(path="/updateorderdetails",produces = "application/json") // @PutMapping annotation maps to HTTP PUT method.
	public ResponseEntity<Order> updateOrderDetails(@RequestBody Order order){
		Optional<Order> result1 = orderservice.getOrderByNo(order.getOrderNo());
		Order result=orderservice.updateOrderDetails(order);
		if(!result1.isPresent())
		{
			throw new OrderNoNotFoundException("Order cannot be update.");
		}
		return new ResponseEntity<Order>(result,HttpStatus.OK);
	}
	

	//view order by order number
	@GetMapping(path = "/vieworder/{orderNo}", produces = "application/json")  // @GetMapping annotation maps to HTTP GET method.
    public ResponseEntity<Order> viewOrder(@PathVariable(value = "orderNo") int orderNo) {
		Optional<Order> result1=orderservice.getOrderByNo(orderNo);
		if(!result1.isPresent()) {
			throw new OrderNoNotFoundException("Order number is not present "+orderNo);
		}
        return new ResponseEntity<>(orderservice.viewOrder(orderNo), HttpStatus.OK);
    }
	//delete order by order number
	@DeleteMapping(path = "/cancelorder/{orderNo}", produces = "application/json") // @DeleteMapping annotation maps to HTTP DELETE method
    public ResponseEntity<List<Order>> cancelOrder(@PathVariable(value = "orderNo") int orderNo) throws OrderNoNotFoundException {
		Optional<Order> result2=orderservice.getOrderByNo(orderNo);
		if (result2.isEmpty()) {
			throw new OrderNoNotFoundException("Sorry! Order not Avalible with this Number!");
		}
		List<Order> result1=orderservice.cancelOrder(orderNo);
		
		//List<Order> result = orderservice.cancelOrder(orderNo);
        return new ResponseEntity<List<Order>>(result1, HttpStatus.OK);
    }
	
	
	//view  all orders by customer id
	@GetMapping(path = "/viewallorders/{customerId}", produces = "application/json")  // @GetMapping annotation maps to HTTP GET method.
    public ResponseEntity<List<Order>> viewAllOrders(@PathVariable(value = "customerId") Customer custid) throws CustomerIdNotFoundException{
		List<Order> result = orderservice.viewAllOrders(custid);
		if(result.isEmpty()) {
			throw new CustomerIdNotFoundException("Sorry! Customer Id is not present with !"+custid);
		}
        return new ResponseEntity<List<Order>>(result, HttpStatus.OK);
    }
	
	//view All order List
	@GetMapping(path = "/orderlist",produces = "application/json")   // @GetMapping annotation maps to HTTP GET method.
    public ResponseEntity<List<Order>> viewOrderList() {
		List<Order> result = orderservice.viewOrderList();
		if(result.isEmpty()) {
			throw new OrderNoNotFoundException("order List not Found");
		}
        return new ResponseEntity<List<Order>>(result, HttpStatus.OK);
    }
	
	
	
	/*@PostMapping(path="/adddate",produces = "application/json")
	public ResponseEntity<Order> addOrder(@RequestBody Date date){
		List<Order> result = orderservice.viewOrderList();
		//Optional<Order> result1 = orderservice.getOrderByDate(date.getOrderDate());
		if(result.isEmpty()) {
			throw new DuplicateOrderNoFoundException("Duplicate Order Number Found .");
		} else {
		orderservice.addDate(date);
		}
		return new ResponseEntity<Order>(HttpStatus.OK);
	}*/
	
	
	/*//Get all orders by date
	@GetMapping(path = "/orderlistbydate/{Date}",produces = "application/json")  // @GetMapping annotation maps to HTTP GET method.
    public ResponseEntity<List<Order>> viewOrderList1(@PathVariable(value = "Date") Date date) {
		List<Order> result = orderservice.viewOrderList(date);
		if(result.isEmpty()) {
			throw new OrderDateNotFoundException("Order Date Not Present");
		}
        return new ResponseEntity<List<Order>>(result, HttpStatus.OK);
    }
	
	
*/
	
}
