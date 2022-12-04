package io.github.zodh.email;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

  void send(SimpleMailMessage simpleMailMessage);

}
