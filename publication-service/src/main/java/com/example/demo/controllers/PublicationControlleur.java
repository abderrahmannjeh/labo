package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.Publication;
import com.example.demo.service.IPublicationService;

@RestController
@RequestMapping("/publications")
public class PublicationControlleur {
	
	@Autowired
	IPublicationService publicationService;
	
	@GetMapping()
	public List<Publication> findAll() {
		// TODO Auto-generated method stub
		return publicationService.findAll();
	}
	@PostMapping
	public Publication add(@RequestBody Publication publication) {
		// TODO Auto-generated method stub
		return publicationService.add(publication);
	}

	@GetMapping("/{id}")
	public Publication findById(@PathVariable("id")Long id) {
		// TODO Auto-generated method stub
		return publicationService.findById(id);
	}

	@PutMapping
	public Publication update(@RequestBody Publication publication) {
		// TODO Auto-generated method stub
		return publicationService.update(publication);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id")Long id) {
		Publication publication = publicationService.findById(id);
			publicationService.delete(publication);
		
	}

}
