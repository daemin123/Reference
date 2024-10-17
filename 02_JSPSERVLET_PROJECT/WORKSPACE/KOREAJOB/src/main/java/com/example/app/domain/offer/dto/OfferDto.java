package com.example.app.domain.offer.dto;

import com.example.app.domain.common.dto.UserDto;

public class OfferDto extends UserDto{
	
	private String offerName;
	private String offerTel;
	private String offerAddress;
	
	

	public String getOfferName() {
		return offerName;
	}



	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}



	public String getOfferTel() {
		return offerTel;
	}



	public void setOfferTel(String offerTel) {
		this.offerTel = offerTel;
	}



	public String getOfferAddress() {
		return offerAddress;
	}



	public void setOfferAddress(String offerAddress) {
		this.offerAddress = offerAddress;
	}



	@Override
	public String toString() {
		return "OfferDto [offerName=" + offerName + ", offerTel=" + offerTel + ", offerAddress=" + offerAddress + "]";
	}



	public OfferDto(String offerName, String offerTel, String offerAddress) {
		super();
		this.offerName = offerName;
		this.offerTel = offerTel;
		this.offerAddress = offerAddress;
	}



	public OfferDto() {}



	public boolean Insert(OfferDto newUser) {

		return false;
	}



	public boolean remove(OfferDto offerDao) {
	
		return false;
	}




	
	
}
