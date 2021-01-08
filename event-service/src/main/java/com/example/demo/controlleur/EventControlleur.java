package com.example.demo.controlleur;

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

import com.example.demo.entites.Event;
import com.example.demo.service.IEventService;

@RestController
@RequestMapping("/events")
public class EventControlleur {

	@Autowired
	IEventService eventService;
	
	@GetMapping()
	public List<Event> findAll() {
		// TODO Auto-generated method stub
		return eventService.findAll();
	}
	@PostMapping
	public Event add(@RequestBody Event event) {
		// TODO Auto-generated method stub
		return eventService.add(event);
	}

	@GetMapping("/{id}")
	public Event findById(@PathVariable("id")Long id) {
		// TODO Auto-generated method stub
		return eventService.findById(id);
	}

	@PutMapping
	public Event update(@RequestBody Event event) {
		// TODO Auto-generated method stub
		return eventService.update(event);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id")Long id) {
		Event event = eventService.findById(id);
			eventService.delete(event);
		
	}
}
