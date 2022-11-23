package io.github.zodh.email;

import java.security.InvalidParameterException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.mail.SimpleMailMessage;

public class SimpleMail {

  public SimpleMailBuilder builder() {
    return new SimpleMailBuilder();
  }

  public SimpleMailMessage buildDefaultMessage(String from, String to, String subject, String text) {
    return builder().from(from).to(to).subject(subject).text(text).build();
  }

  public static class SimpleMailBuilder {

    private SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

    public SimpleMailBuilder from(String email) {
      checkIfIsValidStringField(email, "From");
      this.simpleMailMessage.setFrom(email);
      return this;
    }

    public SimpleMailBuilder to(String email) {
      checkIfIsValidStringField(email, "To");
      this.simpleMailMessage.setTo(email);
      return this;
    }

    public SimpleMailBuilder subject(String subject) {
      checkIfIsValidStringField(subject, "Subject");
      this.simpleMailMessage.setSubject(subject);
      return this;
    }

    public SimpleMailBuilder text(String text) {
      checkIfIsValidStringField(text, "Text");
      this.simpleMailMessage.setText(text);
      return this;
    }

    public SimpleMailMessage build() {
      return this.simpleMailMessage;
    }

    private void checkIfIsValidStringField(String value, String fieldName) {
      if (StringUtils.isBlank(value)) {
        throw new InvalidParameterException(String.format("Error trying to set '%s' for a simple mail message. It could not be empty, null or only whitespaces.", fieldName));
      }
    }

  }

}
