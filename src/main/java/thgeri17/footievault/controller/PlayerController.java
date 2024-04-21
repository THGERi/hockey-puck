package thgeri17.footievault.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thgeri17.footievault.entity.Player;
import thgeri17.footievault.model.PlayerCreateModel;
import thgeri17.footievault.model.PlayerModel;
import thgeri17.footievault.model.PlayerUpdateModel;
import thgeri17.footievault.service.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/players")
    public ResponseEntity<List<PlayerModel>> renderAllPlayers() {
        return ResponseEntity.status(200).body(playerService.getAllPlayers());
    }

    @PostMapping("/players")
    public ResponseEntity<PlayerModel> createPlayer(@RequestBody PlayerCreateModel playerCreateModel) {
        return ResponseEntity.status(201).body(playerService.creatPlayer(playerCreateModel));
    }

    @GetMapping("/players/{id}")
    public ResponseEntity<Player> renderPlayerById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(playerService.findPlayerById(id));
    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayers(id);
        return ResponseEntity.status(204).build();
    }

    @PatchMapping("/players/{id}")
    public Player patchPlayer(@PathVariable Long id, @RequestBody PlayerUpdateModel player) {
        return playerService.updatePlayer(id, player);
    }
}
