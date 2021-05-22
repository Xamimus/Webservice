package com.b2dev.forum.entity;

import java.util.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * Entité Report persistente en base de données.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "report")
public class Report {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne
  private User author;

  @ManyToMany(fetch = FetchType.LAZY)
  private Set<ReportReason> reason = new HashSet<>();

}