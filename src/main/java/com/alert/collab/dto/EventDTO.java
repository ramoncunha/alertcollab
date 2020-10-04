package com.alert.collab.dto;

import com.alert.collab.enums.EventEnum;
import com.alert.collab.enums.SeverityEnum;
import com.alert.collab.model.Event;

import javax.validation.constraints.NotNull;

public class EventDTO {

    private Long id;

    @NotNull(message = "Name can't be empty.")
    private String name;

    @NotNull(message = "Need to set severity for this event.")
    private String severity;

    private String description;

    @NotNull(message = "Need to set latitude for this event.")
    private String latitude;

    @NotNull(message = "Need to set longitude for this event.")
    private String longitude;

    public Event converter(EventDTO eventDto) {
        Event event = new Event();
        event.setId(eventDto.getId());
        event.setName(EventEnum.valueOf(eventDto.getName()));
        event.setSeverity(SeverityEnum.valueOf(eventDto.getSeverity()));
        event.setDescription(eventDto.getDescription());
        event.setLatitude(Double.valueOf(eventDto.getLatitude()));
        event.setLongitude(Double.valueOf(eventDto.getLongitude()));
        return event;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
