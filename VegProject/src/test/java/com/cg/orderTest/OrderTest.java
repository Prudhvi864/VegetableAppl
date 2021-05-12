package com.cg.orderTest;




import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.exception.CustomerIdNotFoundException;
import com.cg.exception.DuplicateOrderNoFoundException;
import com.cg.exception.OrderDateNotFoundException;
import com.cg.exception.OrderNoNotFoundException;

import com.cg.entities.Order;
import com.cg.service.IOrderService;

@SpringBootTest
public class OrderTest {
	@Autowired
	private IOrderService iorder;
	
	@Test
	public void testDuplicateOrderNoShouldThrowDuplicateOrderNoFoundException() throws DuplicateOrderNoFoundException  {
		assertThrows(DuplicateOrderNoFoundException.class, ()->{
			Order orders = new Order(32,17,303,400,"11-JAN-21","good");
			iorder.createOrder(orders);
		});	
	}
	
	@Test
	public void testCustomerIdShouldThrowCustomerIdNotFoundException() throws CustomerIdNotFoundException  {
		assertThrows(CustomerIdNotFoundException.class, ()->{
			//Order orders = new Order(32,17,303,400,"11-JAN-21","good");
			iorder.readcustomerId(202);
		});	
	}
	@Test
	public void testOrderDateShouldThrowOrderDateNotFoundException() throws OrderDateNotFoundException  {
		assertThrows(OrderDateNotFoundException.class, ()->{
			//Order orders = new Order(32,17,303,400,"11-JAN-21","good");
			iorder.viewOrderList("12-JAN-21");
		});	
	}
	
	
	
//	@Test
//	public void testDuplecateVegetableIdShouldThrowVegetableNotFoundException() {
//		assertThrows(VegetableNotFoundException.class, ()->{
//			ivegs.readVegId(400);
//		});
//	}

}

