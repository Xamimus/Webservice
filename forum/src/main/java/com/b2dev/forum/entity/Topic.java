package com.b2dev.forum.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * Entité Topic persistente en base de données.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "topic")
public class Topic {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String title;

  private boolean locked;

}