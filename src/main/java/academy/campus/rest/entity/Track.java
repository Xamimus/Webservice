package academy.campus.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entité Track persistente en base de données.
 * 
 * @author Matthieu BACHELIER
 * @since 2021
 * @version 1.0
 */
@Entity
@Table(name = "track")
public class Track implements Comparable<Track> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  private Artist artist;

  @ManyToOne
  private Album album;

  private Integer discNumber;

  private Integer length;

  private String title;

  private Integer trackNumber;

  /**
   * @return the album
   */
  public Album getAlbum() {
    return album;
  }

  /**
   * @return the artist
   */
  public Artist getArtist() {
    return artist;
  }

  /**
   * @return the discNumber
   */
  public Integer getDiscNumber() {
    return discNumber;
  }

  /**
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * @return the length
   */
  public Integer getLength() {
    return length;
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @return the trackNumber
   */
  public Integer getTrackNumber() {
    return trackNumber;
  }

  /**
   * @param album the album to set
   */
  public void setAlbum(Album album) {
    this.album = album;
  }

  /**
   * @param artist the artist to set
   */
  public void setArtist(Artist artist) {
    this.artist = artist;
  }

  /**
   * @param discNumber the discNumber to set
   */
  public void setDiscNumber(Integer discNumber) {
    this.discNumber = discNumber;
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
   * @param length the length to set
   */
  public void setLength(Integer length) {
    this.length = length;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @param trackNumber the trackNumber to set
   */
  public void setTrackNumber(Integer trackNumber) {
    this.trackNumber = trackNumber;
  }

  @Override
  public int compareTo(Track other) {
    /*
     * if (album != null && other.album != null) { if (album.getYear() < other.getAlbum().getYear()) { return -1; } else
     * if (album.getYear() > other.getAlbum().getYear()) { return 1; } else { return 0; } } else {
     */
    if (trackNumber < other.trackNumber) {
      return -1;
    } else if (trackNumber > other.trackNumber) {
      return 1;
    } else {
      return 0;
    }
    // }

  }

}