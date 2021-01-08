package com.example.demo.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.beans.PublicationBean;

@FeignClient(name="publication-service")
@Service
public interface PublicationProxy {
	@GetMapping(value = "/publications")
	List<PublicationBean> listeDesPublications();

	@GetMapping( value = "/publications/{id}")
	PublicationBean recupererUnePublication(@PathVariable("id") Long id);

}
