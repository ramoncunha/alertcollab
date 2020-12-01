package com.alert.collab.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
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
}
