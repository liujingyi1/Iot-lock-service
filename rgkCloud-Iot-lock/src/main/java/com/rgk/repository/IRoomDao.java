package com.rgk.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rgk.domain.PositionView;
import com.rgk.entity.MRoom;

public interface IRoomDao extends JpaRepository<MRoom, String>{
	
	List<MRoom> findByBuildingId(String buildingId);
	
	List<MRoom> findByVillageId(String villageId);
	
	List<MRoom> findByFloorId(String floorId);
	
	List<MRoom> findByIdIn(Collection<String> id);
	
	List<MRoom> findByBuildingIdIn(Collection<String> buildingId);
	
//	MVillage village;
//	MBuilding building;
//	MFloor floor;
//	MRoom room;
//	
    @Query(value = "SELECT new com.rgk.domain.PositionView(v,b,f,r) FROM MRoom r,MFloor f,MBuilding b,MVillage v WHERE r.id = :id AND r.floorId = f.id AND r.buildingId = b.id AND r.villageId = v.id")
    public PositionView findPositionViewById(String id);
}
