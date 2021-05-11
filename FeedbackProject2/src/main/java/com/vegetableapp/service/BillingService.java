package com.vegetableapp.service;


import java.util.Optional;

import com.vegetableapp.entity.Billing;

public interface BillingService {
	public Billing addBill(Billing bill);
	public Billing updateBill(Billing bill);
	public Billing viewBill(Integer billingId);
	Optional<Billing> getBillingById(int billingId);

}
