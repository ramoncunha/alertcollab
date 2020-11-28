package com.alert.collab.controllers;


import com.alert.collab.controller.EventController;
import com.alert.collab.dto.EventDTO;
import com.alert.collab.model.Event;
import com.alert.collab.service.EventService;
import com.alert.collab.util.EventConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EventControllerTest {

    @Mock
    private EventService service;
    @Mock
    private EventConverter converter;
    private EventController unit;

    @BeforeEach
    void init() {
        unit = new EventController(service, converter);
    }

    @Test
    void findAll_ReturnsListOfEvents_WhenSuccessful() throws Exception {
        var events = Collections.singletonList(new Event());
        var expected = new ArrayList<EventDTO>();
        when(service.findAll()).thenReturn(events);
        when(converter.eventListToEventDtoList(events)).thenReturn(expected);

        List<EventDTO> actual = unit.findAll().getBody();

        assertEquals(actual, expected,
                "Must return list of Event");
    }

}
