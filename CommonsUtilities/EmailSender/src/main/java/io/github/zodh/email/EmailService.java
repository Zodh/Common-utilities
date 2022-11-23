package io.github.zodh.email;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

  void send(SimpleMailMessage simpleMailMessage);

  void sendSimpleMail(String from, String to, String subject, String text);

}
