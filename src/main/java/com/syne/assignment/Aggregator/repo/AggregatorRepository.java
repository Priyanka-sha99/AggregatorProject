package com.syne.assignment.Aggregator.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syne.assignment.Aggregator.entity.ServiceProvider;

public interface AggregatorRepository extends JpaRepository<ServiceProvider, Integer> {

	ServiceProvider findByInsuranceProviderName(String providerName);

	

	//Aggregator findByInsuranceCompanyName(String companyName);

}
