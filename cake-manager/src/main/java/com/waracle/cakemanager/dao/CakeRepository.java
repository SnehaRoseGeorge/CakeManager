package com.waracle.cakemanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.waracle.cakemanager.entity.CakeEntity;

public interface CakeRepository extends JpaRepository<CakeEntity, Integer>{

}
