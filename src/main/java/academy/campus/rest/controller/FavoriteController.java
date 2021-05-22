package academy.campus.rest.controller;

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

import academy.campus.rest.entity.Favorite;
import academy.campus.rest.payload.request.AddFavoriteRequest;
import academy.campus.rest.payload.response.AddFavoriteResponse;
import academy.campus.rest.payload.response.ArtistAlbumTrackResponse;
import academy.campus.rest.repository.AlbumRepository;
import academy.campus.rest.repository.ArtistRepository;
import academy.campus.rest.repository.FavoriteRepository;
import academy.campus.rest.repository.TrackRepository;
import academy.campus.rest.security.service.UserDetailsServiceImpl;

/**
 * 
 * @author Matthieu BACHELIER
 * @since 2021
 * @version 1.0
 */
@RestController
@RequestMapping("favorite")
public class FavoriteController {

  @Autowired
  private FavoriteRepository favoriteRepository;

  @Autowired
  private ArtistRepository artistRepository;

  @Autowired
  private AlbumRepository albumRepository;

  @Autowired
  private TrackRepository trackRepository;

  @DeleteMapping("{id}")
  public void deleteFavorite(final @PathVariable("id") Integer favoriteId) {
    favoriteRepository.deleteById(favoriteId);
  }

  @GetMapping
  public ResponseEntity<?> getFavorites() {
    ArtistAlbumTrackResponse response = new ArtistAlbumTrackResponse();
    // Rendre les différentes listes "flat"
    // TODO exercice 2
    return ResponseEntity.ok(response);
  }

  @PostMapping
  public ResponseEntity<?> toggleFavorite(@RequestBody AddFavoriteRequest addFavoriteRequest) {
    // TODO exercice 8
    return null;
  }

  @ResponseBody
  @PutMapping("{id}")
  public Favorite editFavorite(@RequestBody Favorite favorite) {
    return favoriteRepository.save(favorite);
  }

}
