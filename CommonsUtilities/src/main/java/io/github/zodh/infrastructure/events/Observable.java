package io.github.zodh.infrastructure.events;

import io.github.zodh.infrastructure.io.input.FileReader;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.ApplicationEvent;

public abstract class Observable extends ApplicationEvent {

  protected String observableSubjectsMapPath;
  
  protected final String subjectName;

  protected final FileReader fileReader;

  protected String eventReason;

  protected Observable(Object context, String subjectName, FileReader fileReader, String observableSubjectsMapPath) {
    super(context);
    this.subjectName = subjectName;
    this.fileReader = fileReader;
    this.observableSubjectsMapPath = observableSubjectsMapPath;
    if (Boolean.TRUE.equals(isNotRegistered())) {
      throw new RuntimeException(String.format("You are not able to work with %s subject! It must be registered in Observable Subjects!", subjectName));
    }
  }

  public Boolean isRegistered() {
    Map<String, String> recordsMap = (HashMap<String, String>)  fileReader.getContent(getRecordsMap());
    return recordsMap.get(subjectName) != null && recordsMap.get(subjectName).equals(Boolean.TRUE.toString());
  }

  public Boolean isNotRegistered() {
    return !isRegistered();
  }

  public String getEventReason() {
    return eventReason;
  }

  public void setEventReason(String eventReason) {
    this.eventReason = eventReason;
  }

  private File getRecordsMap() {
    return new File(observableSubjectsMapPath);
  }
  
}
