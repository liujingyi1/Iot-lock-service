package com.rgk.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.rgk.domain.PositionView;
import com.rgk.entity.MRoom;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;
import com.rgk.repository.IRoomDao;
import com.rgk.service.IRoomService;

@Service
public class RoomServiceImpl implements IRoomService {
	
	@Autowired
	IRoomDao roomDao;
	
	@Override
	public ReturnObject save(MRoom room) {
		roomDao.save(room);
		
		ReturnObject returnObject;
		if (StringUtils.isNotBlank(room.getId())) {
			returnObject = new ReturnObject();
			returnObject.setResult(room);
		} else {
			returnObject = new ReturnObject(0, null, "failer");
		}
		return returnObject;
	}

	@Override
	public ReturnObject findAll() {
		return new ReturnObject(1, roomDao.findAll(), null);
	}

	@Override
	public ReturnObject deleteRoom(String id) {
		roomDao.deleteById(id);
		return new ReturnObject();
	}

	@Override
	public JGridPage<MRoom> findByPage(Integer page, Integer rows, String sidx, String sord) {
		Pageable pageable = PageRequest.of(page, rows, Direction.fromString(sord), sidx);
		Page<MRoom> room = roomDao.findAll(pageable);
		return new JGridPage<MRoom>(room);
	}

	@Override
	public ReturnObject findById(String id) {
		return new ReturnObject(1, roomDao.findById(id), null);
	}

	@Override
	public ReturnObject findByFloorId(String floorId) {
		return new ReturnObject(1, roomDao.findByFloorId(floorId), null);
	}

	@Override
	public ReturnObject findViewById(String id) {
		PositionView positionView = roomDao.findPositionViewById(id);
		
		return new ReturnObject(1, positionView, null);
	}
	
	

//	@Override
//	public List<String> findMembersByVillageId(String villageId) {
//		List<MRoom> rooms = roomDao.findByVillageId(villageId);
//		List<String> phones = new ArrayList<String>();
//		for (MRoom mRoom : rooms) {
//			Set<MMember> members = mRoom.getMembers();
//			for (MMember mMember : members) {
//				phones.add(mMember.getPhone());
//			}
//		}
//		
//		return phones;
//	}
//
//	@Override
//	public List<String> findMembersByBuildingId(String[] buildingId) {
//		List<MRoom> rooms = roomDao.findByBuildingIdIn(Arrays.asList(buildingId));
//		List<String> phones = new ArrayList<String>();
//		for (MRoom mRoom : rooms) {
//			Set<MMember> members = mRoom.getMembers();
//			for (MMember mMember : members) {
//				phones.add(mMember.getPhone());
//			}
//		}
//		return phones;
//	}
}
