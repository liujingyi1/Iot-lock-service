package com.rgk.service;

import com.rgk.pojo.ReturnObject;

public interface ISupplierService {

	ReturnObject add();

	ReturnObject delete(String id);

	ReturnObject modify();

}
