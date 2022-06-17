package waterbets.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import waterbets.models.Lobby;
import waterbets.servies.LobbyService;


@RestController
@RequestMapping("/api/lobby")
public class LobbyController {

    private final LobbyService lobbyService;

    public LobbyController(LobbyService lobbyService) {
        this.lobbyService = lobbyService;
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<Lobby> betsByUser(@PathVariable int groupId) {
        return ResponseEntity.ok(lobbyService.getLobbyByGroupId(groupId));
    }


}