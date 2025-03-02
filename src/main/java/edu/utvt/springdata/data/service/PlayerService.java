package edu.utvt.springdata.data.service;

import edu.utvt.springdata.data.entities.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    public Player save(Player player);

    public Player update(Player player, Long PlayerId);

    public Optional<Player> findById(Long PlayerId);

    public List<Player> findAll();

    public Player deleteById(Long PlayerId);

}
