package com.rituj.event.controllers;

import com.rituj.event.models.EventMessage;
import com.rituj.event.services.EventProcessService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/event")
@AllArgsConstructor
public class EventStatusController {

  private EventProcessService eventProcessService;

  @GetMapping("/{id}")
  public EventMessage getEventBasedOnId(@PathVariable(name = "id") final String id) throws Exception {
    var eventMessage = eventProcessService.getEventMessageById(id);
    return eventMessage;

  }
}
