package com.rituj.event.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "event_message")
public class EventMessage {

  @Id
  @Column(name = "event_id")
  private Integer eventId;

  @Column(name = "event_name")
  private String eventName;

  @Column(name = "event_time")
  private String eventTimeStamp;
}
