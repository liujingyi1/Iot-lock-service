package com.rgk.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgk.entity.MFace;
import com.rgk.pojo.ReturnObject;
import com.rgk.repository.IFaceDao;
import com.rgk.service.IFaceService;

@Service
public class FaceServiceImpl implements IFaceService {
	
	@Autowired
	IFaceDao faceDao;

	@Override
	public ReturnObject saveFace(MFace face) {
		ReturnObject ro = new ReturnObject(0, null, "fail");
		if (face != null) {
			faceDao.save(face);
			if (StringUtils.isNotBlank(face.getId())) {
				ro = new ReturnObject(1, face, null);
			}
		}
		return ro;
	}

	@Override
	public ReturnObject deleteFace(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnObject updateFace(MFace face) {
		// TODO Auto-generated method stub
		return null;
	}

}
