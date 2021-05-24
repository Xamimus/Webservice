package com.b2dev.forum.payload.response;

/**
 * 
 * @author Matthieu BACHELIER
 * @since 2021
 * @version 1.0
 */
public class MessageResponse {
  private Integer apiCode;

  private String message;

  public MessageResponse(Integer apiCode, String message) {
    this.apiCode = apiCode;
    this.message = message;
  }

  /**
   * @return the apiCode
   */
  public Integer getApiCode() {
    return apiCode;
  }

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param apiCode the apiCode to set
   */
  public void setApiCode(Integer apiCode) {
    this.apiCode = apiCode;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

}
