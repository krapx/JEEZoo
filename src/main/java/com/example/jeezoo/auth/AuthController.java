package com.example.jeezoo.auth;

import com.example.jeezoo.player.domain.PlayerRepository;
import com.example.jeezoo.player.domain.model.Player;
import com.example.jeezoo.player.domain.model.PlayerId;
import com.example.jeezoo.player.domain.model.PlayerRole;
import com.example.jeezoo.player.infrastructure.primary.CreatePlayerRequest;
import com.example.jeezoo.player.infrastructure.primary.PlayerController;
import com.example.jeezoo.security.TokenProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping()
public class AuthController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final PlayerRepository playerRepository;

    public AuthController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManager, PasswordEncoder passwordEncoder, PlayerRepository playerRepository) {
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.playerRepository = playerRepository;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDto loginDto) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
        Authentication authentication = authenticationManager.getObject().authenticate(authenticationToken);
        String token = tokenProvider.createToken(authentication);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(AUTHORIZATION, "Bearer " + token);

//        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<PlayerId> createPlayer(@Valid @RequestBody CreatePlayerRequest createPlayerRequest) {
        Player playerToAdd = Player.create(
                createPlayerRequest.username(),
                passwordEncoder.encode(createPlayerRequest.password()),
                createPlayerRequest.email(),
                PlayerRole.USER
        );
        PlayerId playerId = playerRepository.add(playerToAdd);
        return ResponseEntity
                .created(linkTo(methodOn(PlayerController.class).getPlayerById(playerId.getValue())).toUri())
                .body(playerId);
    }


}
