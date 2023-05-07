package com.eneskaraoglu.ek.rest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.eneskaraoglu.ek.entity.Depo;
import com.eneskaraoglu.ek.lib.M1DataRestProxy;

@RestController
@RequestMapping("/env")
public class MicroServiceController {
	
	
	/*
	@GetMapping("/depo/{id}")
	public Depo getDepo(@PathVariable int id) {
		

		HashMap<String, String> uriVariable = new HashMap<>();
		uriVariable.put("id", String.valueOf(id));
		
		ResponseEntity<Depo> response = null;
		RestTemplate restTemplate = new RestTemplate();
		
		String resourceUrl = "http://localhost:8080/data-rest/depoes/{id}";
		response = restTemplate.getForEntity(resourceUrl + "",  Depo.class , uriVariable);

		return response.getBody();
	}*/
	
	@Autowired
	private M1DataRestProxy proxy;
	
	public MicroServiceController(M1DataRestProxy theProxy) {
		theProxy = proxy;
	};
	
	//Burada resttemplete yerine proxy kullandım.
	//bunun için
	//Micro2ServiceDAO da @EnableFeignClients 
	//pom.xlm <artifactId>spring-cloud-starter-openfeign</artifactId>
	//M1DataRestProxy @FeignClient(name="spring-boot-env-microservis-1-data-rest", url="localhost:8080")
	@GetMapping("/depo/{id}")
	public Depo getDepo(@PathVariable int id) {
		
		HashMap<String, String> uriVariable = new HashMap<>();
		uriVariable.put("id", String.valueOf(id));
		Depo response = null;
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = "http://localhost:8080/data-rest/depoes/{id}";
		response = proxy.getDepo(id);

		return response;
	}	
	
	@GetMapping("/depo")
	public List<Depo> getDepo() {
		System.out.println("---------1------------------");
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("----------2-----------------");
		String resourceUrl = "http://localhost:8080/data-rest/depoes";
		ResponseEntity<Depo[]> response = restTemplate.exchange(resourceUrl + "", HttpMethod.GET, null , Depo[].class );
		System.out.println("------------3---------------");
		System.out.println(response.getBody());
		return Arrays.asList(response.getBody());
	}
	
}
