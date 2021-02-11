package com.alert.collab.converter;

import com.alert.collab.dto.EventDTO;
import com.alert.collab.model.Event;
import org.mapstruct.Mapper;

@Mapper
public interface EventMapper {

    Event eventDTOToEvent(EventDTO eventDTO);
}
