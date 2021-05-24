package com.b2dev.forum.payload.response;

import java.util.List;

/**
 * 
 * @author Matthieu BACHELIER
 * @since 2021
 * @version 1.0
 */
public class JwtResponse {
  private String token;
  private long id;
  private String username;
  private List<String> roles;

  public JwtResponse(String accessToken, long id, String username, List<String> roles) {
    this.token = accessToken;
    this.id = id;
    this.username = username;
    this.roles = roles;
  }

  /**
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * @param username the username to set
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * @return the roles
   */
  public List<String> getRoles() {
    return roles;
  }

  /**
   * @param roles the roles to set
   */
  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  /**
   * @return the token
   */
  public String getToken() {
    return token;
  }

  /**
   * @param token the token to set
   */
  public void setToken(String token) {
    this.token = token;
  }

}
