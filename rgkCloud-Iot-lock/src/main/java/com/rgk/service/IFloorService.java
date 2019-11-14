package com.rgk.service;

import com.rgk.entity.MFloor;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;

public interface IFloorService {

	public ReturnObject save(MFloor floor);
	
	public ReturnObject findAll();
	
	public ReturnObject deleteFloor(String id);
	
	public JGridPage<MFloor> findByPage(Integer page,Integer rows,String sidx, String sord);
	
	public ReturnObject findByBuilding(String buildingId);
}
