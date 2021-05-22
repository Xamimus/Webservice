package com.b2dev.forum.entity;

import java.util.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * Entité User persistente en base de données.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String email;

  private String password;

  private boolean locked;

  @ManyToMany(fetch = FetchType.LAZY)
  private Set<Role> roles = new HashSet<>();
}