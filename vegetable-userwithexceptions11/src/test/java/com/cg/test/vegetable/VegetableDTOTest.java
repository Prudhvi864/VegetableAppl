package com.cg.test.vegetable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.exceptions.DuplicateVegetableException;
import com.cg.exceptions.VegetableNotFoundException;
import com.cg.model.VegetableDTO;
import com.cg.services.IVegetableService;

@SpringBootTest
public class VegetableDTOTest {
	@Autowired
	private IVegetableService ivegs;
	@Test
	public void testFindVegetableByIdShouldReturnVegObject() throws DuplicateVegetableException,VegetableNotFoundException{
		VegetableDTO vegetable = new VegetableDTO(1,"gdfg","fresh","ak",11,5);
		VegetableDTO result=ivegs.viewVegetable(1);
		System.out.println(result.getName());
		assertEquals(vegetable.getName(), result.getName());
		assertEquals(vegetable.getVegId(), result.getVegId());	
	}
	@Test
	public void testDuplicateVegetableIdShouldThrowDuplecateVegetableIdException() throws DuplicateVegetableException{
		assertThrows(DuplicateVegetableException.class, ()->{
			VegetableDTO vegetable = new VegetableDTO(4,"gdfg","fresh","ak",11,4);
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
