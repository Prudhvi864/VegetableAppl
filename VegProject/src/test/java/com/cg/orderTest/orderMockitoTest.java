package com.cg.orderTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.entities.Order;
import com.cg.repository.IOrderRepository;
import com.cg.service.IOrderService;
import com.cg.service.IOrderServiceImpl;

@SpringBootTest
public class orderMockitoTest {
@MockBean
private IOrderRepository orderRepo;
@Autowired
IOrderService orderservice;
/*
 * Method Name - addOrderTest, Parameter List - No parameter,
 * Return type - Validation, Description - Testing the addOrder method. .
 */
@Test
public void addOrderTest() {
	Order veg = new Order(33, 17, 303, 400, "11-JAN-21", "good");
	when(orderRepo.save(veg)).thenReturn(veg);
	assertEquals(veg,orderservice.addOrder(veg));
}


/*
 * Method Name - updateOrderDetailsTest, Parameter List - No parameter,
 * Return type - Validation, Description - Testing the updateOrderDetails method. .
 */
@Test
public void updateOrderDetailsTest() {
	Order order = new Order(35,33 , 304, 700, "16-JAN-21", "bad");
	orderservice.updateOrderDetails(order);
	verify(orderRepo, times(1)).saveAndFlush(order);
}

/*
 * Method Name - cancelOrderTest, Parameter List - No parameter,
 * Return type - Validation, Description - Testing cancelOrder method. .
 */
@Test
public void cancelOrderTest() {
Order veg = new Order(34, 17, 303, 400, "11-JAN-21", "good");
orderservice.cancelOrder(34);
verify(orderRepo,times(1)).deleteById(34);
}





}
	

	
	

