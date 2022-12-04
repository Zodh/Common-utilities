package io.github.zodh.email.message.validator;

import org.springframework.mail.SimpleMailMessage;

/**
 * Classes that implement this interface must do some sort of validation on an email message.
 * The reason for this is that there may be different reasons for validating any element of an email.
 *
 * @see SimpleMailSourceValidator
 * @see SimpleMailSubjectValidator
 * @see SimpleMailTargetValidator
 * @see SimpleMailTextValidator
 *
 * The classes that implement the email sender choose which validators to consider.
 * In this way, it is possible to develop any type of validator and call it where necessary.
 *
 * @version 1.0.0.0
 * @author Felipe Santos
 */
public interface MailMessageValidator {

  void validate(SimpleMailMessage simpleMailMessage);

}
