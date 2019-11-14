package com.rgk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgk.entity.MFace;

public interface IFaceDao extends JpaRepository<MFace, String> {

	
	
}
