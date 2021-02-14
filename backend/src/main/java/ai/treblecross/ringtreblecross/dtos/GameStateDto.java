package ai.treblecross.ringtreblecross.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import ai.treblecross.ringtreblecross.models.GameState;

public class GameStateDto {

    private final boolean[] board;
    private final int k;

    public GameStateDto(@JsonProperty("board") boolean[] board, @JsonProperty("k") int k) {
        this.board = board;
        this.k = k;
    }

    public GameStateDto(GameState gameState, int k) {
        this.board = gameState.getBoard();
        this.k = k;
    }

    public boolean[] getBoard() {
        return this.board.clone();
    }

    public int getK() {
        return this.k;
    }
}
