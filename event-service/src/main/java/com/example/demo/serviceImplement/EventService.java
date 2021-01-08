package com.example.demo.serviceImplement;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Event;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.IEventService;
@Service
public class EventService implements IEventService {
	@Autowired
	EventRepository eventRepository;

	@Override
	public List<Event> findAll() {
		// TODO Auto-generated method stub
		return eventRepository.findAll();
	}

	@Override
	public Event add(Event Event) {
		// TODO Auto-generated method stub
		return eventRepository.save(Event);
	}

	@Override
	public Event findById(Long id) {
		// TODO Auto-generated method stub
		return eventRepository.findById(id).orElseThrow(()->new EntityNotFoundException(id.toString()));
	}

	@Override
	public Event update(Event Event) {
		// TODO Auto-generated method stub
		return eventRepository.save(Event);
	}

	@Override
	public void delete(Event Event) {
			eventRepository.delete(Event);
		
	}

}
