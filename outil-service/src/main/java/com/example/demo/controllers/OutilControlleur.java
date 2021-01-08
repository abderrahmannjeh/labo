package com.example.demo.controllers;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.Outil;
import com.example.demo.service.IOutilService;

@RestController
@RequestMapping("/outils")
public class OutilControlleur {
	
	@Autowired
	IOutilService outilService;
	
	@GetMapping()
	public List<Outil> findAll() {
		// TODO Auto-generated method stub
		return outilService.findAll();
	}
	@PostMapping
	public Outil add(@RequestBody Outil outil) {
		// TODO Auto-generated method stub
		return outilService.add(outil);
	}

	@GetMapping("/{id}")
	public Outil findById(@PathVariable("id")Long id) {
		// TODO Auto-generated method stub
		return outilService.findById(id);
	}

	@PutMapping
	public Outil update(@RequestBody Outil outil) {
		// TODO Auto-generated method stub
		return outilService.update(outil);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id")Long id) {
		Outil outil = outilService.findById(id);
			outilService.delete(outil);
		
	}


}
