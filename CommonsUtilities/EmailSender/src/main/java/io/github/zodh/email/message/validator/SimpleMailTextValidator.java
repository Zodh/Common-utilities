package io.github.zodh.email.message.validator;

import io.github.zodh.evaluation.ObjectEvaluator;
import java.lang.reflect.MalformedParametersException;
import org.springframework.mail.SimpleMailMessage;

public class SimpleMailTextValidator implements MailMessageValidator {

  @Override
  public void validate(SimpleMailMessage simpleMailMessage) {
    if (Boolean.TRUE.equals(ObjectEvaluator.isBlankSafeEval(simpleMailMessage::getText))) {
      throw new MalformedParametersException(
          "The field 'Text' can not to be null in a Simple Mail Message!");
    }
  }
}
