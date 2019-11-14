package com.rgk.repository;


import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgk.entity.MMember;

public interface IMemberDao extends JpaRepository<MMember, String>{
	
	public List<MMember> findByPhone(String phone);
	
	public List<MMember> findByIdIn(Collection<String> id);
}
