package academy.campus.rest;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import academy.campus.rest.controller.AlbumController;
import academy.campus.rest.controller.TrackController;
import academy.campus.rest.entity.Album;
import academy.campus.rest.entity.Artist;
import academy.campus.rest.entity.EnumRole;
import academy.campus.rest.entity.Role;
import academy.campus.rest.entity.Track;
import academy.campus.rest.entity.User;
import academy.campus.rest.repository.ArtistRepository;
import academy.campus.rest.repository.RoleRepository;
import academy.campus.rest.repository.UserRepository;

/**
 * Point d'entrée du projet.
 * 
 * @author Matthieu BACHELIER
 * @since 2021
 * @version 1.0
 */
@SpringBootApplication
public class TP3Application {

  static Logger LOGGER = LoggerFactory.getLogger(TP3Application.class);

  public static void main(String[] args) {
    SpringApplication.run(TP3Application.class, args);
  }

  @Autowired
  private ArtistRepository artistRepository;

  @Autowired
  private AlbumController albumController;

  @Autowired
  private TrackController trackController;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  private ResourceLoader resourceLoader;

  @Value(value = "${populatedb}")
  private boolean populatedb;

  @PostConstruct
  private void init() throws IOException {
    if (populatedb) {
      LOGGER.info("About to populate database from raw data");
    } else {
      LOGGER.info("Populate database at startup is disabled");
      return;
    }

    if (roleRepository.count() > 0) {
      LOGGER.warn("Database might have been populated before, force exit now");
      return;
    }

    // Création des roles
    Role adminRole = roleRepository.save(new Role(EnumRole.ROLE_ADMIN));
    roleRepository.save(new Role(EnumRole.ROLE_USER));

    // Création d'un utilisateur spécial ayant le rôle d'Administrateur,
    // seule personne habilitée à créer par la suite des entités comme Artist et Album
    User admin = new User();
    admin.setEmail("matthieu.bachelier@campus.academy");
    admin.setPassword(encoder.encode("12345678"));
    Set<Role> roles = new HashSet<>();
    roles.add(adminRole);
    admin.setRoles(roles);
    userRepository.save(admin);

    // Lecture d'un fichier texte représentant des pistes,
    // et reconstruction des entités Artist, Album et Track correspondantes
    Resource resource = resourceLoader.getResource("classpath:raw_db.txt");
    File rawData = resource.getFile();
    Scanner scanner = new Scanner(rawData);
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] values = line.split("¤");
      String artistName = values[0];
      Artist artist = artistRepository.getByName(artistName);
      if (artist == null) {
        artist = artistRepository.save(new Artist(artistName));
      }
      String[] albumValues = values[1].split("\\|");
      Album album = albumController.getByTitleAndArtist(albumValues[0], artist);
      if (album == null) {
        album = new Album();
        album.setTitle(albumValues[0]);

        if (albumValues.length > 2) {
          try {
            album.setYear(Integer.valueOf(albumValues[2]));
          } catch (NumberFormatException e) {
            // LOGGER.info(line);
          }
        }
        album.setArtist(artist);
        album = albumController.addAlbum(album);
      }
      String[] trackValues = values[2].split("\\|");
      Track track = new Track();
      if (!"".equals(trackValues[0])) {
        try {
          track.setDiscNumber(Integer.valueOf(trackValues[0]));
        } catch (NumberFormatException e) {
          // LOGGER.info(line);
        }
      }
      if (!"".equals(trackValues[1])) {
        try {
          track.setTrackNumber(Integer.valueOf(trackValues[1]));
        } catch (NumberFormatException e) {
          // LOGGER.info(line);
        }
      }
      track.setTitle(trackValues[2]);
      try {
        track.setLength(Integer.valueOf(trackValues[3]));
      } catch (NumberFormatException e) {
        // LOGGER.info(line);
      }
      track.setArtist(artist);
      track.setAlbum(album);

      trackController.addTrack(track);
    }
    scanner.close();
  }

  /**
   * Pour ce TP on autorise les requêtes cross domain car il est fort probable que le client REST tourne sur un autre
   * port de la machine.
   * 
   * @return un filtrage CORS
   */
  @Bean
  public CorsFilter corsFilter() {
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    final CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true);
    config.addAllowedOrigin("*");
    config.addAllowedHeader("*");
    config.addAllowedMethod("OPTIONS");
    config.addAllowedMethod("HEAD");
    config.addAllowedMethod("GET");
    config.addAllowedMethod("PUT");
    config.addAllowedMethod("POST");
    config.addAllowedMethod("DELETE");
    config.addAllowedMethod("PATCH");
    source.registerCorsConfiguration("/**", config);
    return new CorsFilter(source);
  }
}
