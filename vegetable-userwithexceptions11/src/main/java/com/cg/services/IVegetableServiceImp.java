package com.cg.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exceptions.DuplecateVegetableException;
import com.cg.exceptions.VegetableNotFoundException;
import com.cg.model.VegetableDTO;
import com.cg.repository.VegetableJPARepository;

@Service
public class IVegetableServiceImp implements IVegetableService {
	@Autowired
	public VegetableJPARepository VegetableRepo;

	@Override // get Vegetable details by vegetable name.
	public List<VegetableDTO> viewVegetableByName(String name) {
		List<VegetableDTO> viewVegetableByName = VegetableRepo.viewVegetableByName(name);
		// TODO Auto-generated method stub
		return viewVegetableByName;
	}

	@Override // get Vegetable list details by category.
	public List<VegetableDTO> viewVegetableList(String category) {
		List<VegetableDTO> viewVegetableList = VegetableRepo.viewVegetableList(category);
		// TODO Auto-generated method stub
		return viewVegetableList;
	}

	@Override // get all the vegetables.
	public List<VegetableDTO> viewAllVegetables() {
		List<VegetableDTO> viewAllVegetables = VegetableRepo.findAll();
		// TODO Auto-generated method stub
		return viewAllVegetables;
	}

	@Override // get Vegetable details.
	public VegetableDTO viewVegetable(Integer vegId) {
		Optional<VegetableDTO> viewVegetable = VegetableRepo.findById(vegId);
		// TODO Auto-generated method stub
		return viewVegetable.get();
	}

	@Override // adding Vegetable details.
	public VegetableDTO addVegetable(VegetableDTO dto){
		// TODO Auto-generated method stub
		return VegetableRepo.save(dto);
	}

	@Override // update Vegetable details.
	public VegetableDTO updateVegetable(VegetableDTO dto) {
		// TODO Auto-generated method stub
		return VegetableRepo.save(dto);
	}

	@Override // delete Vegetable details.
	public List<VegetableDTO> removeVegetable(Integer vegId) {
		// TODO Auto-generated method stub
		VegetableRepo.deleteById(vegId);
		return VegetableRepo.findAll();
	}

	@Override // get Vegetable details by category.
	public List<VegetableDTO> findByCategory(String category) {
		// TODO Auto-generated method stub

		return (List<VegetableDTO>) VegetableRepo.findByCategory(category);
	}

	@Override // get Vegetable details by vegetableId.
	public Optional<VegetableDTO> findByVegId(Integer vegId) {
		// TODO Auto-generated method stub
		return VegetableRepo.findById(vegId);
	}
	@Override
	public VegetableDTO createVegetable(VegetableDTO veg)
			throws DuplecateVegetableException, VegetableNotFoundException {
		System.out.println("VegetableId:"+veg.getVegId());
		Optional<VegetableDTO> result= VegetableRepo.findById(veg.getVegId());
		if(result!=null) {
			System.out.println("Duplicate id");
			if(result.get().getVegId()==veg.getVegId()) 
			throw new DuplecateVegetableException("Vegetable with "+veg.getVegId()+" already Exist");	
		}
		if(veg.getVegId()<=0)
			throw new VegetableNotFoundException("Vegetable Not Found");
		// TODO Auto-generated method stub
		return VegetableRepo.save(veg);
	}

	@Override
	public Optional<VegetableDTO> readVegId(Integer vegId) throws VegetableNotFoundException {
		Optional<VegetableDTO> result = VegetableRepo.findById(vegId);
		if(result == null) {
			throw new VegetableNotFoundException("Vegetable not found");
			}
		return result;		// TODO Auto-generated method stub
	}

}
