package com.rgk.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.rgk.entity.MFloor;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;
import com.rgk.repository.IFloorDao;
import com.rgk.service.IFloorService;

@Service
public class FloorServiceImpl implements IFloorService {

	@Autowired
	IFloorDao floorDao;
	
	@Override
	public ReturnObject save(MFloor floor) {
		floorDao.save(floor);
		
		ReturnObject returnObject;
		if (StringUtils.isNotBlank(floor.getId())) {
			returnObject = new ReturnObject();
			returnObject.setResult(floor);
		} else {
			returnObject = new ReturnObject(0, null, "failer");
		}
		return returnObject;
	}

	@Override
	public ReturnObject findAll() {
		return new ReturnObject(1, floorDao.findAll(), null);
	}

	@Override
	public ReturnObject deleteFloor(String id) {
		floorDao.deleteById(id);
		return new ReturnObject();
	}

	@Override
	public JGridPage<MFloor> findByPage(Integer page, Integer rows, String sidx, String sord) {
		Pageable pageable = PageRequest.of(page, rows, Direction.fromString(sord), sidx);
		Page<MFloor> floor = floorDao.findAll(pageable);
		return new JGridPage<MFloor>(floor);
	}

	@Override
	public ReturnObject findByBuilding(String buildingId) {
		return new ReturnObject(1, floorDao.findByBuildingId(buildingId), null);
	}

	
}
