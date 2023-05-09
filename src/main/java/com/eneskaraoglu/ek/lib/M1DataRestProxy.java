package com.eneskaraoglu.ek.lib;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.eneskaraoglu.ek.entity.Depo;
import com.eneskaraoglu.ek.entity.Katalog;

@FeignClient(name="spring-boot-env-microservis-1-data-rest", url="localhost:8080")
public interface M1DataRestProxy {

	@GetMapping("data-rest/depoes/{id}")
	public Depo getDepo(@PathVariable int id);
	
	@GetMapping("data-rest/depoes")
	public List<Depo> getDepo();
	
	@PostMapping("data-rest/depoes")
	public Depo addDepo(@RequestBody Depo theEntity);
	
	@DeleteMapping("data-rest/depoes/{id}")
	public String deleteDepo(@PathVariable int id);
	
	@PutMapping("data-rest/depoes")
	public Depo updateDepo(@RequestBody Depo theEntity);
	


	@GetMapping("data-rest/katalogs/{id}")
	public Katalog getKatalog(@PathVariable int id);
	
	@GetMapping("data-rest/katalogs")
	public List<Katalog> getKatalog();
	
	@PostMapping("data-rest/katalogs")
	public Katalog addKatalog(@RequestBody Depo theEntity);
	
	@DeleteMapping("data-rest/katalogs/{id}")
	public String deleteKatalog(@PathVariable int id);
	
	@PutMapping("data-rest/katalogs")
	public Katalog updateKatalog(@RequestBody Depo theEntity);
}
