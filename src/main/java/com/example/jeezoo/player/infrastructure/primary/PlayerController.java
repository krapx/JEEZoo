package com.example.jeezoo.player.infrastructure.primary;

import com.example.jeezoo.player.domain.Players;
import com.example.jeezoo.player.domain.model.Player;
import com.example.jeezoo.player.domain.model.PlayerId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final Players players;

    public PlayerController(Players players) {
        this.players = players;
    }

    @GetMapping
    public List<PlayerResponse> getAllPlayer() {
        return players.findAll().stream().map(PlayerResponse::fromPlayer).toList();
    }

    @GetMapping("{id}")
    public ResponseEntity<PlayerResponse> getPlayerById(@PathVariable Long playerId) {
        Player player = players.findById(PlayerId.of(playerId));
        return ResponseEntity.ok(PlayerResponse.fromPlayer(player));
    }

}
