package com.vegetableapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetableapp.entity.Billing;
import com.vegetableapp.repository.BillingRepository;

@Service
public class BillingServiceImpl implements BillingService {
	@Autowired
	BillingRepository Repo;

	@Override
	public Billing addBill(Billing bill) {
		// TODO Auto-generated method stub
		return Repo.save(bill);
	}

	@Override
	public Billing updateBill(Billing bill) {
		// TODO Auto-generated method stub
		return Repo.save(bill);
	}

	@Override
	public Billing viewBill(Integer billingId) {
		Optional<Billing> billId = Repo.findById(billingId);
		// TODO Auto-generated method stub
		return billId.get();
	}

	@Override
	public Optional<Billing> getBillingById(int billingId) {
		return Repo.findById(billingId);

	}

}
