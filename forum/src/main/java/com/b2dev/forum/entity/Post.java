package com.b2dev.forum.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Entité Post persistente en base de données.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String content;

  private Date createdAt;

  private Date updatedAt;

  @ManyToOne
  private User author;

  @ManyToOne
  private Topic topic;

}
