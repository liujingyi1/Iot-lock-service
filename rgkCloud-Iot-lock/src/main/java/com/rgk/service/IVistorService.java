package com.rgk.service;

import com.rgk.entity.MVisitor;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;

public interface IVistorService {

	public ReturnObject findAll();
	
	public JGridPage<MVisitor> findByPage(int i, Integer rows, String sidx, String sord);
	
	public ReturnObject deleteBatch(String id);
	
	public ReturnObject findGroupByVillage();
	
}
