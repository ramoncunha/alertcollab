package com.alert.collab.model;

import com.alert.collab.enums.EventEnum;
import com.alert.collab.enums.SeverityEnum;

import javax.persistence.*;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventEnum name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeverityEnum severity;

    private String description;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
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
        return severity;
    }

    public void setSeverityEnum(SeverityEnum severityEnum) {
        this.severity = severityEnum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SeverityEnum getSeverity() {
        return severity;
    }

    public void setSeverity(SeverityEnum severity) {
        this.severity = severity;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
