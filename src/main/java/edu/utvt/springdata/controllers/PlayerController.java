package edu.utvt.springdata.controllers;

import edu.utvt.springdata.data.entities.Player;
import edu.utvt.springdata.data.service.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

@DeleteMapping("/{id}")
    public  ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
    this.playerService.deleteById(id);
    return ResponseEntity.noContent().build();
    }
@PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
    return new ResponseEntity<>(this.playerService.save(player), HttpStatus.CREATED);
   // return ResponseEntity.status(HttpStatus.CREATED).body(this.playerService.save(player));
//    return ResponseEntity.created(null).body(this.playerService.save(player));
}
@PutMapping("/{id}")
public ResponseEntity<Player> updatePlayer(@RequestBody Player player , Long id) {
    return new ResponseEntity<>(this.playerService.update(player, id),HttpStatus.OK);
    //return ResponseEntity.ok(this.playerService.update(player, id));
}
@GetMapping("/page")
public ResponseEntity<Page<Player>> findAllPlayers(@RequestParam (defaultValue = "0", value = "page") Integer pageNumber,
                                                   @RequestParam(defaultValue = "50" , value = "size")Integer pageSize){
    return ResponseEntity.ok(this.playerService.findAll(pageNumber, pageSize));
    }

}
