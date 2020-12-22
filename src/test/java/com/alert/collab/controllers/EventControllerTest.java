package com.alert.collab.controllers;


import com.alert.collab.controller.EventController;
import com.alert.collab.dto.EventDTO;
import com.alert.collab.model.Event;
import com.alert.collab.service.EventService;
import converter.EventDTOToEvent;
import converter.EventToEventDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EventControllerTest {

    @Mock
    private EventService service;
    @Mock
    private EventDTOToEvent converterToEvent;
    @Mock
    private EventToEventDTO converterToEventDTO;
    private EventController unit;

    @BeforeEach
    void init() {
        unit = new EventController(service, converterToEvent, converterToEventDTO);
    }

//    @Test
    void findAll_ReturnsListOfEvents_WhenSuccessful() throws Exception {
        var events = Collections.singletonList(new Event());
        var expected = new ArrayList<EventDTO>();
        when(service.findAll()).thenReturn(events);
//        when(converter.eventListToEventDtoList(events)).thenReturn(expected);

        List<EventDTO> actual = unit.findAll().getBody();

        assertEquals(expected, actual,
                "Must return list of Event");
    }

    @Test
    void save_ReturnEvent_WhenSuccessful() throws ParseException {
        var eventDTO = EventDTO.builder()
                .id(1L)
                .name("FLOODING")
                .severity("LOW")
                .latitude("-21.747374")
                .longitude("-43.3650897")
                .eventDate("2020-11-01 10:20")
                .build();
        var savedEvent = new Event();
        var expected = EventDTO.builder()
                .id(1L)
                .name("FLOODING")
                .severity("LOW")
                .latitude("-21.747374")
                .longitude("-43.3650897")
                .eventDate("2020-11-01 10:20")
                .build();

        when(converterToEvent.convert(any(EventDTO.class))).thenReturn(savedEvent);
        when(service.save(any(Event.class))).thenReturn(savedEvent);
        when(converterToEventDTO.convert(any(Event.class))).thenReturn(eventDTO);

        EventDTO actual = unit.save(eventDTO).getBody();

        assertEquals(expected, actual,
                "Must return the saved Event");
    }

}
