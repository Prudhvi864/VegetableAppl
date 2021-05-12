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

import com.cg.exceptions.DuplicateVegetableException;
import com.cg.exceptions.VegetableNotFoundException;
import com.cg.model.VegetableDTO;
import com.cg.services.IVegetableService;

/*
 * Web Controller deals with HTTP requests and HTTP responses.
 * */
@RestController
@RequestMapping("/api/v")
public class VegetableController {
	@Autowired
	private IVegetableService vegetableservice;

//get Vegetable details by vegetable name
	@GetMapping("/viewVegetableByName/{name}") // @GetMapping annotation maps to HTTP GET method.
	public ResponseEntity<List<VegetableDTO>> viewVegetableByName(@PathVariable("name") String name)
			throws VegetableNotFoundException {
		List<VegetableDTO> vegetableList = vegetableservice.viewVegetableByName(name);
		if (vegetableList.isEmpty()) {
			throw new VegetableNotFoundException("Vegetable is not found");
		}
		return new ResponseEntity<List<VegetableDTO>>(vegetableList, HttpStatus.OK);
	}

	// get Vegetable details by category
	@GetMapping("/viewVegetableList/{category}") // @GetMapping annotation maps to HTTP GET method.
	public ResponseEntity<List<VegetableDTO>> viewVegetableList(@PathVariable("category") String category)
			throws VegetableNotFoundException {
		List<VegetableDTO> vegList = vegetableservice.findByCategory(category);
		if (vegList.isEmpty()) {
			throw new VegetableNotFoundException("Category not found");
		}
		List<VegetableDTO> vegetableListByCategory = vegetableservice.viewVegetableList(category);
		return new ResponseEntity<List<VegetableDTO>>(vegetableListByCategory, HttpStatus.OK);

	}

	// get all the vegetables
	@GetMapping("/viewAllVegetables") // @GetMapping annotation maps to HTTP GET method.
	public ResponseEntity<List<VegetableDTO>> viewAllVegetables() throws VegetableNotFoundException {
		List<VegetableDTO> viewvegetableList = vegetableservice.viewAllVegetables();
		if (viewvegetableList.isEmpty()) {
			throw new VegetableNotFoundException("No Vegetable is found");
		}
		return new ResponseEntity<List<VegetableDTO>>(viewvegetableList, HttpStatus.OK);
	}

	// get Vegetable details by vegetableId
	@GetMapping("/viewVegetable/{vegId}") // @GetMapping annotation maps to HTTP GET method.
	public ResponseEntity<VegetableDTO> viewVegetable(@PathVariable("vegId") Integer vegId)
			throws VegetableNotFoundException {
		Optional<VegetableDTO> vegetableById = vegetableservice.findByVegId(vegId);
		if (vegetableById.isEmpty()) {
			throw new VegetableNotFoundException(" Vegetable Not found With This ID");
		}
		VegetableDTO vegetableListByVegID = vegetableservice.viewVegetable(vegId);
		return new ResponseEntity<VegetableDTO>(vegetableListByVegID, HttpStatus.OK);
	}

	// delete Vegetable details by vegetableId
	@DeleteMapping("/removeVegetable/{vegId}") // @DeleteMapping annotation maps to HTTP DELETE method.
	public ResponseEntity<List<VegetableDTO>> removeVegetable(@PathVariable("vegId") Integer vegId)
			throws VegetableNotFoundException {
		Optional<VegetableDTO> vegetable = vegetableservice.findByVegId(vegId);
		if (vegetable.isEmpty()) {
			return new ResponseEntity("Sorry! Vegetable not Avalible with this Id!", HttpStatus.NOT_FOUND);
		}
		List<VegetableDTO> removeVegetableFromList = vegetableservice.removeVegetable(vegId);
		return new ResponseEntity<List<VegetableDTO>>(removeVegetableFromList, HttpStatus.OK);
	}

	// adding Vegetable details
	@PostMapping("/addVegetable") // @PostMapping annotation maps to HTTP POST method.
	public ResponseEntity<VegetableDTO> addVegetable(@RequestBody VegetableDTO vegetableDTO) {
		Optional<VegetableDTO> vegetable = vegetableservice.findByVegId(vegetableDTO.getVegId());
		if (vegetable.isPresent()) {
			throw new DuplicateVegetableException("Duplicate Vegetable Id Found, Already Exists");
		}
		VegetableDTO addingVegetableToList = vegetableservice.addVegetable(vegetableDTO);

		return new ResponseEntity<VegetableDTO>(addingVegetableToList, HttpStatus.OK);
	}

	// update Vegetable details
	@PutMapping("/updateVegetable") // @PutMapping annotation maps to HTTP PUT method.
	public ResponseEntity<VegetableDTO> updateVegetable(@RequestBody VegetableDTO vegetableDTO) {
		Optional<VegetableDTO> vegetable = vegetableservice.findByVegId(vegetableDTO.getVegId());
		if (vegetable.isEmpty()) {
			throw new VegetableNotFoundException(" Vegetable Id Not Found.");
		}
		VegetableDTO updatingVegetableToList = vegetableservice.updateVegetable(vegetableDTO);
		return new ResponseEntity<VegetableDTO>(updatingVegetableToList, HttpStatus.OK);
	}
}
