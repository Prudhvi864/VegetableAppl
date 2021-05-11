package com.cg.test.vegetable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.exceptions.DuplecateVegetableException;
import com.cg.exceptions.VegetableNotFoundException;
import com.cg.model.VegetableDTO;
import com.cg.services.IVegetableService;

@SpringBootTest
public class VegetableDTOTest {
	@Autowired
	private IVegetableService ivegs;
	@Test
	void testFindVegetableByIdShouldReturnVegObject() throws DuplecateVegetableException,VegetableNotFoundException{
		VegetableDTO vegetable = new VegetableDTO(3,"fdtf","fresh","ak",11,25);
		ivegs.addVegetable(vegetable);
		VegetableDTO result=ivegs.viewVegetable(3);
		System.out.println(result.getName());
		assertEquals(vegetable.getName(), result.getName());
		assertEquals(vegetable.getVegId(), result.getVegId());	
	}
	@Test
	void testDuplecateVegetableIdShouldThrowDuplecateVegetableIdException() throws VegetableNotFoundException{
		assertThrows(DuplecateVegetableException.class, ()->{
			VegetableDTO vegetable = new VegetableDTO(4,"gdfg","fresh","ak",11,4);
			ivegs.addVegetable(vegetable);
		});	
	}
//	@Test
//	void testDuplecateVegetableIdShouldThrowVegetableNotFoundException() {
//		assertThrows(VegetableNotFoundException.class, ()->{
//			ivegs.findByVegId(3);
//		});
//	}

}
