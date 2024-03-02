package com.fellipemarcel.brazilstreaming.controllers.dto;

import com.fellipemarcel.brazilstreaming.models.entities.Streaming;

/**
 * The type Streaming dto.
 */
public record StreamingDto(
    Long id,
    String name,
    String url,
    Double price,
    Integer simultaneousAccess,
    String category
) {

  public Streaming toEntity() {
    return new Streaming(id, name, url, price, simultaneousAccess, category);
  }
}
