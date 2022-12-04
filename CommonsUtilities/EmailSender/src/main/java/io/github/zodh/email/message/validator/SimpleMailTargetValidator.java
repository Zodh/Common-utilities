package io.github.zodh.email.message.validator;

import io.github.zodh.evaluation.ObjectEvaluator;
import java.lang.reflect.MalformedParametersException;
import java.util.Objects;
import org.springframework.mail.SimpleMailMessage;

public class SimpleMailTargetValidator implements MailMessageValidator {

  @Override
  public void validate(SimpleMailMessage simpleMailMessage) {
    if (Boolean.TRUE.equals(ObjectEvaluator.isBlankSafeEval(() -> Objects.requireNonNull(
        simpleMailMessage.getTo())[0]))) {
      throw new MalformedParametersException(
          "The field 'To' can not to be null in a Simple Mail Message!");
    }
  }
}
