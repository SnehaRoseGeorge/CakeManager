package com.waracle.cakemanager.controller;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.List;

import com.waracle.cakemanager.entity.CakeEntity;
import com.waracle.cakemanager.service.CakeManagerService;

@SpringBootTest
public class CakeManagerControllerTest {
	
	@InjectMocks
	CakeManagerController cakeManagerController;
	
	@Mock
	private CakeManagerService cakeManagerService;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllCakesTest() {
		CakeEntity cake = new CakeEntity(1,"white forest", "white");
		when(cakeManagerService.findAllCakes()).thenReturn(List.of(cake));
		cakeManagerController.getAllCakes();
		assertEquals(cakeManagerController.getAllCakes().size(), 1);
	}
	
	@Test
	public void addCakeTest() {
		CakeEntity cake = new CakeEntity(1,"black forest", "black");
		CakeEntity returnedCake = cakeManagerController.addCake(cake);
		assertEquals(returnedCake, cake);
		verify(cakeManagerService).addOrUpdateCake(cake);
	}
	
	@Test
	public void deleteCakeByIdTest() {
		CakeEntity cake = new CakeEntity(1,"black forest", "black");
		int cakeId=1;
		when(cakeManagerService.findCakeById(cakeId)).thenReturn(cake);
		cakeManagerController.deleteCakeById(cakeId);
		verify(cakeManagerService).deleteCakeById(cakeId);
	}
	
	@Test
	public void deleteCakeByIdWithexceptionTest() {
		int cakeId=1;
		when(cakeManagerService.findCakeById(cakeId)).thenReturn(null);
		Exception exception = assertThrows(RuntimeException.class, () -> {
			cakeManagerController.deleteCakeById(cakeId);
	    });
		assertTrue(exception.getMessage().contains("Cake not found for id-"));
		verify(cakeManagerService, never()).deleteCakeById(cakeId);
	}

}
