package com.tts.eventrequest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tts.eventrequest.model.Event;

public interface EventRepository extends CrudRepository<Event, Long>
{
    @Override
    List<Event> findAll();
}
