package com.rituj.event.publisher;

import com.rituj.event.events.CustomEvent;
import com.rituj.event.models.EventMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Component
@AllArgsConstructor
public class CustomSpringEventPublisher {

  private ApplicationEventPublisher applicationEventPublisher;

  public void publishCustomEvent(final String message) {
    var eventName = message;
    var eventTime = LocalDate.now().toString();
    log.info(
        "Creating new event with event name as:{} which got created on: {}", eventName, eventTime);

    EventMessage eventMessage = new EventMessage();
    eventMessage.setEventName(eventName);
    eventMessage.setEventTimeStamp(eventTime);

    log.info("Publishing custom event message as an event: {}", eventMessage);
    applicationEventPublisher.publishEvent(new CustomEvent<EventMessage>(eventMessage));
  }
}
