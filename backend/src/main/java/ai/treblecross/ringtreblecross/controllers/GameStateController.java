package ai.treblecross.ringtreblecross.controllers;

import ai.treblecross.ringtreblecross.dtos.GameStateDto;
import ai.treblecross.ringtreblecross.services.interfaces.IGameStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameStateController {

    private final IGameStateService gameStateService;

    @Autowired
    public GameStateController(IGameStateService gameStateService) {
        this.gameStateService = gameStateService;
    }

    @PostMapping("/gamestate")
    public GameStateDto makeMove(@RequestBody GameStateDto gameStateDto) throws Exception {
        return gameStateService.makeMove(gameStateDto);
    }
}
