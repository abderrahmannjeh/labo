package com.example.demo.serviceImp;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Outil;
import com.example.demo.repository.OutilRepository;
import com.example.demo.service.IOutilService;

@Service
public class OutilServiceImp implements IOutilService {
	@Autowired
	OutilRepository outilRepository;

	@Override
	public List<Outil> findAll() {
		// TODO Auto-generated method stub
		return outilRepository.findAll();
	}

	@Override
	public Outil add(Outil outil) {
		// TODO Auto-generated method stub
		return outilRepository.save(outil);
	}

	@Override
	public Outil findById(Long id) {
		// TODO Auto-generated method stub
		return outilRepository.findById(id).orElseThrow(()->new EntityNotFoundException(id.toString()));
	}

	@Override
	public Outil update(Outil outil) {
		// TODO Auto-generated method stub
		return outilRepository.save(outil);
	}

	@Override
	public void delete(Outil outil) {
			outilRepository.delete(outil);
		
	}

}
