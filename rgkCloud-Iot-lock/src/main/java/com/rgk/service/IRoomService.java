package com.rgk.service;

import com.rgk.entity.MRoom;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;

public interface IRoomService {
	public ReturnObject save(MRoom room);

	public ReturnObject findAll();
	
	public ReturnObject deleteRoom(String id);
	
	public JGridPage<MRoom> findByPage(Integer page,Integer rows,String sidx, String sord);
	
	public ReturnObject findById(String id);
	
	public ReturnObject findByFloorId(String floor);
	
	public ReturnObject findViewById(String id);
	
//	public List<String> findMembersByVillageId(String villageId);
//	
//	public List<String> findMembersByBuildingId(String[] buildingId);
}
