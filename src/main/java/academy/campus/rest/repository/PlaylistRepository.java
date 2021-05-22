package academy.campus.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import academy.campus.rest.entity.Playlist;
import academy.campus.rest.entity.User;

/**
 * Extension du Repository CRUD pour ajouter une méthode métier.
 * 
 * @author Matthieu BACHELIER
 * @since 2021
 * @version 1.0
 */
@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

  List<Playlist> findByUser(User user);

}