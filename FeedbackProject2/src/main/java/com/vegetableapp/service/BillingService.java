package com.vegetableapp.service;

import java.util.Optional;

import com.vegetableapp.entity.Billing;
import com.vegetableapp.exception.BillingIdNotFoundException;
import com.vegetableapp.exception.DuplicateBillIdFoundException;
import com.vegetableapp.exception.InvalidBillingFoundException;

public interface BillingService {
	public Billing addBill(Billing bill);

	public Billing updateBill(Billing bill);

	public Billing viewBill(Integer billingId);

	Optional<Billing> getBillingById(int billingId);

	public Billing createBilling(Billing bill) throws DuplicateBillIdFoundException, InvalidBillingFoundException;

	public Optional<Billing> readBillId(Integer BillingId) throws BillingIdNotFoundException;

}
