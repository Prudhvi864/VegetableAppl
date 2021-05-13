package com.vegetableapp.billingtest;

import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vegetableapp.entity.Billing;
import com.vegetableapp.exception.DuplicateBillIdFoundException;
import com.vegetableapp.exception.InvalidBillingFoundException;
import com.vegetableapp.service.BillingService;

@SpringBootTest
public class BillingTest {
	@Autowired
	private BillingService Bills;

	@Test
	public void testDuplicateBillIdShouldThrowDDuplicateBillIdFoundException() throws DuplicateBillIdFoundException {
		assertThrows(DuplicateBillIdFoundException.class, () -> {
			Billing bill = new Billing(91, 21, "card", "08-MAR-2021", "pending", 11);
			Bills.readBillId(91);
		});
	}

	@Test
	public void testInvalidBillingFoundExceptionShouldThrowInvalidBillingFoundException()
			throws InvalidBillingFoundException {
		assertThrows(InvalidBillingFoundException.class, () -> {
			Billing bill = new Billing(-24, 111, "netbc", "08-DEC-2021", "not pending", 190);
			Bills.createBilling(bill);
		});
	}
}
