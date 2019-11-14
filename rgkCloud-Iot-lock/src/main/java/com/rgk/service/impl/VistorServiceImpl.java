package com.rgk.service.impl;

import org.springframework.stereotype.Service;

import com.rgk.entity.MVisitor;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;
import com.rgk.service.IVistorService;

@Service
public class VistorServiceImpl implements IVistorService {

	@Override
	public ReturnObject findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JGridPage<MVisitor> findByPage(int i, Integer rows, String sidx, String sord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnObject deleteBatch(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnObject findGroupByVillage() {
		// TODO Auto-generated method stub
		return null;
	}

}
