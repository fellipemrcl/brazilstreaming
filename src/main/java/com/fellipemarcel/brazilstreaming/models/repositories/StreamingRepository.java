package com.fellipemarcel.brazilstreaming.models.repositories;

import com.fellipemarcel.brazilstreaming.models.entities.Streaming;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Streaming repository.
 */
@Repository
public interface StreamingRepository extends JpaRepository<Streaming, Long> {

  Optional<Streaming> getStreamingByName(String name);
}
