package com.fellipemarcel.brazilstreaming.controllers;

import com.fellipemarcel.brazilstreaming.services.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
