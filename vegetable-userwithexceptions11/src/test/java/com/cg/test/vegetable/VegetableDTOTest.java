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
	public void testFindVegetableByIdShouldReturnVegObject() throws DuplecateVegetableException,VegetableNotFoundException{
		VegetableDTO vegetable = new VegetableDTO(1,"gdfg","fresh","ak",11,5);
		VegetableDTO result=ivegs.viewVegetable(1);
		System.out.println(result.getName());
		assertEquals(vegetable.getName(), result.getName());
		assertEquals(vegetable.getVegId(), result.getVegId());	
	}
	@Test
	public void testDuplecateVegetableIdShouldThrowDuplecateVegetableIdException() throws VegetableNotFoundException{
		assertThrows(DuplecateVegetableException.class, ()->{
			VegetableDTO vegetable = new VegetableDTO(4,"gdfg","fresh","ak",11,4);
			ivegs.createVegetable(vegetable);
		});	
	}
//	@Test
//	public void testDuplecateVegetableIdShouldThrowVegetableNotFoundException() {
//		assertThrows(VegetableNotFoundException.class, ()->{
//			ivegs.readVegId(400);
//		});
//	}

}
