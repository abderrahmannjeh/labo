package com.example.demo.service;

import java.util.List;

import com.example.demo.entites.Outil;

public interface IOutilService {
	
	public List<Outil>findAll();
	public Outil add(Outil outil);
	public Outil  findById(Long id);
	public Outil update(Outil outil);
	public void delete(Outil outil);
	
	

}
