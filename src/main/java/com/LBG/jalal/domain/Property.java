package com.LBG.jalal.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String address;
	private String typeofproperty;
	private int bedrooms;
	private int bathrooms;
	private boolean garden;
	private String uploadimages;
	private String propertystatus;
//	private Seller seller;
	private long price;

//	jason file has offersinregionof instead of price
	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTypeofproperty() {
		return typeofproperty;
	}

	public void setTypeofproperty(String typeofproperty) {
		this.typeofproperty = typeofproperty;
	}

	public int getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}

	public int getBathrooms() {
		return bathrooms;
	}

	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}

	public boolean isGarden() {
		return garden;
	}

	public void setGarden(boolean garden) {
		this.garden = garden;
	}

	public String getUploadimages() {
		return uploadimages;
	}

	public void setUploadimages(String uploadimages) {
		this.uploadimages = uploadimages;
	}

	public String getPropertystatus() {
		return propertystatus;
	}

	public void setPropertystatus(String propertystatus) {
		this.propertystatus = propertystatus;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

}
