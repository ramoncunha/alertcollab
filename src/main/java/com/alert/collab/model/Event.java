package com.alert.collab.model;

import com.alert.collab.enums.EventEnum;
import com.alert.collab.enums.SeverityEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false)
    @NotNull(message = "Name can't be empty.")
    private EventEnum name;

    @Enumerated(EnumType.STRING)
    @Column(name = "severity", nullable = false)
    @NotNull(message = "Need to set severity for this event.")
    private SeverityEnum severityEnum;

    private String description;

    @NotNull(message = "Need to set latitude for this event.")
    private Double latitude;

    @NotNull(message = "Need to set longitude for this event.")
    private Double longitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EventEnum getName() {
        return name;
    }

    public void setName(EventEnum name) {
        this.name = name;
    }

    public SeverityEnum getSeverityEnum() {
        return severityEnum;
    }

    public void setSeverityEnum(SeverityEnum severityEnum) {
        this.severityEnum = severityEnum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
