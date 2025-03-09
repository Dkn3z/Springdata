package edu.utvt.springdata.data.service;

import edu.utvt.springdata.common.NotFoundElementException;
import edu.utvt.springdata.data.entities.Player;
import edu.utvt.springdata.data.repositories.PlayerRespositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PlayerServiceImplementation implements PlayerService {
    @Autowired
    public PlayerRespositiry playerRespositiry;

    @Override
    public  Player save(Player player) {
        return playerRespositiry.save(player);
    }

    @Override
    public Player update (Player player, Long playerId) {
        Optional <Player> playerOptional = this.playerRespositiry.findById(playerId);
        if (playerOptional.isPresent()) {
            Player newPlayer = playerOptional.get();
            newPlayer.setAge(player.getAge());
            newPlayer.setDrtg(player.getDrtg());
            newPlayer.setTeam(player.getTeam());
            newPlayer.setFullname(player.getFullname());
            this.playerRespositiry.save(newPlayer);
        }
        return playerOptional.orElseThrow();
    }

    @Override
    public Optional<Player> findById(Long playerId) {
        return this.playerRespositiry.findById(playerId);
    }

    @Override
    public List <Player> findAll() {
        return this.playerRespositiry.findAll();
    }

    @Override
    public void deleteById(Long playerId){
 /*if (this.playerRespositiry.existsById(playerId)) {
    this.playerRespositiry.deleteById(playerId);
}else {
    throw new NoSuchElementException("No esxiste el jugador");
}*/
        Player playerOptional = this.playerRespositiry.findById(playerId).orElseThrow(NotFoundElementException::new);
        this.playerRespositiry.delete(playerOptional);
     }

    @Override
    public Page<Player> findAll(Integer page, Integer pageSize) {

        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.ASC, "fullname"));

        return this.playerRespositiry.findAll(pageRequest);
    }
}
