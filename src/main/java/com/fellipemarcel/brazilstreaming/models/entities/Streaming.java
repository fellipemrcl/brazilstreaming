package com.fellipemarcel.brazilstreaming.models.entities;

/**
 * The type Streaming.
 */
public class Streaming {

  private Long id;
  private String name;
  private String url;
  private Double price;
  private Integer simultaneousAccess;
  private String category;

  public Streaming() {
  }

  /**
   * Instantiates a new Streaming.
   *
   * @param id                 the id
   * @param name               the name
   * @param url                the url
   * @param price              the price
   * @param simultaneousAccess the simultaneous access count
   * @param category           the category
   */
  public Streaming(
      Long id,
      String name,
      String url,
      Double price,
      Integer simultaneousAccess,
      String category) {
    this.id = id;
    this.name = name;
    this.url = url;
    this.price = price;
    this.simultaneousAccess = simultaneousAccess;
    this.category = category;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Integer getSimultaneousAccess() {
    return simultaneousAccess;
  }

  public void setSimultaneousAccess(Integer simultaneousAccess) {
    this.simultaneousAccess = simultaneousAccess;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
