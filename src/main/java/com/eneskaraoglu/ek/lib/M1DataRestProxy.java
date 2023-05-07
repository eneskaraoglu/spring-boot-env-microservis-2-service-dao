package com.eneskaraoglu.ek.lib;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.eneskaraoglu.ek.entity.Depo;

@NoRepositoryBean
@FeignClient(name="spring-boot-env-microservis-1-data-rest", url="localhost:8080")
public interface M1DataRestProxy {

	@GetMapping("/depo/{id}")
	public Depo getDepo(@PathVariable int id);
	
}
