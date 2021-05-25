package com.b2dev.forum.entity;

import java.util.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * Entité User persistente en base de données.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotBlank
  @Size(max = 255)
  @Email
  private String email;

  @NotBlank
  @Size(max = 255)
  private String password;

  private boolean locked;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
  private Set<Role> roles = new HashSet<>();
}
