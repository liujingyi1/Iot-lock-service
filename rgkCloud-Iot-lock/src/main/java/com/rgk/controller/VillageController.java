package com.rgk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rgk.entity.MVillage;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;
import com.rgk.service.IVillageService;

@RestController
@RequestMapping("/village")
public class VillageController {
	
	@Autowired
	private IVillageService villageService;
	/**
	 * 	编辑
	 * @param village
	 * @return
	 */
	@RequestMapping("/save")
	public ReturnObject saveVillage(@RequestBody MVillage village) {
		return villageService.saveVillage(village);
	}
	
	/**
	 * 	删除指定
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public ReturnObject delVillage(String id) {
		
		System.out.println("delete id="+id);
		
		return villageService.delVillage(id);
	}
	
	/**
	 *	批量删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteBatch")
	public ReturnObject deleteBatch(@RequestParam String id) {
		return villageService.deleteBatch(id);
	}
	
	/**
	 *	分页查询
	 * @param page
	 * @param rows
	 * @param sidx
	 * @param sord
	 * @return
	 */
	@RequestMapping("/list")
	public JGridPage<MVillage> findByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "rows", defaultValue = "20") Integer rows, 
			@RequestParam(value = "sidx", required = false, defaultValue = "createdDate") String sidx ,
			@RequestParam(value = "sord", defaultValue = "DESC") String sord) {
		return villageService.findByPage(page-1, rows, sidx, sord);
	}
	
	/**
	 * 	查询全部
	 * @return
	 */
	@RequestMapping("/all")
	public ReturnObject findAll() {
		return villageService.findAll();
	}
	
	/**
	 * 	查询全部
	 * @return
	 */
	@RequestMapping("/select")
	public String villagetSelect() {
		
//		ReturnObject returnObject = villageService.findAll();
//		returnObject.getResult();
		
		return "<select><option>1</option></select>";
	}

}
