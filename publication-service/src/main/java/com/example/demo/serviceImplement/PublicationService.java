package com.example.demo.serviceImplement;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Publication;
import com.example.demo.reporitory.PublicationRepository;
import com.example.demo.service.IPublicationService;

@Service
public class PublicationService implements IPublicationService {

	@Autowired
	PublicationRepository publicationRepository;

	@Override
	public List<Publication> findAll() {
		// TODO Auto-generated method stub
		return publicationRepository.findAll();
	}

	@Override
	public Publication add(Publication publication) {
		// TODO Auto-generated method stub
		return publicationRepository.save(publication);
	}

	@Override
	public Publication findById(Long id) {
		// TODO Auto-generated method stub
		return publicationRepository.findById(id).orElseThrow(()->new EntityNotFoundException(id.toString()));
	}

	@Override
	public Publication update(Publication publication) {
		// TODO Auto-generated method stub
		return publicationRepository.save(publication);
	}

	@Override
	public void delete(Publication publication) {
			publicationRepository.delete(publication);
		
	}

}
