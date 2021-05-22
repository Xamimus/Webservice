package academy.campus.rest.payload.response;

import java.util.ArrayList;
import java.util.List;

import academy.campus.rest.entity.Album;
import academy.campus.rest.entity.Artist;
import academy.campus.rest.entity.Track;

/**
 * 
 * @author Matthieu BACHELIER
 * @since 2021
 * @version 1.0
 */
public class ArtistAlbumTrackResponse {

  private List<Album> albums = new ArrayList<>();

  private List<Artist> artists = new ArrayList<>();

  private List<Track> tracks = new ArrayList<>();

  /**
   * @return the albums
   */
  public List<Album> getAlbums() {
    return albums;
  }

  /**
   * @return the artists
   */
  public List<Artist> getArtists() {
    return artists;
  }

  /**
   * @return the tracks
   */
  public List<Track> getTracks() {
    return tracks;
  }

  /**
   * @param albums the albums to set
   */
  public void setAlbums(List<Album> albums) {
    this.albums = albums;
  }

  /**
   * @param artists the artists to set
   */
  public void setArtists(List<Artist> artists) {
    this.artists = artists;
  }

  /**
   * @param tracks the tracks to set
   */
  public void setTracks(List<Track> tracks) {
    this.tracks = tracks;
  }

}
