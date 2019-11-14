package com.rgk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgk.entity.MDevice;

public interface IDeviceDao extends JpaRepository<MDevice, String> {

	MDevice findByDeviceNo(String deviceNo);

	List<MDevice> findByVillageIdAndBuildingId(String villageId, String buildingId);

}
