package academy.campus.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academy.campus.rest.entity.Album;
import academy.campus.rest.entity.Artist;
import academy.campus.rest.payload.response.HomeResponse;
import academy.campus.rest.repository.AlbumRepository;
import academy.campus.rest.repository.ArtistRepository;

/**
 * 
 * @author Matthieu BACHELIER
 * @since 2021
 * @version 1.0
 */
@RestController
@RequestMapping("home")
public class HomeController {

  @Autowired
  private ArtistRepository artistRepository;

  @Autowired
  private AlbumRepository albumRepository;

  @GetMapping
  public HomeResponse getHome() {
    // TODO exercice 3
    List<Artist> artists = artistRepository.findRandom().subList(0, 3);
    List<Album> albums = albumRepository.findRandom().subList(0, 3);

    HomeResponse response = new HomeResponse();
    response.setAlbums(albums);
    response.setArtists(artists);
    return response;
  }

}
