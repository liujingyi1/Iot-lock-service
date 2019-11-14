package com.rgk.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rgk.bean.RoomBean;
import com.rgk.entity.MDevice;
import com.rgk.entity.MMember;
import com.rgk.entity.MRoom;
import com.rgk.entity.MRoomMember;
import com.rgk.mqtt.MqttClientUtil;
import com.rgk.mqtt.MqttPayload;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;
import com.rgk.repository.IBuildingDao;
import com.rgk.repository.IDeviceDao;
import com.rgk.repository.IMemberDao;
import com.rgk.repository.IRoomDao;
import com.rgk.repository.IRoomMember;
import com.rgk.repository.IVillageDao;
import com.rgk.service.IMemberService;

@Service
public class MemberServiceImpl implements IMemberService {
	
	@Autowired
	private IMemberDao memberDao;
	
	@Autowired
	private IDeviceDao deviceDao; 
	
	@Autowired
	private IRoomDao roomDao;
	
	@Autowired
	private IVillageDao villageDao;
	
	@Autowired
	private IBuildingDao buildingDao;
	
	@Autowired
	private IRoomMember roomMemberDao;
	
	@Value("${topics.faceAdd}")
	private String faceAdd_topic;

	@Transactional(readOnly = true)
	public ReturnObject findAllByBuilding(String buildingId) {
		
		List<MRoomMember> roomMembers = roomMemberDao.findByBuildingId(buildingId);
		
		List<String> idList = new ArrayList<String>();
		for (MRoomMember roomMember : roomMembers) {
			String id = roomMember.getMemberId();
			if (!idList.contains(id)) {
				idList.add(roomMember.getMemberId());
			}
		}
		
		List<MMember> members = memberDao.findByIdIn(idList);
		
		return new ReturnObject(1, members, null);
	}

	@Transactional
	@Override
	public ReturnObject saveMember(MMember member) {
		ReturnObject ro = new ReturnObject(0, null, "fail");
		if (member != null) {
			memberDao.save(member);
			if (StringUtils.isNotBlank(member.getId())) {
				ro = new ReturnObject(1, member, null);
			}
		}
		return ro;
	}

	@Transactional
	@Override
	public ReturnObject delMember(String memberId) {
		memberDao.deleteById(memberId);
		return new ReturnObject();
	}

	@Transactional(readOnly = true)
	@Override
	public JGridPage<MMember> findByPage(int page, Integer size, String sidx, String sord) {
		Pageable pageable = PageRequest.of(page, size, Direction.fromString(sord), sidx);
		Page<MMember> members = memberDao.findAll(pageable);
		return new JGridPage<MMember>(members);
	}

	@Transactional
	@Override
	public ReturnObject deleteBatch(String ids) {
		String[] idArr = StringUtils.split(ids, ",");
		for (String id : idArr) {
			memberDao.deleteById(id);
		}
		return new ReturnObject();
	}

	@Override
	public ReturnObject sendFacialFeatures(String id, String picUrl, String villageId, String buildingId) {
		ReturnObject roObject = new ReturnObject(0, null, "fail");
		//获取设备ID
		List<MDevice> devices = deviceDao.findByVillageIdAndBuildingId(villageId, buildingId);
		if (devices != null && devices.size() > 0) {
			//获取picUrl的人脸特征值
			String facefeature = getFacefeature(picUrl);
			String deviceId = devices.get(0).getId();
			String topic = faceAdd_topic + deviceId;
			MqttClientUtil.getInstance().publish(topic, new MqttPayload(facefeature), 1, false);
			roObject = new ReturnObject(1, null, "success");
		}
		
		return roObject;
	}

	private String getFacefeature(String picUrl) {
		// TODO Auto-generated method stub
		return "getFacefeature";
	}

	@Override
	public ReturnObject findAllRoomsByPhone(String phone) {
		ReturnObject roObject = new ReturnObject(0, null, "fail");
		
		List<MMember> members = memberDao.findByPhone(phone);
		if (members != null && members.size() > 0) {
			MMember member = members.get(0);
			
			List<MRoomMember> roomMembers = roomMemberDao.findByMemberId(member.getId());
			
			List<String> idList = new ArrayList<String>();
			for (MRoomMember mRoomMember : roomMembers) {
				idList.add(mRoomMember.getMemberId());
			}
			
			List<MRoom> rooms = roomDao.findByIdIn(idList);
			
			Set<RoomBean> roomBeans = new HashSet<RoomBean>();
			for (MRoom mRoom : rooms) {
				RoomBean roomBean = new RoomBean();
				roomBean.setName(mRoom.getAlias());
				roomBean.setVillageName(villageDao.findById(mRoom.getVillageId()).get().getAlias());
				roomBean.setBuildingname(buildingDao.findById(mRoom.getBuildingId()).get().getAlias());
				roomBean.setPhoneNumber(mRoom.getPhoneNumber());
				roomBeans.add(roomBean);
			}
			roObject = new ReturnObject(1, roomBeans, null);
		} else {
			roObject.setMessage("phone number is wrong");
		}
		
		return roObject;
	}

	@Override
	public List<String> findPhonesByVillageId(String villageId) {
		
		List<MRoomMember> roomMembers = roomMemberDao.findByVillageId(villageId);
		List<String> phones = new ArrayList<String>();
		List<String> idList = new ArrayList<String>();
		for (MRoomMember mRoomMember : roomMembers) {
			String id = mRoomMember.getMemberId();
			if (!idList.contains(id)) {
				idList.add(id);
			}
		}
		
		List<MMember> members = memberDao.findByIdIn(idList);
		for (MMember mMember : members) {
			phones.add(mMember.getPhone());
		}
		
		return phones;
	}

	@Override
	public List<String> findPhonesByBuildingId(String[] buildingId) {
		List<MRoomMember> roomMembers = roomMemberDao.findByBuildingIdIn(Arrays.asList(buildingId));
		List<String> phones = new ArrayList<String>();
		List<String> idList = new ArrayList<String>();
		for (MRoomMember mRoomMember : roomMembers) {
			String id = mRoomMember.getMemberId();
			if (!idList.contains(id)) {
				idList.add(id);
			}
		}
		
		List<MMember> members = memberDao.findByIdIn(idList);
		for (MMember mMember : members) {
			phones.add(mMember.getPhone());
		}
		
		return phones;
	}
}
