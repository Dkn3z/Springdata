package edu.utvt.springdata.data.entities;
import jakarta.persistence.*;
import lombok.Data;
import  lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity(name = "tc_players")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Player {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column(nullable = false)
    private Integer ranking;

@Column(nullable = false, length = 100)
    private String fullname;

@Column(nullable = false, length = 50)
    private String team ;

@Column(nullable = false, length = 10)
    private String position ;

@Column(nullable = false)
    private Integer age ;

@Column(nullable = false)
    private Double drtg ;

}
