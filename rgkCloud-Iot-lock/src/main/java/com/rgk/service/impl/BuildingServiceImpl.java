package com.rgk.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rgk.entity.MBuilding;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;
import com.rgk.repository.IBuildingDao;
import com.rgk.service.IBuildingService;

@Service
public class BuildingServiceImpl implements IBuildingService {

	@Autowired
	private IBuildingDao buildingDao;

	@Transactional
	@Override
	public ReturnObject saveBuilding(MBuilding building) {
		ReturnObject ro = new ReturnObject(0, null, "fail");
		if (building != null) {
			buildingDao.save(building);
			if (StringUtils.isNotBlank(building.getId())) {
				ro = new ReturnObject(1, building, null);
			}
		}
		return ro;
	}

	@Transactional
	@Override
	public ReturnObject delBuilding(String buildingId) {
		buildingDao.deleteById(buildingId);
		return new ReturnObject();
	}

	@Transactional
	@Override
	public ReturnObject deleteBatch(String ids) {
		String[] idArr = StringUtils.split(ids, ",");
		for (String id : idArr) {
			buildingDao.deleteById(id);
		}
		return new ReturnObject();
	}

	@Transactional(readOnly = true)
	@Override
	public ReturnObject findByVillage(String villageId) {
		return new ReturnObject(1, buildingDao.findByVillageId(villageId), null);
	}

	@Transactional(readOnly = true)
	@Override
	public ReturnObject findAll() {
		return new ReturnObject(1, buildingDao.findAll(), null);
	}

	@Transactional(readOnly = true)
	@Override
	public JGridPage<MBuilding> findByPage(int page, Integer size, String property, String sord) {
		Pageable pageable = PageRequest.of(page, size, Direction.fromString(sord), property);
		Page<MBuilding> building = buildingDao.findAll(pageable);
		return new JGridPage<MBuilding>(building);
	}

	@Override
	public ReturnObject findGroupByVillage() {
		return new ReturnObject(1, buildingDao.findGroupByVillage(), null);
	}

}
