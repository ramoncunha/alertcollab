package com.alert.collab.converter;

import com.alert.collab.dto.EventDTO;
import com.alert.collab.model.Event;
import org.springframework.stereotype.Component;

@Component
public class EventToEventDTO implements Converter<Event, EventDTO> {

    @Override
    public EventDTO convert(Event event) {
        return EventDTO.builder()
                .id(event.getId())
                .name(event.getName().name())
                .severity(event.getSeverity().name())
                .description(event.getDescription())
                .latitude(event.getLatitude().toString())
                .longitude(event.getLongitude().toString())
                .eventDate(event.getEventDate().toString())
                .build();
    }
}
