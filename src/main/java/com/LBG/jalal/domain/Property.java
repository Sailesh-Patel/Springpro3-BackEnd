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
	private Integer bedrooms;
	private Integer bathrooms;
	private Boolean garden;
	private String uploadimages;
	private String propertystatus;
//	private Seller seller;
	private Integer price;

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

	public Integer getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(Integer bedrooms) {
		this.bedrooms = bedrooms;
	}

	public Integer getBathrooms() {
		return bathrooms;
	}

	public void setBathrooms(Integer bathrooms) {
		this.bathrooms = bathrooms;
	}

	public Boolean isGarden() {
		return garden;
	}

	public void setGarden(Boolean garden) {
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
