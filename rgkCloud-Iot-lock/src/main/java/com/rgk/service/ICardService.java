package com.rgk.service;

import com.rgk.entity.MCard;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;

public interface ICardService {
	
	public ReturnObject saveCard(MCard card);
	
	public ReturnObject delCard(String cardId);
	
	public ReturnObject deleteBatch(String ids);
	
	public ReturnObject updateCard(MCard card);
	
	public JGridPage<MCard> findByPage(Integer page,Integer rows,String sidx, String sord);
	
	public ReturnObject sendCardInfo(String id, String filterType);
}
