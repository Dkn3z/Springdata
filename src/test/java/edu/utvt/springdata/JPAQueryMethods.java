package edu.utvt.springdata;

import edu.utvt.springdata.data.entities.Player;
import edu.utvt.springdata.data.repositories.PlayerRespositiry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
public class JPAQueryMethods {
     @Autowired
     private PlayerRespositiry playerRespositiry;
    @Test
    void findByFullName(){
        String fullName = "Harrison Imgram";
        playerRespositiry.findByFullname(fullName).forEach(System.out::println);
    }
    @Test
    void findByFullNameContaining(){
        String name = "Harrison";
        this.playerRespositiry.findByFullnameContaining(name).forEach(System.out::println);
    }
    @Test
    void findByTeamAndAge(){
        String team = "Uta";
        Integer age = 21;

        this.playerRespositiry.findByTeamAndAge(team, age).forEach(System.out::println);
    }
    @Test
    void findByTeamAndPeageble(){
        Pageable pageable = PageRequest.of(0, 5);
        Page<Player> page = this.playerRespositiry.findByTeam("Cha", pageable);
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());

    }
}
