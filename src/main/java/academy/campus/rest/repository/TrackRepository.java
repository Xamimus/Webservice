package academy.campus.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import academy.campus.rest.entity.Album;
import academy.campus.rest.entity.Artist;
import academy.campus.rest.entity.Track;

/**
 * Extension du Repository CRUD pour ajouter une méthode métier.
 * 
 * @author Matthieu BACHELIER
 * @since 2021
 * @version 1.0
 */
@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {

  List<Track> findByAlbum(Album album);

  List<Track> findByArtistOrderByAlbumYear(Artist artist);

}