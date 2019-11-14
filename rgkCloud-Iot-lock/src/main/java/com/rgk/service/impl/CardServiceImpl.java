package com.rgk.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.rgk.entity.MCard;
import com.rgk.entity.MDevice;
import com.rgk.mqtt.service.IMqttService;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;
import com.rgk.repository.ICardDao;
import com.rgk.repository.IDeviceDao;
import com.rgk.service.ICardService;

@Service
public class CardServiceImpl implements ICardService {
	
	@Autowired
	ICardDao cardDao;
	
	@Autowired
	IDeviceDao deviceDao;
	
	@Autowired
	IMqttService mqttService;
	
	@Override
	public ReturnObject saveCard(MCard card) {
		cardDao.save(card);
		//sendCardInfo(card.getId(), "0");
		return new ReturnObject();
	}

	@Override
	public ReturnObject delCard(String cardId) {
		cardDao.deleteById(cardId);
		//sendCardInfo(cardId, "1");
		return new ReturnObject();
	}
	
	@Override
	public ReturnObject updateCard(MCard card) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JGridPage<MCard> findByPage(Integer page, Integer rows, String sidx, String sord) {
		Pageable pageable = PageRequest.of(page, rows, Direction.fromString(sord), sidx);
		Page<MCard> card = cardDao.findAll(pageable);
		return new JGridPage<MCard>(card);
	}

	@Override
	public ReturnObject deleteBatch(String ids) {
		String[] idArr = StringUtils.split(ids, ",");
		for (String id : idArr) {
			cardDao.deleteById(id);
		}
		return new ReturnObject();
	}

	@Override
	public ReturnObject sendCardInfo(String id, String filterType) {
		
		ReturnObject roObject = new ReturnObject(0, null, "fail");
		MCard card = cardDao.findById(id).get();
		List<MDevice> devices = deviceDao.findByVillageIdAndBuildingId(card.getBuildingId(), card.getBuildingId());
		if (devices != null && devices.size() > 0) {
			String deviceId = devices.get(0).getId();
			if (mqttService.dispatchCardInfo(deviceId, card, (long)0, filterType)) {
				return new ReturnObject(1, null, null);
			}
		}
		
		return roObject;
	}
}
