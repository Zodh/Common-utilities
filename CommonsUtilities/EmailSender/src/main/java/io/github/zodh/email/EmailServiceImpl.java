package io.github.zodh.email;

import io.github.zodh.evaluation.ObjectEvaluator;
import java.lang.reflect.MalformedParametersException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

  private JavaMailSender javaMailSender;

  @Autowired
  public EmailServiceImpl(JavaMailSender javaMailSender) {
    this.javaMailSender = javaMailSender;
  }

  @Override
  public void send(SimpleMailMessage simpleMailMessage) {
    checkSimpleMailEssentialFields(simpleMailMessage);
    javaMailSender.send(simpleMailMessage);
  }

  @Override
  public void sendSimpleMail(String from, String to, String subject, String text) {
    var simpleMessage = new SimpleMail().buildDefaultMessage(
        from, to, subject, text
    );
    this.send(simpleMessage);
  }

  private void checkSimpleMailEssentialFields(SimpleMailMessage simpleMailMessage) {
    if (Boolean.TRUE.equals(ObjectEvaluator.isNull(simpleMailMessage))) {
      throw new NullPointerException("The object 'Simple Mail Message' can not to be null!");
    }
    if (Boolean.TRUE.equals(ObjectEvaluator.isBlankSafeEval(simpleMailMessage::getFrom))) {
      throw new MalformedParametersException("The field 'From' can not to be null in a Simple Mail Message!");
    }
    if (Boolean.TRUE.equals(ObjectEvaluator.isBlankSafeEval(() -> simpleMailMessage.getTo()[0]))) {
      throw new MalformedParametersException("The field 'To' can not to be null in a Simple Mail Message!");
    }
    if (Boolean.TRUE.equals(ObjectEvaluator.isBlankSafeEval(simpleMailMessage::getSubject))) {
      throw new MalformedParametersException("The field 'Subject' can not to be null in a Simple Mail Message!");
    }
    if (Boolean.TRUE.equals(ObjectEvaluator.isBlankSafeEval(simpleMailMessage::getText))) {
      throw new MalformedParametersException("The field 'Text' can not to be null in a Simple Mail Message!");
    }
  }

}
