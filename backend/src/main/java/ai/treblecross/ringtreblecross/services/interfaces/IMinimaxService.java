package ai.treblecross.ringtreblecross.services.interfaces;

import ai.treblecross.ringtreblecross.models.GameState;
import ai.treblecross.ringtreblecross.models.Node;
import ai.treblecross.ringtreblecross.exceptions.RingTreblecrossException;

public interface IMinimaxService {

    Node minimax(GameState gameState, int k) throws RingTreblecrossException;
}
