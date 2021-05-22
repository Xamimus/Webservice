package academy.campus.rest.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import academy.campus.rest.entity.Artist;
import academy.campus.rest.repository.ArtistRepository;

import academy.campus.rest.security.service.UserDetailsServiceImpl;

/**
 * 
 * @author Matthieu BACHELIER
 * @since 2021
 * @version 1.0
 */
@RestController
@RequestMapping("artist")
public class ArtistController {

  static Logger LOGGER = LoggerFactory.getLogger(ArtistController.class);

  @Autowired
  private ArtistRepository artistRepository;

  @Autowired
  private UserDetailsServiceImpl userDetailsServiceImpl;

  @GetMapping
  public Page<Artist> getArtists(Pageable pageable) {
    return artistRepository.findAll(pageable);
  }

  @GetMapping("search")
  public List<Artist> findArtistsByName(final @RequestParam(defaultValue = "") String name) {
    return artistRepository.findByNameContainingOrderByName(name);
  }

  @ResponseBody
  @GetMapping("{id}")
  public Artist getArtistById(final @PathVariable("id") String artistId) {
    try {
      Optional<Artist> artist = artistRepository.findById(Integer.valueOf(artistId));
      return artist.get();
    } catch (Exception e) {
      return null;
    }
  }

  @DeleteMapping("{id}")
  public void adminDeleteArtist(final @PathVariable("id") Integer artistId) {
    artistRepository.deleteById(artistId);
  }

  @PostMapping
  public Artist adminAddArtist(final @RequestBody Artist artist) {
    return artistRepository.save(new Artist(artist.getName()));
  }

  @ResponseBody
  @PutMapping("{id}")
  public Artist adminEditArtist(final @RequestBody Artist artist) {
    return artistRepository.save(new Artist(artist.getName()));
  }

  // @ResponseBody
  // @GetMapping("{id}/albums_and_tracks")
  // getAlbumsAndTracksByArtist() {
  // TODO exercice 6
  // }

  public Artist getByName(String artistName) {
    return artistRepository.getByName(artistName);
  }
}
