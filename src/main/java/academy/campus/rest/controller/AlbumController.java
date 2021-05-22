package academy.campus.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import academy.campus.rest.entity.Album;
import academy.campus.rest.entity.Artist;
import academy.campus.rest.entity.Track;
import academy.campus.rest.repository.AlbumRepository;
import academy.campus.rest.repository.TrackRepository;

/**
 * 
 * @author Matthieu BACHELIER
 * @since 2021
 * @version 1.0
 */
@RestController
public class AlbumController {

  @Autowired
  private AlbumRepository albumRepository;

  @Autowired
  private TrackRepository trackRepository;

  @ResponseBody
  @GetMapping("/album")
  public Page<Album> getAlbums(Pageable pageable) {
    return albumRepository.findAll(pageable);
  }

  @ResponseBody
  @GetMapping("/album/{id}")
  public Album getAlbumById(final @PathVariable("id") String albumId) {
    try {
      return albumRepository.findById(Integer.valueOf(albumId)).get();
    } catch (Exception e) {
      return null;
    }
  }

  @DeleteMapping("/album/{id}")
  public void deletAlbum(final @PathVariable("id") Integer albumId) {
    albumRepository.deleteById(albumId);
  }

  @PostMapping("/album")
  public Album addAlbum(@RequestBody Album album) {
    Album albumToSave = new Album();
    albumToSave.setArtist(album.getArtist());
    albumToSave.setTitle(album.getTitle());
    albumToSave.setYear(album.getYear());
    albumToSave = albumRepository.save(albumToSave);
    return albumToSave;
  }

  @ResponseBody
  @PutMapping("/album/{id}")
  public Album editAlbum(final @RequestBody Album album) {
    return albumRepository.save(album);
  }

  @ResponseBody
  @GetMapping("/album/{id}/tracks")
  public List<Track> getTracksByAlbum(final @PathVariable("id") Album album) {
    // TODO exercice 2
    try {
      return trackRepository.findByAlbum(album);
    } catch (Exception e) {
      return null;
    }
  }

  public Album getByTitleAndArtist(String title, Artist artist) {
    return albumRepository.getByTitleAndArtist(title, artist);
  }

}
