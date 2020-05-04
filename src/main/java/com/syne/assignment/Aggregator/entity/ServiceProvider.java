package com.syne.assignment.Aggregator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ServiceProvider {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String insuranceProviderName;
	
	@Column
	private String providerUrl;
	
	@Column
	private String responseType;
	
	@Column
	private String responseFormat;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	
	public String getInsuranceProviderName() {
		return insuranceProviderName;
	}

	public void setInsuranceProviderName(String insuranceProviderName) {
		this.insuranceProviderName = insuranceProviderName;
	}

	public String getProviderUrl() {
		return providerUrl;
	}

	public void setProviderUrl(String providerUrl) {
		this.providerUrl = providerUrl;
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public String getResponseFormat() {
		return responseFormat;
	}

	public void setResponseFormat(String responseFormat) {
		this.responseFormat = responseFormat;
	}

	public ServiceProvider()
	{
		
	}

	public ServiceProvider(String insuranceProviderName, String providerUrl, String responseType,
			String responseFormat) {
		super();
		this.insuranceProviderName = insuranceProviderName;
		this.providerUrl = providerUrl;
		this.responseType = responseType;
		this.responseFormat = responseFormat;
	}
	
	
	
	
	
	

}
