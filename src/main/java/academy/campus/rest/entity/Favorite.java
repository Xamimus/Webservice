package academy.campus.rest.entity;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entité Favorite persistente en base de données.
 * 
 * @author Matthieu BACHELIER
 * @since 2021
 * @version 1.0
 */
@Entity
@Table(name = "favorite")
public class Favorite {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToMany
  private Set<Album> albums = new TreeSet<>();

  @ManyToMany
  private Set<Artist> artists = new TreeSet<>();

  private Date date = new Date();

  @ManyToMany
  private Set<Track> tracks = new TreeSet<>();

  @ManyToOne(optional = false)
  private User user;

  /**
   * @return the albums
   */
  public Set<Album> getAlbums() {
    return albums;
  }

  /**
   * @return the artists
   */
  public Set<Artist> getArtists() {
    return artists;
  }

  /**
   * @return the date
   */
  public Date getDate() {
    return date;
  }

  /**
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * @return the tracks
   */
  public Set<Track> getTracks() {
    return tracks;
  }

  /**
   * @return the user
   */
  // public User getUser() {
  // return user;
  // }

  /**
   * @param albums the albums to set
   */
  public void setAlbums(Set<Album> albums) {
    this.albums = albums;
  }

  /**
   * @param artists the artists to set
   */
  public void setArtists(Set<Artist> artists) {
    this.artists = artists;
  }

  /**
   * @param date the date to set
   */
  public void setDate(Date date) {
    this.date = date;
  }

  /**
   * @param id the id to set
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @param tracks the tracks to set
   */
  public void setTracks(Set<Track> tracks) {
    this.tracks = tracks;
  }

  /**
   * @param user the user to set
   */
  public void setUser(User user) {
    this.user = user;
  }
}