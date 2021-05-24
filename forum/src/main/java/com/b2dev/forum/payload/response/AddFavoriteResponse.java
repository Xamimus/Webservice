package com.b2dev.forum.payload.response;

/**
 * 
 * @author Matthieu BACHELIER
 * @since 2021
 * @version 1.0
 */
public class AddFavoriteResponse {

  private Integer id;

  public AddFavoriteResponse(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

}
