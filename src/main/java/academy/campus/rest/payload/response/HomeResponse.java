package academy.campus.rest.payload.response;

import java.util.ArrayList;
import java.util.List;

import academy.campus.rest.entity.Album;
import academy.campus.rest.entity.Artist;

/**
 * 
 * @author Matthieu BACHELIER
 * @since 2021
 * @version 1.0
 */
public class HomeResponse {

  private List<Artist> artists = new ArrayList<>();

  /**
   * @return the artists
   */
  public List<Artist> getArtists() {
    return artists;
  }

  /**
   * @param artists the artists to set
   */
  public void setArtists(List<Artist> artists) {
    this.artists = artists;
  }

  /**
   * @return the albums
   */
  public List<Album> getAlbums() {
    return albums;
  }

  /**
   * @param albums the albums to set
   */
  public void setAlbums(List<Album> albums) {
    this.albums = albums;
  }

  private List<Album> albums = new ArrayList<>();
}
