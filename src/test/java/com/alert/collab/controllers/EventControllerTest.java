package com.alert.collab.controllers;

import com.alert.collab.enums.EventEnum;
import com.alert.collab.model.Event;
import com.alert.collab.service.EventService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class EventControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EventService eventService;

    private static final String EVENT_API_URL = "/api/event/";
    private static final Long ID = Long.valueOf(1);
    private static final String NAME = EventEnum.FLOODING.name();

    @Test
    public void findAll_ReturnsListOfEvents_WhenSuccessful() throws Exception {
        Event event = new Event();
        event.setId(ID);
        event.setName(EventEnum.FLOODING);

        BDDMockito.given(this.eventService.findAll())
            .willReturn(List.of(event));

        mvc.perform(MockMvcRequestBuilders.get(EVENT_API_URL)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isNotEmpty());
    }

}
