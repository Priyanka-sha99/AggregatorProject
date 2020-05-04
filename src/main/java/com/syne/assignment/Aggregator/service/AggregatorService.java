package com.syne.assignment.Aggregator.service;

import java.util.List;

import com.syne.assignment.Aggregator.entity.ServiceProvider;


public interface AggregatorService {

	void save(ServiceProvider theaggregator);

	ServiceProvider findByPolicyType(String policyType);

	ServiceProvider findByInsuranceProviderName(String providerName);

	List<ServiceProvider> getAll();

	//Aggregator findByInsuranceCompanyName(String companyName);

}
