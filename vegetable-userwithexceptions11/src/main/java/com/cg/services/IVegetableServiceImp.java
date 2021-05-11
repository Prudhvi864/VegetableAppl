package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.VegetableDTO;
import com.cg.repository.VegetableJPARepository;

@Service
public class IVegetableServiceImp implements IVegetableService {
	@Autowired
	public VegetableJPARepository VegetableRepo;

	@Override
	public List<VegetableDTO> viewVegetableByName(String name) {
		List<VegetableDTO> viewVegetableByName = VegetableRepo.viewVegetableByName(name);
		// TODO Auto-generated method stub
		return viewVegetableByName;
	}

	@Override
	public List<VegetableDTO> viewVegetableList(String category) {
		List<VegetableDTO> viewVegetableList = VegetableRepo.viewVegetableList(category);
		// TODO Auto-generated method stub
		return viewVegetableList;
	}

	@Override
	public List<VegetableDTO> viewAllVegetables() {
		List<VegetableDTO> viewAllVegetables = VegetableRepo.findAll();
		// TODO Auto-generated method stub
		return viewAllVegetables;
	}

	@Override
	public VegetableDTO viewVegetable(Integer vegId) {
		Optional<VegetableDTO> viewVegetable = VegetableRepo.findById(vegId);
		// TODO Auto-generated method stub
		return viewVegetable.get();
	}

	
	@Override
	public VegetableDTO addVegetable(VegetableDTO dto) {

		// TODO Auto-generated method stub
		return VegetableRepo.save(dto);
	}

	@Override
	public VegetableDTO updateVegetable(VegetableDTO dto) {
		// TODO Auto-generated method stub
		return VegetableRepo.save(dto);
	}

	@Override
	public List<VegetableDTO> removeVegetable(Integer vegId) {
		// TODO Auto-generated method stub
		 VegetableRepo.deleteById(vegId); 
		  return VegetableRepo.findAll();
	}

	@Override
	public List<VegetableDTO> findByCategory(String category) {
		// TODO Auto-generated method stub
		
		return (List<VegetableDTO>) VegetableRepo.findByCategory(category);
	}

	@Override
	public Optional<VegetableDTO> findByVegId(Integer vegId) {
		// TODO Auto-generated method stub
		return VegetableRepo.findById(vegId);
	}

	/*@Override
	public VegetableDTO removeVegetable(VegetableDTO veg) {
		VegetableDTO removeVegetable = VegetableRepo.removeVegetable(veg.getVegId());
		// TODO Auto-generated method stub
		return removeVegetable;
	}*/

}
