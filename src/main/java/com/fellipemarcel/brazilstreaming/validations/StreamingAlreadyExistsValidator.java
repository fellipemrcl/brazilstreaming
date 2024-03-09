package com.fellipemarcel.brazilstreaming.validations;

import com.fellipemarcel.brazilstreaming.config.SpringContext;
import com.fellipemarcel.brazilstreaming.models.entities.Streaming;
import com.fellipemarcel.brazilstreaming.models.repositories.StreamingRepository;
import com.fellipemarcel.brazilstreaming.validations.annotations.StreamingAlreadyExists;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The type Streaming already exists validator.
 */
public class StreamingAlreadyExistsValidator implements
    ConstraintValidator<StreamingAlreadyExists, String> {

  @Autowired
  private StreamingRepository streamingRepository;

  @Override
  public void initialize(StreamingAlreadyExists constraintAnnotation) {
    this.streamingRepository = SpringContext.getBean(StreamingRepository.class);
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
    Optional<Streaming> optionalStreaming = streamingRepository.getStreamingByName(name);

    return optionalStreaming.isEmpty();
  }
}
