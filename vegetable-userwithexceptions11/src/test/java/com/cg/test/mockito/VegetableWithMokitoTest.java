package com.cg.test.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.management.loading.PrivateClassLoader;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.model.VegetableDTO;
import com.cg.repository.VegetableJPARepository;
import com.cg.services.IVegetableServiceImp;

@SpringBootTest
public class VegetableWithMokitoTest {
	@Autowired
	private IVegetableServiceImp vegservice;
	@MockBean
	private VegetableJPARepository vegRepo;
	@Test
	public void removeVegetableTest() {
		VegetableDTO veg = new VegetableDTO(4,"gdfg","fresh","ak",11,4);
		vegservice.removeVegetable(4);
		verify(vegRepo,times(1)).deleteById(4);
	}
	@Test
	public void saveVegetableTest() {
		VegetableDTO veg = new VegetableDTO(4,"gdfg","fresh","ak",11,4);
		when(vegRepo.save(veg)).thenReturn(veg);
		assertEquals(veg,vegservice.addVegetable(veg));
	}
	

}
