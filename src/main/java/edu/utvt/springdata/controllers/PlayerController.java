package edu.utvt.springdata.controllers;

import edu.utvt.springdata.data.entities.Player;
import edu.utvt.springdata.data.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/players")
public class PlayerController {
@Autowired
    private PlayerService playerService;

@GetMapping("/all")
    public List<Player> getAllPlayers() {
    return playerService.findAll();
}

@GetMapping("{id}")
    public ResponseEntity<Player> getPlayerById(@RequestParam Long id) {
    return ResponseEntity.of(this.playerService.findById(id));
}




}
