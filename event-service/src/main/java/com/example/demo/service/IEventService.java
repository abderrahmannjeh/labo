package com.example.demo.service;

import java.util.List;

import com.example.demo.entites.Event;

public interface IEventService {

	public List<Event>findAll();
	public Event add(Event Event);
	public Event  findById(Long id);
	public Event update(Event Event);
	public void delete(Event Event);
}
