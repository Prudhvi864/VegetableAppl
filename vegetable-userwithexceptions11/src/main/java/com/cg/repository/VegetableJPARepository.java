package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.model.VegetableDTO;

public interface VegetableJPARepository extends JpaRepository<VegetableDTO, Integer> {
	@Query("SELECT veg FROM VegetableDTO veg where veg.category=:cat")
	public List<VegetableDTO> viewVegetableList(@Param("cat") String category);
	@Query("SELECT veg FROM VegetableDTO veg where veg.name=:pnm")
	public List<VegetableDTO> viewVegetableByName(@Param("pnm") String name);
	@Query("SELECT veg FROM VegetableDTO veg where veg.category=:cat")
	public List<VegetableDTO> findByCategory(@Param("cat") String category);
	
}
