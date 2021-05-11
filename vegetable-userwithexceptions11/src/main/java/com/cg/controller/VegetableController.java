package com.cg.controller;

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

import com.cg.exceptions.DuplecateVegetableException;
import com.cg.exceptions.VegetableNotFoundException;
import com.cg.model.VegetableDTO;
import com.cg.services.IVegetableService;

@RestController
@RequestMapping("/api/v")
public class VegetableController {
	@Autowired
	private IVegetableService vegetableservice;

	@GetMapping("/viewVegetableByName/{name}")
	public ResponseEntity<List<VegetableDTO>> viewVegetableByName(@PathVariable("name") String name)
			throws VegetableNotFoundException {
		List<VegetableDTO> vegetableList = vegetableservice.viewVegetableByName(name);
		if(vegetableList.isEmpty()) {
			throw new VegetableNotFoundException("Vegetable is not found");
		}
		return new ResponseEntity<List<VegetableDTO>>(vegetableList, HttpStatus.OK);
	}

	@GetMapping("/viewVegetableList/{category}")
	public ResponseEntity<List<VegetableDTO>> viewVegetableList(@PathVariable("category") String category)
			throws VegetableNotFoundException {
//		List<VegetableDTO> vegetableList2= vegetableservice.viewVegetableList(category);
//		
//		if(vegetableList3.contains(category)) {
//			return new ResponseEntity<List<VegetableDTO>>(vegetableList2,HttpStatus.OK);
//		}
//		if(vegetableList2.isEmpty()) {
//			return new ResponseEntity("Sorry! Vegetable category not Avalible!",HttpStatus.NOT_FOUND);
//		}
//			return new ResponseEntity<List<VegetableDTO>>(vegetableList2,HttpStatus.OK);
//		
//		List<VegetableDTO> vegetableList3= vegetableservice.viewAllVegetables();
//		if(!(vegetableList3.contains(category))) 
//		{
//			throw new VegetableNotFoundException("Category not found");
//		}
//		List<VegetableDTO> vegetable=vegetableservice.viewVegetableList(category);	
//			
//		return  new ResponseEntity<List<VegetableDTO>>(vegetable,HttpStatus.OK);
		
		
		//VegetableDTO vegList =  vegetableservice.findByCategory(category);
	//	if (vegList==null) {
			//throw new VegetableNotFoundException("Category not found");
		//}
         List<VegetableDTO> vegList = vegetableservice.findByCategory(category);
         if(vegList.isEmpty()) {
        	 throw new VegetableNotFoundException("Category not found");
         }
		List<VegetableDTO> vegetable = vegetableservice.viewVegetableList(category);
		return new ResponseEntity<List<VegetableDTO>>(vegetable, HttpStatus.OK);

	}

	@GetMapping("/viewAllVegetables")
	public ResponseEntity<List<VegetableDTO>> viewAllVegetables() throws VegetableNotFoundException {
		List<VegetableDTO> vegetableList3 = vegetableservice.viewAllVegetables();
		if (vegetableList3.isEmpty()) {
			throw new VegetableNotFoundException("No Vegetable is found");
		}
		return new ResponseEntity<List<VegetableDTO>>(vegetableList3, HttpStatus.OK);
	}

	@GetMapping("/viewVegetable/{vegId}")
	public ResponseEntity<VegetableDTO> viewVegetable(@PathVariable("vegId") Integer vegId)
			throws VegetableNotFoundException {
		Optional<VegetableDTO> vegetable = vegetableservice.findByVegId(vegId);
		if (vegetable.isEmpty()) {
			throw new VegetableNotFoundException(" Vegetable Not found With This ID");
		}
		VegetableDTO vegetableList4 = vegetableservice.viewVegetable(vegId);
		return new ResponseEntity<VegetableDTO>(vegetableList4, HttpStatus.OK);
	}

	@DeleteMapping("/removeVegetable/{vegId}")
	public ResponseEntity<List<VegetableDTO>> removeVegetable(@PathVariable("vegId") Integer vegId)
			throws VegetableNotFoundException {
		Optional<VegetableDTO> vegetable = vegetableservice.findByVegId(vegId);
		if (vegetable.isEmpty()) {
			return new ResponseEntity("Sorry! Vegetable not Avalible with this Id!", HttpStatus.NOT_FOUND);
		}
		List<VegetableDTO> vegetableList5 = vegetableservice.removeVegetable(vegId);
		return new ResponseEntity<List<VegetableDTO>>(vegetableList5, HttpStatus.OK);
	}
	/*
	 * @DeleteMapping("/removeVegetable/{vegId}") public
	 * ResponseEntity<VegetableDTO> removeVegetable(@RequestBody VegetableDTO
	 * vegetableDTO){ VegetableDTO
	 * vegetable=vegetableservice.removeVegetable(vegetableDTO); return new
	 * ResponseEntity<VegetableDTO>(vegetable,HttpStatus.OK); }
	 */

	@PostMapping("/addVegetable")
	public ResponseEntity<VegetableDTO> addVegetable(@RequestBody VegetableDTO vegetableDTO){
		Optional<VegetableDTO> vegetable = vegetableservice.findByVegId(vegetableDTO.getVegId());
		if(vegetable.isPresent()) {
			throw new DuplecateVegetableException("Duplicate Vegetable Id Found, Already Exists");
		}
		VegetableDTO vegetableList5 = vegetableservice.addVegetable(vegetableDTO);
		
		return new ResponseEntity<VegetableDTO>(vegetableList5, HttpStatus.OK);
	}
	/*@PostMapping("/addbill")
    public ResponseEntity<Billing> addBill(@RequestBody Billing bill) {
        Optional<Billing> addobj1 = service.getBillingById(bill.getBillingId());
        if (addobj1.isPresent()) {
            throw new DuplicateBillIdFoundException("Duplicate Bill Id Found, Already Exists");
        } else {
            service.addBill(bill);
        }
        return new ResponseEntity<Billing>(bill, HttpStatus.OK);
    }*/

	@PutMapping("/updateVegetable")
	public ResponseEntity<VegetableDTO> updateVegetable(@RequestBody VegetableDTO vegetableDTO) {
		Optional<VegetableDTO> vegetable = vegetableservice.findByVegId(vegetableDTO.getVegId());
		if(vegetable.isPresent()) {
			throw new DuplecateVegetableException("Duplicate Vegetable Id Found, Already Exists");
		}
		VegetableDTO vegetableList6 = vegetableservice.updateVegetable(vegetableDTO);
		return new ResponseEntity<VegetableDTO>(vegetableList6, HttpStatus.OK);
	}
}
