package com.rituj.event.listner;

import com.rituj.event.events.CustomEvent;
import com.rituj.event.models.EventMessage;
import com.rituj.event.services.EventProcessService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class CustomSpringEventListener {

  private EventProcessService eventProcessService;

  @Async
  @EventListener
  public void onApplicationEvent(final CustomEvent<EventMessage> eventMessage) {
    log.info("Received spring custom event - " + eventMessage.getMessage());
    eventProcessService.saveEvent(eventMessage.getMessage());
  }
}
