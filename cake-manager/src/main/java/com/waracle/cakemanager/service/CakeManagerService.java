package com.waracle.cakemanager.service;

import java.util.List;

import com.waracle.cakemanager.entity.CakeEntity;

public interface CakeManagerService {

	public List<CakeEntity> findAllCakes();
	
    public CakeEntity findCakeById(int cakeId);
	
	public void addOrUpdateCake(CakeEntity cakeEntity);
	
	public void deleteCakeById(int cakeId);
}
