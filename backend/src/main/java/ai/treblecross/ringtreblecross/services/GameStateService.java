package ai.treblecross.ringtreblecross.services;

import ai.treblecross.ringtreblecross.dtos.GameStateDto;
import ai.treblecross.ringtreblecross.models.GameState;
import ai.treblecross.ringtreblecross.models.Node;
import ai.treblecross.ringtreblecross.services.interfaces.IGameStateService;
import ai.treblecross.ringtreblecross.services.interfaces.IMinimaxService;
import ai.treblecross.ringtreblecross.exceptions.RingTreblecrossException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameStateService implements IGameStateService {

    private final IMinimaxService minimaxService;

    @Autowired
    public GameStateService(IMinimaxService minimaxService) {
        this.minimaxService = minimaxService;
    }

    public GameStateDto makeMove(GameStateDto gameStateDto) throws RingTreblecrossException {
        GameState gameState = new GameState(gameStateDto.getBoard());
        int k = gameStateDto.getK();

        Node currentNode = minimaxService.minimax(gameState, k);
        return new GameStateDto(currentNode.getOptimalSuccessorGameState(), k);
    }
}
