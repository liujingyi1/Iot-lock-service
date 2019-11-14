package com.rgk.service;

import com.rgk.entity.MVillage;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;

public interface IVillageService {
	/**
	 * 增加/修改园区信息
	 * @param village
	 * @return
	 */
	public ReturnObject saveVillage(MVillage village);
	/**
	 * 删除
	 * @param villageId
	 * @return
	 */
	public ReturnObject delVillage(String villageId);
	/**
	 * 所有园区
	 * @param page
	 * @param size
	 * @param property
	 * @param sort
	 * @return
	 */
	public JGridPage<MVillage> findByPage(int page, int size, String property, String sort);
	
	public ReturnObject findAll();
	
	public ReturnObject deleteBatch(String id);

}
