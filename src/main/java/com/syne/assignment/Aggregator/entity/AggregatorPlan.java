package com.syne.assignment.Aggregator.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AggregatorPlan implements Serializable {
	
	@JsonProperty()
	@JsonAlias({"companyName", "planName"})
	private String companyName;
	
	
	@JsonProperty()
	@JsonAlias({"cover", "coverAmount"})
	private String cover;
	
	
	@JsonProperty()
	@JsonAlias({"premiumYearly", "premiumAmount"})
	private String premiumYearly;
	
	public AggregatorPlan()
	{
		
	}

	public AggregatorPlan(String companyName, String policyName, String cover, String premiumMonthly,
			String premiumYearly) {
		super();
		this.companyName = companyName;
		
		this.cover = cover;
		
		this.premiumYearly = premiumYearly;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	

	public String getPremiumYearly() {
		return premiumYearly;
	}

	public void setPremiumYearly(String premiumYearly) {
		this.premiumYearly = premiumYearly;
	}
	
	


	
	
	

}
