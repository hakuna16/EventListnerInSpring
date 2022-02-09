package com.rituj.event.events;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class CustomEvent<T> extends ApplicationEvent {

  private T message;

  public CustomEvent(T source) {
    super(source);
    this.message = source;
  }
}
