package com.rgk.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rgk.entity.MVillage;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;
import com.rgk.repository.IVillageDao;
import com.rgk.service.IVillageService;

@Service
public class VillageServiceImpl implements IVillageService {

	@Autowired
	private IVillageDao villageDao;

	@Override
	@Transactional
	public ReturnObject saveVillage(MVillage village) {
		ReturnObject ro = new ReturnObject(0, null, "fail");
		if (village != null) {
			villageDao.save(village);
			if (StringUtils.isNotBlank(village.getId())) {
				ro = new ReturnObject(1, village, "success");
			}
		}
		return ro;
	}

	@Transactional
	@Override
	public ReturnObject delVillage(String villageId) {
		villageDao.deleteById(villageId);
		return new ReturnObject();
	}
	@Transactional
	@Override
	public ReturnObject deleteBatch(String ids) {
		if (StringUtils.isNotBlank(ids)) {
			String[] idArr = StringUtils.split(ids,",");
			for (String id : idArr) {
				villageDao.deleteById(id);
			}
		}
		return new ReturnObject();
	}

	@Transactional(readOnly=true)
	@Override
	public JGridPage<MVillage> findByPage(int page, int size, String property, String sort) {
		Pageable pageable = PageRequest.of(page, size, Direction.fromString(sort), property);
		Page<MVillage> villages = villageDao.findAll(pageable);
		return new JGridPage<MVillage>(villages);
	}

	@Transactional(readOnly=true)
	@Override
	public ReturnObject findAll() {
		return new ReturnObject(1, villageDao.findAll(), null);
	}
}
