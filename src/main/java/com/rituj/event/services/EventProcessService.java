package com.rituj.event.services;

import com.rituj.event.models.EventMessage;
import com.rituj.event.publisher.CustomSpringEventPublisher;
import com.rituj.event.repository.EventProcessRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.util.Random;

@Slf4j
@Service
@AllArgsConstructor
public class EventProcessService {

  private EventProcessRepository eventProcessRepository;

  private CustomSpringEventPublisher customSpringEventPublisher;

  public EventMessage getEventMessageById(final String id) {

    var eventMessage = eventProcessRepository.findById(Integer.parseInt(id));

    if (eventMessage.isEmpty()) {
      log.warn("Data not present");
      customSpringEventPublisher.publishCustomEvent("Test new Event");
      return null;
    }
    return eventMessage.get();
  }

  public EventMessage saveEvent(final EventMessage eventMessage) {

    EventMessage newEventMessage = new EventMessage();
    newEventMessage.setEventId(
        ObjectUtils.isEmpty(eventMessage.getEventId())
            ? new Random().nextInt(2, 100)
            : eventMessage.getEventId());
    newEventMessage.setEventName(eventMessage.getEventName());
    newEventMessage.setEventTimeStamp(LocalDate.now().toString());
    return eventProcessRepository.save(newEventMessage);
  }
}
