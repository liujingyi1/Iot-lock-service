package com.rgk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgk.entity.MVisitor;

public interface IVistorDao extends JpaRepository<MVisitor, String>{
	
	List<MVisitor> findByBuildNo(String buildNo);

}
