package edu.utvt.springdata;

import edu.utvt.springdata.data.entities.Player;
import edu.utvt.springdata.data.repositories.PlayerRespositiry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest
public class CrudTest {

    Logger LOGGER = LoggerFactory.getLogger(CrudTest.class);

    @Autowired
    private PlayerRespositiry playerRespositiry;

    @Test
    void addPlayer() {
        Player player = new Player(null,1000,"el chicharito","las chivas", "c", 100,5.0);
        this.playerRespositiry.save(player);
        Assertions.assertNotNull(player.getId(), () -> "The id of the player is null");
        System.out.println(player);
    }

    @Test
    void updatePlayer() {
        Player player = null;
        Integer currentAge= 0;

        player = this.playerRespositiry.findAll().getFirst();
        Assertions.assertNotNull(player.getId(), () -> "The player must not be null");
        currentAge = player.getAge();
        player.setAge(currentAge+1);
        this.playerRespositiry.save(player);

        this.LOGGER.info("Player updated" + player);
        Assertions.assertTrue(player.getAge() > currentAge , ()-> "The player is less than the current age");
    }

    @Test
    void deletePlayer() {
        Player player = null;

        player = this.playerRespositiry.findAll().getFirst();
        this.playerRespositiry.delete(player);

        player = this.playerRespositiry.findById(player.getId()).orElse(null);
        Assertions.assertNull(player, () -> "The player is null");
        this.LOGGER.info("Player deleted" + player);

    }

}
