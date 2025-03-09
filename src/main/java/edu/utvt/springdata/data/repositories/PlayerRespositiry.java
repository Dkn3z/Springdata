package edu.utvt.springdata.data.repositories;
import edu.utvt.springdata.data.entities.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRespositiry extends JpaRepository<Player, Long> {
    List<Player> findByFullname(String fullname);

    List<Player> findByFullnameContaining(String fullname);
     
    List<Player> findByTeamAndAge(String team, Integer age);
    
 Page<Player> findByTeam(String team, Pageable pageable);
}
