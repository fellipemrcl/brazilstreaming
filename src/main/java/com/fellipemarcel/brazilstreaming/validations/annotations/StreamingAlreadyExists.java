package com.fellipemarcel.brazilstreaming.validations.annotations;

import com.fellipemarcel.brazilstreaming.validations.StreamingAlreadyExistsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The interface Streaming already exists.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StreamingAlreadyExistsValidator.class)
public @interface StreamingAlreadyExists {

  /**
   * Message string.
   *
   * @return the string
   */
  String message() default "Streaming already exists";

  /**
   * Groups class [ ].
   *
   * @return the class [ ]
   */
  Class<?>[] groups() default {};

  /**
   * Payload class [ ].
   *
   * @return the class [ ]
   */
  Class<? extends Payload>[] payload() default {};
}
