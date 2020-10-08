package com.alert.collab.services;

import com.alert.collab.model.Event;
import com.alert.collab.repository.EventRepository;
import com.alert.collab.service.EventService;
import com.alert.collab.util.EventUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class EventServiceTest {

    @MockBean
    private EventRepository eventRepositoryMock;

    @MockBean
    private EventUtils eventUtilsMock;

    @Autowired
    private EventService eventService;

    @BeforeEach
    public void setUp() {
        List<Event> eventList = List.of(new Event());
        BDDMockito.given(this.eventRepositoryMock.findAll())
            .willReturn(eventList);

        BDDMockito.given(this.eventRepositoryMock.save(Mockito.any(Event.class)))
            .willReturn(new Event());

        BDDMockito.given(this.eventRepositoryMock.findById(Mockito.anyLong()))
            .willReturn(Optional.of(new Event()));

        BDDMockito.given(this.eventUtilsMock.findEventOrThrowNotFound(Mockito.anyLong(), Mockito.any(EventRepository.class)))
            .willReturn(new Event());
    }

    @Test
    public void findAll_ReturnsListOfEvents_WhenSuccessful() {
        List<Event> eventList = this.eventService.findAll();

        Assertions.assertNotNull(eventList);
    }

    @Test
    public void saveEvent_ReturnSavedEvent_WhenSuccessful() {
        Event event = this.eventService.save(new Event());

        Assertions.assertNotNull(event);
    }

    @Test
    public void findById_ReturnEvent_WhenSuccessful() {
        Event event = this.eventService.findById(1l);

        Assertions.assertNotNull(event);
    }


}
