package com.b2dev.forum.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * Entité ReportReason persistente en base de données.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "reasons")
public class ReportReason {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private EnumReportReason name;

}
