package edu.utvt.springdata.data.entities;

import edu.utvt.springdata.data.common.ReatingOptions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tc_ratings")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ReatingOptions clasificacion;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
