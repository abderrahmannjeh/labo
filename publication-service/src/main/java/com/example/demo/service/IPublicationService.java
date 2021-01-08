package com.example.demo.service;

import java.util.List;

import com.example.demo.entites.Publication;

public interface IPublicationService {
	
	public List<Publication>findAll();
	public Publication add(Publication publication);
	public Publication  findById(Long id);
	public Publication update(Publication publication);
	public void delete(Publication publication);

}
