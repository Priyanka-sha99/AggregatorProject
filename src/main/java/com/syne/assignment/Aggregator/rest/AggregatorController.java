package com.syne.assignment.Aggregator.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.syne.assignment.Aggregator.entity.ServiceProvider;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.syne.assignment.Aggregator.entity.AggregatorPlan;
import com.syne.assignment.Aggregator.service.AggregatorService;

import ch.qos.logback.core.helpers.Transform;



@RestController
@CrossOrigin(origins="*")
@RequestMapping("/aggregator")
public class AggregatorController {
	
	@Autowired
	private AggregatorService aggregatorService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AggregatorPlan aggregatorPlan;

	@PostMapping
	public String register(@RequestBody ServiceProvider theServiceProvider)
	{
		
		theServiceProvider.setId(0);
		
		aggregatorService.save(theServiceProvider);
		
		return "Insurance Company registered successfully";
	}
	
	
	
	
	
	@GetMapping("/{planType}/{ageGroup}")
	public List<AggregatorPlan> getAllPlans( @PathVariable String planType, @PathVariable String ageGroup)
	{
		
		String url;
		
		//List<AggregatorPlan> listOfresponse = new ArrayList<>();
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("planType", planType);
		uriVariables.put("ageGroup", ageGroup);
		
		 HttpHeaders headers = new HttpHeaders();
		 headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		 HttpEntity<String> entity = new HttpEntity<String>(headers);
		//list of aggregatorPlan
		 List<AggregatorPlan> jsonObject= new ArrayList<>();
		//List<?>
		 
		 
		for(ServiceProvider list : aggregatorService.getAll())
		{
			url = list.getProviderUrl();
			
			ResponseEntity<Object[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity ,Object[].class, uriVariables);
			
			List<Object> result = new ArrayList<>(Arrays.asList(responseEntity.getBody()));
			
			if(result.size() != 0)
			{
				//List<AggregatorPlan> = transform(result)
				jsonObject.addAll(Transform(result, list));
				//jsonObject.addAll(result);
			}
			
		}
		
		//Class<AggregatorPlan> listOfresponse =jsonObject;
		
		return jsonObject;
			
	}




	//transform method
	private List<AggregatorPlan> Transform(List<Object> result, ServiceProvider list) {
		
		ObjectMapper mapper = new ObjectMapper();
		String responseType = null;
		List<AggregatorPlan> responseList = new ArrayList<>();
		
		
		try {
			for(Object obj : result)
			{
			//String responseType = list.getResponseFormat();
			responseType = mapper.writeValueAsString(obj);
			
			System.out.println("---" +responseType);
			
			aggregatorPlan =  mapper.readValue(responseType, AggregatorPlan.class);
				
			//System.out.println("policyName" +aggregatorPlan.getPolicyName());
				
				
				
				//aggregatorPlan.setCompanyName((String) result.get(0));
				//aggregatorPlan.setPolicyName((String) result.get(1));
				//JsonNode jsonNode = aggregatorPlan.setCompanyName(responseType.contains(s));
				
			
			//aggregatorPlan = mapper.readValue(json, AggregatorPlan.class);
			//aggregatorPlan = new Gson().fromJson(json, AggregatorPlan.class);
			//aggregatorPlan.set
				
				responseList.add(aggregatorPlan);
				
			}		
			
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		
		
		return responseList;
	}
	
	
	
	
	

}	
	
	
	
	
	
























/*try {
	for(int i=0; i< result.size(); i++)
	{
		if(result.size() != 0)
		{
		System.out.println("middle for loop "+result.get(i));
		 jsonObject = (List<Object>) result.get(i);
		
		System.out.println("end: " +jsonObject);
		}	
		
			
	}
	} catch (JSONException e) {
		
		e.printStackTrace();
	}*/
	

/*AggregatorPlan plan = null;
for(int i=0; i<result.size();i++)
{
	 plan = (AggregatorPlan) result.get(i);
}
return plan;*/


// return restTemplate.getForEntity(url, String.class, uriVariables);
	
	
	
	
//restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		//ResponseEntity<Object[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null ,Object[].class, uriVariables);
	    //List<Object> result = Arrays.asList(responseEntity.getBody());
	   // return result;
	
	
	//return (List<Policy>) restTemplate.getForObject(url, Policy.class, uriVariables);
	
	 /*Map<String, String> uriVariables = new HashMap<>();
	uriVariables.put("policyType", policyType);
	uriVariables.put("age", age);

    ResponseEntity<Aggregator[]> responseEntity =  restTemplate.getForEntity("http://localhost:8080/api/healthInsurances/{policyType}/{age}", Aggregator[].class, uriVariables);
    List<Aggregator> result = Arrays.asList(responseEntity.getBody());
    return result;*/

