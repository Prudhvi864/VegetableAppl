package com.vegetableapp.ctrl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegetableapp.entity.Billing;
import com.vegetableapp.exception.BillingIdNotFoundException;
import com.vegetableapp.exception.DuplicateBillIdFoundException;
import com.vegetableapp.service.BillingService;

@RestController
@RequestMapping("/api/bill")
public class BillingController {
	@Autowired
	private BillingService service;

	@PostMapping("/addbill")
	public ResponseEntity<Billing> addBill(@RequestBody Billing bill) {
		Optional<Billing> addobj1 = service.getBillingById(bill.getBillingId());
		if (addobj1.isPresent()) {
			throw new DuplicateBillIdFoundException("Duplicate Bill Id Found, Already Exists");
		} else {
			service.addBill(bill);
		}
		return new ResponseEntity<Billing>(bill, HttpStatus.OK);
	}
	@PutMapping("/updatebill")
	public ResponseEntity<Billing> updateBill(@RequestBody Billing bill) {
		Optional<Billing> upobj1 = service.getBillingById(bill.getBillingId());
		Billing upobj2 = service.updateBill(bill);
		if (!upobj1.isPresent()) {
			throw new BillingIdNotFoundException("Billing cannot be update.");
		}
		return new ResponseEntity<Billing>(upobj2, HttpStatus.OK);
	}

	@GetMapping("/viewbill/{billingId}")
	public ResponseEntity<Billing> viewBill(@PathVariable("billingId") Integer billingId) {
		Optional<Billing> vbill = service.getBillingById(billingId);
		if (!vbill.isPresent()) {
			throw new BillingIdNotFoundException("Sorry! bill not Avalible with this Id: " + billingId + " to return");
		}
		return new ResponseEntity<Billing>(vbill.get(), HttpStatus.OK);
	}

}
