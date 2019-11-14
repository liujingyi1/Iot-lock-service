package com.rgk.service.impl;



import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rgk.entity.MDevice;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;
import com.rgk.repository.IDeviceDao;
import com.rgk.service.IDeviceService;

@Service
public class DeviceServiceImpl implements IDeviceService {
//	private Log log = LogFactory.getLog(this.getClass());
    @Autowired
    private IDeviceDao deviceDao;

	/**
     * 删除设备
     */
    @Override
    @Transactional
    public ReturnObject delete(String id) {
        deviceDao.deleteById(id);
        return new ReturnObject(1, null, "success");
    }

    
    /**
     * 所有设备
     */
    @Override
    public JGridPage<MDevice> list(String deviceNo, int page, int size, String property, String sord) {
    	MDevice device = new MDevice();
    	if (StringUtils.isNotBlank(deviceNo)) {
    		device.setDeviceNo(deviceNo);
		}
    	Pageable pageable = PageRequest.of(page, size, Direction.fromString(sord), property);
    	Page<MDevice> devices = deviceDao.findAll(Example.of(device), pageable);
        return new JGridPage<MDevice>(devices);
    }

	@Override
	public ReturnObject saveDevice(MDevice device) {
		ReturnObject ro = new ReturnObject(0, null, "fail");
		if (device != null) {
			deviceDao.save(device);
			if (StringUtils.isNotBlank(device.getId())) {
				ro = new ReturnObject(1, device, null);
			}
		}
		return ro;
	}

	@Override
	public ReturnObject findByVillageIdBuildingId(String villageId, String buildingId) {
		List<MDevice>  devices = deviceDao.findByVillageIdAndBuildingId(villageId, buildingId);
		return new ReturnObject(1, devices, null);
	}


	@Override
	public ReturnObject getDeviceState(String deviceId) {
		// TODO Auto-generated method stub
		return new ReturnObject(0, null, null);
	}




}
