package com.b2dev.forum.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import com.b2dev.forum.repository.PostRepository;


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

  @ManyToOne
  private Category category;

  @ManyToOne
  private User author;

  @OneToMany
  private List<Post> posts;


  public User getAuthor() {
    return author;
  }
}
