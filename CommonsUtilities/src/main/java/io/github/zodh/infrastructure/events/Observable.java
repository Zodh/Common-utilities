package io.github.zodh.infrastructure.events;

import io.github.zodh.infrastructure.io.input.FileReader;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.ApplicationEvent;

public abstract class Observable extends ApplicationEvent {

  private String observableSubjectsMapPath = "C:\\Users\\Felipe\\Desktop\\Projetos\\Pessoal\\barbershop\\barbershop-manager\\src\\main\\resources\\observable_subjects_map.csv";
  
  protected final String subjectName;

  protected final FileReader reader;

  protected String cause;

  protected Observable(Object context, String subjectName, FileReader fileReader) {
    super(context);
    this.subjectName = subjectName;
    this.reader = fileReader;
  }

  public Boolean isRegistered() {
    Map<String, String> recordsMap = (HashMap<String, String>)  reader.getContent(getRecordsMap());
    return recordsMap.get(subjectName) != null && recordsMap.get(subjectName).equals(Boolean.TRUE.toString());
  }

  private File getRecordsMap() {
    return new File(observableSubjectsMapPath);
  }
  
}
