package ai.treblecross.ringtreblecross.services.interfaces;

import ai.treblecross.ringtreblecross.dtos.GameStateDto;

public interface IGameStateService {

    GameStateDto makeMove(GameStateDto gameStateDto) throws Exception;
}
