package com.rgk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgk.entity.MPassword;

public interface IPasswordDao extends JpaRepository<MPassword, String>{

	
	List<MPassword> findByPassowrdAndIsOTPAndType(String password, Boolean isOTP, Integer type);
	
	List<MPassword> findByPassowrd(String passowrd);
	
}
