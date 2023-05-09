package com.eneskaraoglu.ek.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.eneskaraoglu.ek.entity.Depo;
import com.eneskaraoglu.ek.entity.Envanter;
import com.eneskaraoglu.ek.entity.Katalog;
import com.eneskaraoglu.ek.lib.M1DataRestProxy;

@RestController
@RequestMapping("/env")
public class MicroServiceController {
	
	@Autowired
	private M1DataRestProxy proxy;
	
	public MicroServiceController(M1DataRestProxy theProxy) {
		theProxy = proxy;
	};

	//Burada restTemplate kullanıldı
	@GetMapping("/depoRT/{id}")
	public Depo getDepoRT(@PathVariable int id) {
		HashMap<String, String> uriVariable = new HashMap<>();
		uriVariable.put("id", String.valueOf(id));
		String resourceUrl = "http://localhost:8080/data-rest/depoes/{id}";
		ResponseEntity<Depo> response = new RestTemplate().getForEntity(resourceUrl + "",  Depo.class , uriVariable);
		return response.getBody();
	}
	
	@GetMapping("/depoRT")
	public List<Depo> getDepoRT() {
		System.out.println("---------1------------------");
		String resourceUrl = "http://localhost:8080/data-rest/depoes";
		List<Depo> response = (List<Depo>) restTemplate().getForEntity(resourceUrl + "",  List.class );
		System.out.println("------------3---------------"+response);
		return response;
	}
	

	@Bean
	public RestTemplate restTemplate() {
	   final RestTemplate restTemplate = new RestTemplate();

	   List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
	   MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	   converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
	   messageConverters.add(converter);
	   restTemplate.setMessageConverters(messageConverters);

	   return restTemplate;
	}
	
	//Burada resttemplete yerine proxy kullanıldı
	//bunun için
	//Micro2ServiceDAO da @EnableFeignClients 
	//pom.xlm <artifactId>spring-cloud-starter-openfeign</artifactId>
	//M1DataRestProxy @FeignClient(name="spring-boot-env-microservis-1-data-rest", url="localhost:8080")
	@GetMapping("/depo/{id}")
	public Depo getDepo(@PathVariable int id) {
		Depo response = proxy.getDepo(id);
		return response;
	}
	
	@GetMapping("/depo")
	public List<Depo> getDepo() {
		System.out.println("proxy.getDepo:"+proxy.getDepo());
		List<Depo> response = proxy.getDepo();
		return response;
	}
	
	@PostMapping("/depo")
	public Depo addDepo(@RequestBody Depo theEntity) {
		Depo response = proxy.addDepo(theEntity);
		return response;
	}

	@DeleteMapping("/depo/{id}")
	public String deleteDepo(@PathVariable int id) {
		String response = proxy.deleteDepo(id);
		return response;
	}
	
	@PutMapping("/depo")
	public Depo updateDepo(@RequestBody Depo theEntity) {
		Depo response = proxy.updateDepo(theEntity);
		return response;
	}
	
	//////
	
	@GetMapping("/katalog/{id}")
	public Katalog getKatalog(@PathVariable int id) {
		Katalog response = proxy.getKatalog(id);
		return response;
	}
	
	@GetMapping("/katalog")
	public List<Katalog> getKatalog() {
		System.out.println("proxy.getDepo:"+proxy.getDepo());
		List<Katalog> response = proxy.getKatalog();
		return response;
	}
	
	@PostMapping("/katalog")
	public Katalog addKatalog(@RequestBody Depo theEntity) {
		Katalog response = proxy.addKatalog(theEntity);
		return response;
	}

	@DeleteMapping("/katalog/{id}")
	public String deleteKatalog(@PathVariable int id) {
		String response = proxy.deleteKatalog(id);
		return response;
	}
	
	@PutMapping("/katalog")
	public Katalog updateKatalog(@RequestBody Depo theEntity) {
		Katalog response = proxy.updateKatalog(theEntity);
		return response;
	}
}
