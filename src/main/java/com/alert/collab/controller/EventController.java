package com.alert.collab.controller;

import com.alert.collab.dto.EventDTO;
import com.alert.collab.model.Event;
import com.alert.collab.service.EventService;
import com.alert.collab.util.EventConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/event")
public class EventController {

    private final EventService eventService;
    private final EventConverter converter;

    @GetMapping
    public ResponseEntity<List<EventDTO>> findAll() {
        List<Event> events = this.eventService.findAll();
        List<EventDTO> response = converter.eventListToEventDtoList(events);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<EventDTO> save(@RequestBody @Valid EventDTO eventDto) throws ParseException {
        Event event = converter.converterForRequest(eventDto);
        Event savedEvent = this.eventService.save(event);
        EventDTO response = converter.converterForResponse(savedEvent);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Event> delete(@PathVariable Long id) {
        this.eventService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
