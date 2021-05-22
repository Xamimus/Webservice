package academy.campus.rest.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entité Playlist persistente en base de données.
 * 
 * @author Matthieu BACHELIER
 * @since 2021
 * @version 1.0
 */
@Entity
@Table(name = "playlist")
public class Playlist {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToMany
  private List<Track> tracks = new ArrayList<>();

  @ManyToOne
  @JsonIgnore
  private User user;

  /**
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * @return the tracks
   */
  public List<Track> getTracks() {
    return tracks;
  }

  /**
   * @return the user
   */
  public User getUser() {
    return user;
  }

  /**
   * 
   * /**
   * 
   * @param id the id to set
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @param tracks the tracks to set
   */
  public void setTracks(List<Track> tracks) {
    this.tracks = tracks;
  }

  /**
   * @param user the user to set
   */
  public void setUser(User user) {
    this.user = user;
  }

}