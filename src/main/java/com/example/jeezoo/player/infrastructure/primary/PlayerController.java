package com.example.jeezoo.player.infrastructure.primary;

import com.example.jeezoo.player.domain.PlayerRepository;
import com.example.jeezoo.player.domain.model.Player;
import com.example.jeezoo.player.domain.model.PlayerId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping
    public List<PlayerResponse> getAllPlayer() {
        return playerRepository.findAll().stream().map(PlayerResponse::fromPlayer).toList();
    }

    @GetMapping("{id}")
    public ResponseEntity<PlayerResponse> getPlayerById(@PathVariable Long playerId) {
        Player player = playerRepository.findById(PlayerId.of(playerId));
        return ResponseEntity.ok(PlayerResponse.fromPlayer(player));
    }

}
