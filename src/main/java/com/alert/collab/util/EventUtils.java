package com.alert.collab.util;

import com.alert.collab.exception.ResourceNotFoundException;
import com.alert.collab.model.Event;
import com.alert.collab.repository.EventRepository;
import org.springframework.stereotype.Component;

@Component
public class EventUtils {

    public Event findEventOrThrowNotFound(Long id, EventRepository eventRepository) {
        return eventRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

}
