package com.waracle.cakemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.waracle.cakemanager.entity.CakeEntity;
import com.waracle.cakemanager.service.CakeManagerService;

@RestController
public class CakeManagerController {
	
	@Autowired
	private CakeManagerService cakeManagerService;
	
	@GetMapping("/cakes")
	public List<CakeEntity> getAllCakes() {
		return cakeManagerService.findAllCakes();
	}
	
	@GetMapping("/cakes/{cakeId}")
	public CakeEntity getCakeById(@PathVariable int cakeId) {
		CakeEntity cake = cakeManagerService.findCakeById(cakeId);
		if (cake == null) {
			throw new RuntimeException("Cake not found for id- " + cakeId);
		}
		
		return cake;
	}
	
	@PostMapping("/cakes")
	public CakeEntity addCake(@RequestBody CakeEntity cakeEntity) {
		cakeManagerService.addOrUpdateCake(cakeEntity);
		return cakeEntity;
	}
	
	@DeleteMapping("/cakes/{cakeId}")
	public void deleteCakeById(@PathVariable int cakeId) {
		CakeEntity cake = cakeManagerService.findCakeById(cakeId);
		if (cake == null) {
			throw new RuntimeException("Cake not found for id- " + cakeId);
		}
		cakeManagerService.deleteCakeById(cakeId);
	}
	
	@PutMapping("/cakes")
	public CakeEntity updateEmployee(@RequestBody CakeEntity cakeEntity) {
		
		cakeManagerService.addOrUpdateCake(cakeEntity);
		return cakeEntity;
	}

}
