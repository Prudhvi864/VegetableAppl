package com.vegetableapp.test.vegetable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vegetableapp.exceptions.DuplicateVegetableException;
import com.vegetableapp.exceptions.VegetableNotFoundException;
import com.vegetableapp.model.VegetableDTO;
import com.vegetableapp.services.IVegetableService;

@SpringBootTest
public class VegetableDTOTest {
	@Autowired
	private IVegetableService ivegs;
	@Test
	public void testFindVegetableByIdShouldReturnVegObject() throws DuplicateVegetableException,VegetableNotFoundException{
		VegetableDTO vegetable = new VegetableDTO(42,"Tomato","Grape","Fruit",20,30);
		VegetableDTO result=ivegs.viewVegetable(42);
		System.out.println(result.getName());
		assertEquals(vegetable.getName(), result.getName());
		assertEquals(vegetable.getVegId(), result.getVegId());	
	}
	@Test
	public void testDuplicateVegetableIdShouldThrowDuplecateVegetableIdException() throws DuplicateVegetableException{
		assertThrows(DuplicateVegetableException.class, ()->{
			VegetableDTO vegetable = new VegetableDTO(42,"Tomato","Grape","Fruit",20,30);
			ivegs.createVegetable(vegetable);
		});	
	} 
	@Test
	public void testVegetableIdShouldThrowVegetableNotFoundException() throws VegetableNotFoundException{
		assertThrows(VegetableNotFoundException.class, ()->{
			ivegs.readVegId(454);
		});
	}

}
