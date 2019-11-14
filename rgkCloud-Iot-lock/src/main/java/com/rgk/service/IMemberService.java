package com.rgk.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rgk.entity.MMember;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;

public interface IMemberService {
	/**
	 * 添加/修改人员信息
	 * @param member
	 * @return
	 */
	public ReturnObject saveMember(MMember member);
	/**
	 * 删除指定人员信息
	 * @param memberId
	 * @return
	 */
	public ReturnObject delMember(String memberId);
	
	/**
	 * 获取指定楼栋中的人员
	 * @param buildingId
	 * @return 
	 */
	public ReturnObject findAllByBuilding(String buildingId);
	
	public JGridPage<MMember> findByPage(int pageNo, Integer rows, String sidx, String sord);
	
	public ReturnObject deleteBatch(String id);
	/**
	 * 下发人脸特征值
	 * @param id
	 * @param picUrl
	 * @return
	 */
	public ReturnObject sendFacialFeatures(String id, String picUrl, String villageId, String buildingId);
	
	public ReturnObject findAllRoomsByPhone(String phone);
	
	public List<String> findPhonesByVillageId(String villageId);
	
	public List<String> findPhonesByBuildingId(@RequestParam(value="buildingId[]") String[] buildingId);
}
