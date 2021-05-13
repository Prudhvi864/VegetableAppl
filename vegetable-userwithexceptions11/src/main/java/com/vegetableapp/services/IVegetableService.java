package com.vegetableapp.services;

import java.util.List;
import java.util.Optional;

import com.vegetableapp.exceptions.DuplicateVegetableException;
import com.vegetableapp.exceptions.VegetableNotFoundException;
import com.vegetableapp.model.VegetableDTO;

public interface IVegetableService {
	public VegetableDTO addVegetable(VegetableDTO veg);

	public VegetableDTO updateVegetable(VegetableDTO veg);

	public VegetableDTO viewVegetable(Integer vegId);

	public List<VegetableDTO> viewAllVegetables();

	public List<VegetableDTO> viewVegetableList(String category);

	public List<VegetableDTO> viewVegetableByName(String name);

	public List<VegetableDTO> removeVegetable(Integer vegId);

	public List<VegetableDTO> findByCategory(String category);

	public Optional<VegetableDTO> findByVegId(Integer vegId);
	
	public VegetableDTO createVegetable(VegetableDTO veg) throws DuplicateVegetableException,VegetableNotFoundException;
	public Optional<VegetableDTO> readVegId(int vegId) throws VegetableNotFoundException;

}
