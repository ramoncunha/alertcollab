package com.alert.collab.controller;

import com.alert.collab.dto.EventDTO;
import com.alert.collab.model.Event;
import com.alert.collab.service.EventService;
import com.alert.collab.converter.EventDTOToEvent;
import com.alert.collab.converter.EventToEventDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/event")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;
    private final EventDTOToEvent converterToEvent;
    private final EventToEventDTO converterToEventDTO;

    @GetMapping
    public ResponseEntity<List<EventDTO>> findAll() {
        List<Event> events = this.eventService.findAll();
        List<EventDTO> response = events.stream().map(converterToEventDTO::convert).collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<EventDTO> save(@RequestBody @Valid EventDTO eventDto) {
        Event event = converterToEvent.convert(eventDto);
        Event savedEvent = this.eventService.save(event);
        EventDTO response = converterToEventDTO.convert(savedEvent);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Event> delete(@PathVariable Long id) {
        this.eventService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
