package academy.campus.rest.payload.request;

import javax.validation.constraints.NotBlank;

/**
 * 
 * @author Matthieu BACHELIER
 * @since 2021
 * @version 1.0
 */
public class AddFavoriteRequest {

  @NotBlank
  private Integer id;

  @NotBlank
  private String type;

  public Integer getId() {
    return id;
  }

  public String getType() {
    return type;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setType(String type) {
    this.type = type;
  }

}
