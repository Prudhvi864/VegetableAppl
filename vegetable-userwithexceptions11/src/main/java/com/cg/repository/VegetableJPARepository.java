package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.model.VegetableDTO;
/*
 * @Repository annotation is used to indicate that the class provides the mechanism 
 * for storage, retrieval, search, update and delete operation on objects.
 * */
/*
 * JpaRepository (Defined in Spring Data JPA) is the JPA specific Repository interface. 
 * 
 * Vegetable is the entity that is being managed and the primary key of VegetableID is Integer.
 * */
@Repository
public interface VegetableJPARepository extends JpaRepository<VegetableDTO, Integer> {
	@Query("SELECT veg FROM VegetableDTO veg where veg.category=:cat")
	public List<VegetableDTO> viewVegetableList(@Param("cat") String category);
	@Query("SELECT veg FROM VegetableDTO veg where veg.name=:pnm")
	public List<VegetableDTO> viewVegetableByName(@Param("pnm") String name);
	@Query("SELECT veg FROM VegetableDTO veg where veg.category=:cat")
	public List<VegetableDTO> findByCategory(@Param("cat") String category);
}
