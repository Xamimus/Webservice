package academy.campus.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import academy.campus.rest.entity.EnumRole;
import academy.campus.rest.entity.Role;

/**
 * Extension du Repository CRUD pour ajouter une méthode métier.
 * 
 * @author Matthieu BACHELIER
 * @since 2021
 * @version 1.0
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

  Optional<Role> findByName(EnumRole name);
}