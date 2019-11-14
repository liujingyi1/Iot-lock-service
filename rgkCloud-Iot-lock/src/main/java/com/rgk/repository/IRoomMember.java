package com.rgk.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgk.entity.MRoomMember;

public interface IRoomMember extends JpaRepository<MRoomMember, String>{
	
	List<MRoomMember> findByRoomId(String roomId);
	
	List<MRoomMember> findByBuildingId(String buildingId);
	
	List<MRoomMember> findByVillageId(String villageId);
	
	List<MRoomMember> findByMemberId(String memberId); 
	
	List<MRoomMember> findByBuildingIdIn(Collection<String> buildingId);
	
	List<MRoomMember> findByVillageIdIn(Collection<String> villageId);
}
