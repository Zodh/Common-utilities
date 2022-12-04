package io.github.zodh.email.message.validator;

import org.springframework.mail.SimpleMailMessage;

public interface MailMessageValidator {

  void validate(SimpleMailMessage simpleMailMessage);

}
