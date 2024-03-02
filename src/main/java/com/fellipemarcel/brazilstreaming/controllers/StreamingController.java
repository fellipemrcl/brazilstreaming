package com.fellipemarcel.brazilstreaming.controllers;

import com.fellipemarcel.brazilstreaming.controllers.dto.ResponseDto;
import com.fellipemarcel.brazilstreaming.controllers.dto.StreamingDto;
import com.fellipemarcel.brazilstreaming.models.entities.Streaming;
import com.fellipemarcel.brazilstreaming.services.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Streaming controller.
 */
@RestController
@RequestMapping("/streamings")
public class StreamingController {

  private final StreamingService streamingService;

  @Autowired
  public StreamingController(StreamingService streamingService) {
    this.streamingService = streamingService;
  }

  /**
   * Create streaming response entity.
   *
   * @param streamingDto the streaming dto
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<ResponseDto<Streaming>> createStreaming(
      @RequestBody StreamingDto streamingDto
  ) {
    Streaming newStreaming = streamingService.insertStreaming(streamingDto.toEntity());
    ResponseDto<Streaming> response = new ResponseDto<>("Streaming created", newStreaming);

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}
