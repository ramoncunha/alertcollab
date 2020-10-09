package com.alert.collab.util;

import com.alert.collab.dto.EventDTO;
import com.alert.collab.enums.EventEnum;
import com.alert.collab.enums.SeverityEnum;
import com.alert.collab.model.Event;

import java.util.List;
import java.util.stream.Collectors;

public abstract class EventConverter {

    public static Event converterForRequest(EventDTO eventDto) {
        Event event = new Event();
        event.setId(eventDto.getId());
        event.setName(EventEnum.valueOf(eventDto.getName()));
        event.setSeverity(SeverityEnum.valueOf(eventDto.getSeverity()));
        event.setDescription(eventDto.getDescription());
        event.setLatitude(Double.valueOf(eventDto.getLatitude()));
        event.setLongitude(Double.valueOf(eventDto.getLongitude()));
        return event;
    }

    public static EventDTO converterForResponse(Event event) {
        EventDTO eventDto = new EventDTO();
        eventDto.setId(event.getId());
        eventDto.setName(event.getName().name());
        eventDto.setSeverity(event.getSeverity().name());
        eventDto.setDescription(event.getDescription());
        eventDto.setLatitude(event.getLatitude().toString());
        eventDto.setLongitude(event.getLongitude().toString());
        return eventDto;
    }

    public static List<EventDTO> eventListToEventDtoList(List<Event> events) {
        return events.stream().map(EventConverter::converterForResponse).collect(Collectors.toList());
    }

}
