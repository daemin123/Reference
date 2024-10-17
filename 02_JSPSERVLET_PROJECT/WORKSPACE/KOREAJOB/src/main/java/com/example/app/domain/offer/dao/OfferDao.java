package com.example.app.domain.offer.dao;

import java.util.List;

import com.example.app.domain.offer.dto.OfferDto;

public interface OfferDao {


	boolean Insert(OfferDto dto) throws Exception;

	OfferDto Select(String offername) throws Exception;

	List<OfferDto> SelectAll() throws Exception;

	boolean Remove(String Id) throws Exception;

	boolean Update(String Id) throws Exception;
	
	
	
}
