package academy.campus.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import academy.campus.rest.entity.Playlist;
import academy.campus.rest.entity.Track;
import academy.campus.rest.repository.PlaylistRepository;
import academy.campus.rest.repository.TrackRepository;
import academy.campus.rest.security.service.UserDetailsServiceImpl;

/**
 * 
 * @author Matthieu BACHELIER
 * @since 2021
 * @version 1.0
 */
@RestController
@RequestMapping("playlist")
public class PlaylistController {

  @Autowired
  private PlaylistRepository playlistRepository;

  @Autowired
  private TrackRepository trackRepository;

  @DeleteMapping("{id}")
  public ResponseEntity<Boolean> deletePlaylist(final @PathVariable("id") Integer id) {
    playlistRepository.deleteById(id);
    return ResponseEntity.ok(Boolean.TRUE);
  }

  @DeleteMapping("{id}/track/{trackId}")
  public ResponseEntity<Playlist> deleteTrackFromPlaylist(final @PathVariable("id") Integer id,
      final @PathVariable("trackId") Integer trackId) {
    // TODO exercice 7
    return ResponseEntity.ok(null);
  }

  @GetMapping
  public ResponseEntity<?> getPlaylists() {
    List<Playlist> p = playlistRepository.findByUser(UserDetailsServiceImpl.getCurrentUser());
    return ResponseEntity.ok(p);
  }

  @GetMapping("{id}")
  @ResponseBody
  public ResponseEntity<Playlist> getPlaylistById(final @PathVariable("id") Integer id) {
    Optional<Playlist> playlist = playlistRepository.findById(id);
    Playlist p = playlist.get();
    return ResponseEntity.ok(p);
  }

  @PostMapping
  public ResponseEntity<Playlist> addPlaylist(@RequestBody Playlist playlist) {
    // TODO exercice 7
    return null;
  }

  @PostMapping("{id}")
  @ResponseBody
  public ResponseEntity<Playlist> addTrackToPlaylist(final @PathVariable("id") Integer id,
      final @RequestBody Track track) {
    Optional<Playlist> playlist = playlistRepository.findById(id);
    // TODO exercice 7
    return null;
  }

  @ResponseBody
  @PutMapping("{id}")
  public Playlist edit(@RequestBody Playlist playlist) {
    return playlistRepository.save(playlist);
  }

}
