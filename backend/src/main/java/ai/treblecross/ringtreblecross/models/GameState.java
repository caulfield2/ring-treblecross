package ai.treblecross.ringtreblecross.models;

public class GameState {

    private final boolean[] board;

    public GameState(boolean[] board) {
        this.board = board.clone();
    }

    public boolean[] getBoard() {
        return board.clone();
    }
}
