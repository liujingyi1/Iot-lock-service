package com.rgk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgk.entity.MCard;

public interface ICardDao extends JpaRepository<MCard, String>{

}
