package com.waracle.cakemanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waracle.cakemanager.dao.CakeRepository;
import com.waracle.cakemanager.entity.CakeEntity;

@Service
public class CakeManagerServiceImpl implements CakeManagerService {
	
	private CakeRepository cakeRepository;
	
	@Autowired
	public CakeManagerServiceImpl(CakeRepository cakeRepository) {
		this.cakeRepository = cakeRepository;
	}

	@Override
	public List<CakeEntity> findAllCakes() {
		return cakeRepository.findAll();
	}

	@Override
	public CakeEntity findCakeById(int cakeId) {
		
		Optional<CakeEntity> cakeEntities = cakeRepository.findById(cakeId);
		CakeEntity cake = null;
		
		if(cakeEntities.isPresent())
			cake = cakeEntities.get();
		else
			throw new RuntimeException("CakeEntity not found for the id" + cakeId);
		
		return cake;
	}

	@Override
	public void addOrUpdateCake(CakeEntity cakeEntity) {
		cakeRepository.save(cakeEntity);
		
	}

	@Override
	public void deleteCakeById(int cakeId) {
		cakeRepository.deleteById(cakeId);
		
	}

}
