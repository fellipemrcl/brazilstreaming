package com.fellipemarcel.brazilstreaming.controllers;

import com.fellipemarcel.brazilstreaming.controllers.dto.ResponseDto;
import com.fellipemarcel.brazilstreaming.controllers.dto.StreamingDto;
import com.fellipemarcel.brazilstreaming.models.entities.Streaming;
import com.fellipemarcel.brazilstreaming.services.StreamingService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
      @RequestBody @Valid StreamingDto streamingDto
  ) {
    String name = streamingDto.name();

    if (streamingService.getStreamingByName(name).isPresent()) {
      ResponseDto<Streaming> response = new ResponseDto<>("Streaming already exists", null);
      return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    Streaming newStreaming = streamingService.insertStreaming(streamingDto.toEntity());

    ResponseDto<Streaming> response = new ResponseDto<>("Streaming created", newStreaming);

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  /**
   * Update streaming response entity.
   *
   * @param id           the id
   * @param streamingDto the streaming dto
   * @return the response entity
   */
  @PutMapping("/{id}")
  public ResponseEntity<ResponseDto<Streaming>> updateStreaming(
      @PathVariable Long id,
      @RequestBody @Valid StreamingDto streamingDto
  ) {
    Optional<Streaming> optionalStreaming =
        streamingService.updateStreaming(id, streamingDto.toEntity());

    if (optionalStreaming.isEmpty()) {
      ResponseDto<Streaming> response =
          new ResponseDto<>(String.format("Streaming with id %d not found", id), null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    ResponseDto<Streaming> response =
        new ResponseDto<>("Streaming updated", optionalStreaming.get());
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  /**
   * Delete streaming response entity.
   *
   * @param id the id
   * @return the response entity
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<ResponseDto<Streaming>> deleteStreaming(@PathVariable Long id) {
    Optional<Streaming> optionalStreaming = streamingService.removeStreamingById(id);

    if (optionalStreaming.isEmpty()) {
      ResponseDto<Streaming> response =
          new ResponseDto<>(String.format("Streaming with id %d not found", id), null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    ResponseDto<Streaming> response =
        new ResponseDto<>("Streaming deleted", optionalStreaming.get());
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  /**
   * Gets streaming by id.
   *
   * @param id the id
   * @return the streaming by id
   */
  @GetMapping("/{id}")
  public ResponseEntity<ResponseDto<Streaming>> getStreamingById(@PathVariable Long id) {
    Optional<Streaming> optionalStreaming = streamingService.getStreamingById(id);

    if (optionalStreaming.isEmpty()) {
      ResponseDto<Streaming> response =
          new ResponseDto<>(String.format("Streaming with id %d not found", id), null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    ResponseDto<Streaming> response = new ResponseDto<>("Streaming found", optionalStreaming.get());
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  /**
   * Gets all streamings.
   *
   * @return the all streamings
   */
  @GetMapping
  public List<StreamingDto> getAllStreamings() {
    List<Streaming> streamings = streamingService.getAllStreamings();
    return streamings.stream()
        .map(streaming ->
            new StreamingDto(streaming.getId(), streaming.getName(), streaming.getUrl(),
                streaming.getPrice(), streaming.getSimultaneousAccess(), streaming.getCategory()))
        .collect(Collectors.toList());
  }
}
