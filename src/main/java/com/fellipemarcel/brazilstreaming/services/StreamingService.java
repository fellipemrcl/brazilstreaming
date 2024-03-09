package com.fellipemarcel.brazilstreaming.services;

import com.fellipemarcel.brazilstreaming.exception.StreamingNotFoundException;
import com.fellipemarcel.brazilstreaming.models.entities.Streaming;
import com.fellipemarcel.brazilstreaming.models.repositories.StreamingRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Streaming service.
 */
@Service
public class StreamingService {

  private final StreamingRepository streamingRepository;

  @Autowired
  public StreamingService(StreamingRepository streamingRepository) {
    this.streamingRepository = streamingRepository;
  }

  public Streaming insertStreaming(Streaming streaming) {
    return streamingRepository.save(streaming);
  }

  /**
   * Gets streaming by id.
   *
   * @param id the id
   * @return the streaming by id
   */
  public Optional<Streaming> getStreamingById(Long id) {
    Optional<Streaming> optionalStreaming = streamingRepository.findById(id);

    if (optionalStreaming.isEmpty()) {
      throw new StreamingNotFoundException();
    }

    return optionalStreaming;
  }

  public List<Streaming> getAllStreamings() {
    return streamingRepository.findAll();
  }

  /**
   * Update streaming optional.
   *
   * @param id        the id
   * @param streaming the streaming
   * @return the optional
   */
  public Optional<Streaming> updateStreaming(Long id, Streaming streaming) {
    Optional<Streaming> optionalStreaming = streamingRepository.findById(id);

    if (optionalStreaming.isEmpty()) {
      throw new StreamingNotFoundException();
    }

    Streaming streamingFromDb = optionalStreaming.get();
    streamingFromDb.setName(streaming.getName());
    streamingFromDb.setUrl(streaming.getUrl());
    streamingFromDb.setPrice(streaming.getPrice());
    streamingFromDb.setSimultaneousAccess(streaming.getSimultaneousAccess());
    streamingFromDb.setCategory(streaming.getCategory());

    Streaming updatedStreaming = streamingRepository.save(streamingFromDb);

    return Optional.of(updatedStreaming);

  }

  /**
   * Remove streaming by id optional.
   *
   * @param id the id
   * @return the optional
   */
  public Optional<Streaming> removeStreamingById(Long id) {
    Optional<Streaming> optionalStreaming = streamingRepository.findById(id);

    if (optionalStreaming.isEmpty()) {
      throw new StreamingNotFoundException();
    }

    streamingRepository.deleteById(id);

    return optionalStreaming;
  }

  public Optional<Streaming> getStreamingByName(String name) {
    return streamingRepository.getStreamingByName(name);
  }
}
