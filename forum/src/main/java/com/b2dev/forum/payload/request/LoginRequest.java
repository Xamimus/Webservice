package com.b2dev.forum.payload.request;

import javax.validation.constraints.NotBlank;

/**
 * 
 * @author Matthieu BACHELIER
 * @since 2021
 * @version 1.0
 */
public class LoginRequest {
  @NotBlank
  private String email;

  @NotBlank
  private String password;

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }
}
