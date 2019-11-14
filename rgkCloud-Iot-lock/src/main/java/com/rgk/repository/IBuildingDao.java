package com.rgk.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rgk.entity.MBuilding;

public interface IBuildingDao extends JpaRepository<MBuilding, String>{
	
	List<MBuilding> findByVillageId(String villageId);
	
	@Query(value="SELECT" + 
			"	v.alias AS villageName," + 
			"	GROUP_CONCAT(b.id) AS id," + 
			"	GROUP_CONCAT(b.alias) AS builldingName " + 
			"FROM" + 
			"	m_building b " + 
			"LEFT JOIN m_village v ON b.village_id = v.id " + 
			"GROUP BY" + 
			"	b.village_id",
			nativeQuery=true)
	List<Object> findGroupByVillage();

}
