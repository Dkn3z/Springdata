package edu.utvt.springdata.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tc_address")
public class Address {
 @Id
 @GeneratedValue (strategy = GenerationType.IDENTITY)
 @Column (nullable = false)
  private Long id;

  @Column (nullable = false)
 private String street;


  @Column (nullable = false)
 private String city;

  @OneToOne
  @JoinColumn(name = "author_id")
  private Author author;

}