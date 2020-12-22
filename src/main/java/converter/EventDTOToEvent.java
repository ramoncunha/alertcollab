package converter;

import com.alert.collab.dto.EventDTO;
import com.alert.collab.enums.EventEnum;
import com.alert.collab.enums.SeverityEnum;
import com.alert.collab.model.Event;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class EventDTOToEvent implements Converter<EventDTO, Event> {

    @Override
    public Event convert(EventDTO eventDTO) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Event event = new Event();

        try {
            event.setId(eventDTO.getId());
            event.setName(EventEnum.valueOf(eventDTO.getName()));
            event.setSeverity(SeverityEnum.valueOf(eventDTO.getSeverity()));
            event.setDescription(eventDTO.getDescription());
            event.setLatitude(Double.valueOf(eventDTO.getLatitude()));
            event.setLongitude(Double.valueOf(eventDTO.getLongitude()));
            event.setEventDate(dateFormat.parse(eventDTO.getEventDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return event;
    }
}
