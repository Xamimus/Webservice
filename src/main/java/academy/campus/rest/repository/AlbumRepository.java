package academy.campus.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import academy.campus.rest.entity.Album;
import academy.campus.rest.entity.Artist;

/**
 * Extension du Repository CRUD pour ajouter une méthode métier.
 * 
 * @author Matthieu BACHELIER
 * @since 2021
 * @version 1.0
 */
@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

  public Album getByTitleAndArtist(String title, Artist artist);

  public List<Album> findByArtistOrderByYear(Artist artist);

  @Query("SELECT a FROM Album a ORDER BY function('RAND')")
  public List<Album> findRandom();
}