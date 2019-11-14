package com.rgk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgk.entity.MFloor;


public interface IFloorDao extends JpaRepository<MFloor, String> {
	
	List<MFloor> findByBuildingId(String buildingId);
}
