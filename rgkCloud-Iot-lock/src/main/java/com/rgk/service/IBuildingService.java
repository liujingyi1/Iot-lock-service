package com.rgk.service;

import com.rgk.entity.MBuilding;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;

public interface IBuildingService {
	/**
	 * 添加/修改楼栋信息
	 * @param building
	 * @return
	 */
	public ReturnObject saveBuilding(MBuilding building);
	/**
	 * 删除楼栋信息
	 * @param buildingId
	 * @return
	 */
	public ReturnObject delBuilding(String buildingId);
	/**
	 * 查找指定园区楼栋信息
	 * @param villageId
	 * @return
	 */
	public ReturnObject findByVillage(String villageId);
	
	public ReturnObject findAll();
	
	public JGridPage<MBuilding> findByPage(int i, Integer rows, String sidx, String sord);
	
	public ReturnObject deleteBatch(String id);
	
	public ReturnObject findGroupByVillage();
	

}
