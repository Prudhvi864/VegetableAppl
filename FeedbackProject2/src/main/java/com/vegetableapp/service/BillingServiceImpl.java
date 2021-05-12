package com.vegetableapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetableapp.entity.Billing;
import com.vegetableapp.exception.BillingIdNotFoundException;
import com.vegetableapp.exception.DuplicateBillIdFoundException;
import com.vegetableapp.exception.InvalidBillingFoundException;
import com.vegetableapp.repository.BillingRepository;

@Service // Adding Billing Service Implementation
public class BillingServiceImpl implements BillingService {
	@Autowired
	BillingRepository Repo;

	@Override
	public Billing addBill(Billing bill) { // Adding all Billings by Service Implementation
		// TODO Auto-generated method stub
		return Repo.save(bill);
	}

	@Override
	public Billing updateBill(Billing bill) { // Update Bills by BillingId using Service Implementation
		// TODO Auto-generated method stub
		return Repo.save(bill);
	}

	@Override
	public Billing viewBill(Integer billingId) { // View Bill by BillingId using Service Implementation
		Optional<Billing> billId = Repo.findById(billingId);
		// TODO Auto-generated method stub
		return billId.get();
	}

	@Override // Searching Billing from Service Implementation
	public Optional<Billing> getBillingById(int billingId) {
		return Repo.findById(billingId);

	}

	/***************************** Testing *********************************/

	@Override
	public Billing createBilling(Billing bill) throws DuplicateBillIdFoundException, InvalidBillingFoundException {
		// TODO Auto-generated method stub
		Billing billtest = null;
		System.out.println("BillingId:" + bill.getBillingId());
		Optional<Billing> result = Repo.findById(bill.getBillingId());
		if (result.isPresent()) {
			System.out.println("Id already exists.");
			throw new DuplicateBillIdFoundException("Billing with " + bill.getBillingId() + " already Exist");
		} else if (bill.getBillingId() <= 0) {
			throw new InvalidBillingFoundException("Id entered is Invalid");
		} else {
			billtest = Repo.save(bill);
		}
		return billtest;
	}

	@Override
	public Optional<Billing> readBillId(Integer BillingId) throws DuplicateBillIdFoundException {
		// TODO Auto-generated method stub
		Optional<Billing> result = Repo.findById(BillingId);
		if (result != null) {
			throw new DuplicateBillIdFoundException("Billing Id Already Exists");
		}
		return result;
	}

}
