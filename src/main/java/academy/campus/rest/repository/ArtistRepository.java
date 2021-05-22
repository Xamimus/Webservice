package academy.campus.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import academy.campus.rest.entity.Artist;

/**
 * Extension du Repository CRUD pour ajouter une méthode métier.
 * 
 * @author Matthieu BACHELIER
 * @since 2021
 * @version 1.0
 */
@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {

  public Artist getByName(String name);

  public List<Artist> findByNameContainingOrderByName(String name);

  @Query("SELECT a FROM Artist a ORDER BY function('RAND')")
  public List<Artist> findRandom();

}