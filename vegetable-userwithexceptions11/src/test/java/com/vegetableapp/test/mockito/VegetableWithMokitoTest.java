package com.vegetableapp.test.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.management.loading.PrivateClassLoader;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.vegetableapp.model.VegetableDTO;
import com.vegetableapp.repository.VegetableJPARepository;
import com.vegetableapp.services.IVegetableServiceImp;

@SpringBootTest
public class VegetableWithMokitoTest {
	@Autowired
	private IVegetableServiceImp vegservice;
	@MockBean
	private VegetableJPARepository vegRepo;
	/*
	 * Method Name - removeVegetableTest, Parameter List - No parameter,
	 * Return type - Validation, Description - Testing the  removeVegetable method.
	 */
	@Test
	public void removeVegetableTest() {
		VegetableDTO veg = new VegetableDTO(42,"Tomato","Grape","Fruit",20,30);
		vegservice.removeVegetable(42);
		verify(vegRepo,times(1)).deleteById(42);
	}
	/*
	 * Method Name - saveVegetableTest, Parameter List - No parameter,
	 * Return type - Validation, Description - Testing the  saveVegetable method.
	 */
	@Test
	public void saveVegetableTest() {
		VegetableDTO veg = new VegetableDTO(42,"Tomato","Grape","Fruit",20,30);
		when(vegRepo.save(veg)).thenReturn(veg);
		assertEquals(veg,vegservice.addVegetable(veg));
	}
	

}
