package com.rgk.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.rgk.bean.People;
import com.rgk.entity.MFace;
import com.rgk.entity.MMember;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;
import com.rgk.service.IFaceEngineService;
import com.rgk.service.IFaceService;
import com.rgk.service.IMemberService;
import com.rgk.service.IRoomService;
import com.rgk.utils.FileHandleUtil;
import com.rgk.utils.IdcardUtil;

@RestController
@RequestMapping("/member")
public class MemberController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private IMemberService memberService;
	
	@Autowired
	private IFaceService faceService;
	
	@Autowired
	private IFaceEngineService faceEngineService;

	@RequestMapping("/save")
	public ReturnObject saveMember(@RequestBody MMember member) {
		ReturnObject res = new ReturnObject();
		
//		if (StringUtils.isBlank(member.getId())) {
//			JSONObject jsonObject = faceEngineService.createPeople(member.getName());
//			if (jsonObject.getString("status").equals("ok")) {
//				String personUuid = jsonObject.getJSONObject("data").getJSONObject("person").getString("person_uuid");
//				member.setFaceMemberId(personUuid);
//				
//				if (!StringUtils.isBlank(member.getPicUrl())) {
//					try {
//						byte[] imageBytes;
//						imageBytes = Files.readAllBytes(Paths.get(member.getPicUrl()));
//						People people = faceEngineService.addImage(personUuid, imageBytes);
//						if (people.getStatus().equals("ok")) {
//							MFace face = new MFace();
//							face.setFaceUUID(people.getData().getPerson().getImages().get(0).getFaces().get(0).getFace_uuid());
//							face.setFaceContent(people.getData().getPerson().getImages().get(0).getFaces().get(0).getFace_feature());
//							faceService.saveFace(face);
//						}
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		}
		
		res = memberService.saveMember(member);
		return res;
	}

	@RequestMapping("/del")
	public ReturnObject delMember(@RequestParam String id) {
		return memberService.delMember(id);
	}
	
	@RequestMapping("/deleteBatch")
	public ReturnObject deleteBatch(@RequestParam String id) {
		return memberService.deleteBatch(id);
	}
	
	@RequestMapping("/findByBuilding")
	public ReturnObject findByBuilding(@RequestParam String buildingId) {
		return memberService.findAllByBuilding(buildingId);
	}
	
	@RequestMapping("/idcardIsValidate")
	public boolean idcardIsValidate(@RequestParam String ID) {
		return IdcardUtil.validateCard(ID);
	}
	
	/**
	 * 成员列表
	 * @param page
	 * @param rows
	 * @param sidx
	 * @param sord
	 * @return
	 */
	@RequestMapping("/list")
	public JGridPage<MMember> membersList(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "rows", defaultValue = "20") Integer rows,
			@RequestParam(value = "sidx", required = false, defaultValue = "createdDate") String sidx,
			@RequestParam(value = "sord", defaultValue = "DESC") String sord) {
		return memberService.findByPage(page - 1, rows, sidx, sord);
	}
	
	/**
	 * 上传人脸特征图片
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/uploadFace")
	public ReturnObject uploadFaceImg(@RequestParam("file") MultipartFile file) throws IOException {
		log.info(file.getOriginalFilename());
		String fileURL = FileHandleUtil.upload(file.getInputStream(), "image/", file.getOriginalFilename());
		return new ReturnObject(1, fileURL, "success");
	}
	
	/**
	 * 下发人脸特征值
	 * @param id
	 * @return
	 */
	@RequestMapping("/facialFeatures")
	public ReturnObject facialFeatures(@RequestParam String id, @RequestParam String picUrl, @RequestParam String villageId, @RequestParam String buildingId) {
		return memberService.sendFacialFeatures(id, picUrl, villageId, buildingId);
	}
	
	@RequestMapping("/findPhonesByVillage")
	public List<String> findMembersByVillageId(@RequestParam String villageId) {
		 return memberService.findPhonesByVillageId(villageId);
		 
	}
	
	@RequestMapping("/findPhonesByBuilding")
	public List<String> findMemebersByBuildingId(@RequestParam(value="buildingId[]") String[] buildingId) {
		return memberService.findPhonesByBuildingId(buildingId);
	}

}
