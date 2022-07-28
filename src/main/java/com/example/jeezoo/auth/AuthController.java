package com.example.jeezoo.auth;

import com.example.jeezoo.player.domain.Players;
import com.example.jeezoo.player.domain.model.Player;
import com.example.jeezoo.player.domain.model.PlayerId;
import com.example.jeezoo.player.domain.model.PlayerRole;
import com.example.jeezoo.player.domain.model.PlayerService;
import com.example.jeezoo.player.infrastructure.primary.CreatePlayerRequest;
import com.example.jeezoo.player.infrastructure.primary.PlayerController;
import com.example.jeezoo.security.TokenProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

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
    private final PlayerService playerService;

    public AuthController(
        TokenProvider tokenProvider,
        AuthenticationManagerBuilder authenticationManager,
        PasswordEncoder passwordEncoder,
        PlayerService playerService
    ) {
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.playerService = playerService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDto loginDto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
            loginDto.getUsername(),
            loginDto.getPassword()
        );
        Authentication authentication = authenticationManager.getObject().authenticate(authenticationToken);
        Player player = playerService.getByUsername(loginDto.getUsername());
        String token = tokenProvider.createToken(authentication, player.getId().getValue());

//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add(AUTHORIZATION, "Bearer " + token);
//        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);

        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<PlayerId> register(@Valid @RequestBody CreatePlayerRequest createPlayerRequest) {
        Player playerToAdd = Player.create(
            createPlayerRequest.username(),
            passwordEncoder.encode(createPlayerRequest.password()),
            createPlayerRequest.email(),
            PlayerRole.USER
        );
        PlayerId playerId = playerService.create(playerToAdd);
        return ResponseEntity
            .created(linkTo(methodOn(PlayerController.class).getPlayerById(playerId.getValue())).toUri())
            .body(playerId);
    }

    @GetMapping("/demo")
    public String demo() {
        return "demo";
    }
}
