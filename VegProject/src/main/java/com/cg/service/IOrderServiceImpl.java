package com.cg.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Customer;
import com.cg.entities.Order;
import com.cg.exception.CustomerIdNotFoundException;
import com.cg.exception.DuplicateOrderNoFoundException;
import com.cg.exception.OrderDateNotFoundException;
import com.cg.exception.OrderNoNotFoundException;
import com.cg.repository.IOrderRepository;

@Service
public class IOrderServiceImpl implements IOrderService {
	@Autowired
	public IOrderRepository orderRepo;

	/*@Override    // adding Vegetable details.
	public Order addOrder(Order order) {
		return orderRepo.save(order);
		
	}

	@Override    // update Vegetable details.
	public Order updateOrderDetails(Order order) {
		return orderRepo.save(order);
	}
	
	@Override    //get order details based on order no.
    public Order viewOrder(int orderNo) {
        Optional<Order> optionalOrd = orderRepo.findById(orderNo);
        if (optionalOrd.isPresent()) {
            return optionalOrd.get();
        }
        return null;
	}

	@Override     // delete order by customer Id.
	public List<Order> cancelOrder(int orderNo) {
		// TODO Auto-generated method stub
		orderRepo.deleteById(orderNo);
		return orderRepo.findAll();
	}

	@Override      //get all the orders by customer id.
	public List<Order> viewAllOrders(Customer custid) {
		// TODO Auto-generated method stub
		List<Order> order=orderRepo.viewAllOrders(custid);
		return order;
	}

	@Override    //get all the orders.
	public List<Order> viewOrderList() {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}

	@Override     //get all the orders by Date.
	public List<Order> viewOrderList(Date date) {
		// TODO Auto-generated method stub
		return orderRepo.findAllByDate(date);
	}
	
	@Override
	public Optional<Order> getOrderByNo(int orderNo) {
		return orderRepo.findById(orderNo);
	}*/
	
	@Override     //Tesing
	public List<Order> viewOrderList(String date) throws OrderDateNotFoundException{
		List<Order> result=orderRepo.findAllByDate(date);
		if(result.isEmpty()) {
			throw new OrderDateNotFoundException("No Order is not present on that date:");
		} 
		// TODO Auto-generated method stub
		return result;
	}
	
	

	@Override
	public Order createOrder(Order ord) throws DuplicateOrderNoFoundException{
		// TODO Auto-generated method stub
		System.out.println("OrderNo:"+ord.getOrderNo());
		Optional<Order> result= orderRepo.findById(ord.getOrderNo());
		if(result!=null) {
			System.out.println("Duplicate id");
			//if(result.get().getOrderNo()==ord.getOrderNo()) 
			throw new DuplicateOrderNoFoundException("Order with "+ord.getOrderNo()+" already Exist");	
		}
		else {
			orderRepo.save(ord);
		}
		//if(ord.getOrderNo()<=0) {
			//throw new OrderNoNotFoundException("Order number Not Found");
		// TODO Auto-generated method stub
		//return orderRepo.save(ord);
	//}
		return ord;
	}

	@Override
	public Optional<Order> readOrderNo(Integer orderNo) throws OrderNoNotFoundException {
		// TODO Auto-generated method stub
		  Optional<Order> result = orderRepo.findById(orderNo);
		if(result == null) {
			throw new OrderNoNotFoundException("order number not found");
			}
		return result;
		
	}

	@Override
	public Optional<Order> readcustomerId(Integer customerId) throws CustomerIdNotFoundException {
		// TODO Auto-generated method stub
		  Optional<Order> result = orderRepo.findByCustomerId(customerId);
		if(result.isEmpty()) {
			throw new CustomerIdNotFoundException("customer Id not found");
			}
		return result;
	
	}
	
	//Mockito Testing

	@Override    // adding Vegetable details.
	public Order addOrder(Order order) {
		return orderRepo.save(order);
		
	}

	@Override    // update Vegetable details.
	public Order updateOrderDetails(Order order) {
		return orderRepo.save(order);
	}
	@Override     // delete order by customer Id.
	public List<Order> cancelOrder(int orderNo) {
		// TODO Auto-generated method stub
		orderRepo.deleteById(orderNo);
		return orderRepo.findAll();
	}

	



		



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Override
	public List<Order> addDate(Date date) {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
		
	}*/

	

	


	/*@Override
	public List<Order> viewOrderList1(LocalDate date) {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}*/
}
        
