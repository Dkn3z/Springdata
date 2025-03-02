package edu.utvt.springdata.data.repositories;
import edu.utvt.springdata.data.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRespositiry extends JpaRepository<Player, Long> {
}
