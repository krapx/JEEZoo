package com.example.jeezoo.player.infrastructure.primary;

import com.example.jeezoo.player.domain.PlayerRepository;
import com.example.jeezoo.player.domain.model.Player;
import com.example.jeezoo.player.domain.model.PlayerId;
import com.example.jeezoo.player.domain.model.PlayerRole;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerRepository playerRepository;
    private final PasswordEncoder passwordEncoder;

    public PlayerController(PlayerRepository playerRepository, PasswordEncoder passwordEncoder) {
        this.playerRepository = playerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public List<PlayerResponse> getAllPlayer() {
        return playerRepository.findAll().stream().map(PlayerResponse::fromPlayer).toList();
    }

    @PostMapping
    public ResponseEntity<PlayerId> createPlayer(@Valid @RequestBody CreatePlayerRequest createPlayerRequest) {
        Player playerToAdd = Player.create(
            createPlayerRequest.username(),
            passwordEncoder.encode(createPlayerRequest.password()),
            createPlayerRequest.email(),
            PlayerRole.PLAYER
        );
        PlayerId playerId = playerRepository.add(playerToAdd);
        return ResponseEntity
            .created(linkTo(methodOn(PlayerController.class).getPlayerById(playerId.getValue())).toUri())
            .body(playerId);
    }

    @GetMapping("{id}")
    public ResponseEntity<PlayerResponse> getPlayerById(@PathVariable Long playerId) {
        Player player = playerRepository.findById(PlayerId.of(playerId));
        return ResponseEntity.ok(PlayerResponse.fromPlayer(player));
    }

}
