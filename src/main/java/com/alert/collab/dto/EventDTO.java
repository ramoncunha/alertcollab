package com.alert.collab.dto;

import javax.validation.constraints.NotNull;

public class EventDTO {

    private Long id;

    @NotNull(message = "{event.name.error}")
    private String name;

    @NotNull(message = "{event.severiy.error}")
    private String severity;

    private String description;

    @NotNull(message = "{event.latitude.error}")
    private String latitude;

    @NotNull(message = "{event.longitude.error}")
    private String longitude;

    @NotNull(message = "{event.date.error}")
    private String eventDate;

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

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }
}
