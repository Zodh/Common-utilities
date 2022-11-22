package io.github.zodh.infrastructure.events;

import org.springframework.context.ApplicationEvent;

public abstract class Observable extends ApplicationEvent {
  
  protected final String subjectName;

  protected String eventReason;

  protected Observable(Object context, String subjectName) {
    super(context);
    this.subjectName = subjectName;
  }

  public String getEventReason() {
    return eventReason;
  }

  public void setEventReason(String eventReason) {
    this.eventReason = eventReason;
  }
  
}
