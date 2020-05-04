package com.syne.assignment.Aggregator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syne.assignment.Aggregator.entity.ServiceProvider;
import com.syne.assignment.Aggregator.repo.AggregatorRepository;

@Service
public class AggregatorServiceImpl implements AggregatorService {
	
	@Autowired
	private AggregatorRepository aggregatorRepo;

	@Override
	public void save(ServiceProvider theaggregator) {
		
		aggregatorRepo.save(theaggregator);
		
	}

	@Override
	public ServiceProvider findByPolicyType(String policyType) {
		
		return null;
	}

	@Override
	public ServiceProvider findByInsuranceProviderName(String providerName) {
		
		return aggregatorRepo.findByInsuranceProviderName(providerName);
	}

	@Override
	public List<ServiceProvider> getAll() {
		// TODO Auto-generated method stub
		return aggregatorRepo.findAll();
	}

	/*@Override
	public Aggregator findByInsuranceCompanyName(String companyName) {
		
		return aggregatorRepo.findByInsuranceCompanyName(companyName);
	}*/

}
