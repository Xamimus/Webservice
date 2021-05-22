package academy.campus.rest.controller;

import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import academy.campus.rest.entity.Track;
import academy.campus.rest.repository.TrackRepository;

/**
 * 
 * @author Matthieu BACHELIER
 * @since 2021
 * @version 1.0
 */
@RestController
@RequestMapping("track")
public class TrackController {

  @Autowired
  private TrackRepository trackRepository;

  @GetMapping
  public Page<Track> getTracks(Pageable pageable) {
    return trackRepository.findAll(pageable);
  }

  @ResponseBody
  @GetMapping("{id}")
  public Track getTrackById(final @PathVariable("id") String trackId) {
    try {
      Optional<Track> track = trackRepository.findById(Integer.valueOf(trackId));
      return track.get();
    } catch (Exception e) {
      return null;
    }
  }

  @DeleteMapping("{id}")
  public void deleteTrack(final @PathVariable("id") Integer trackId) {
    trackRepository.deleteById(trackId);
  }

  @PostMapping
  public Track addTrack(@RequestBody Track track) {
    Track saved = trackRepository.save(track);
    return saved;
  }

  @ResponseBody
  @PutMapping("{id}")
  public Track editTrack(@RequestBody Track track) {
    Track updated = trackRepository.save(track);
    return updated;
  }

}
