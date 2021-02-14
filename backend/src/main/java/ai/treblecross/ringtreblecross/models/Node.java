package ai.treblecross.ringtreblecross.models;


public class Node {

    private final GameState gameState;
    private final GameState optimalSuccessorGameState;
    private final int score;
    private final int depth;

    public Node(GameState gameState, int score, int depth) {
        this.gameState = gameState;
        this.optimalSuccessorGameState = null;
        this.score = score;
        this.depth = depth;
    }

    public Node(GameState gameState, GameState optimalSuccessorGameState, int score, int depth) {
        this.gameState = gameState;
        this.optimalSuccessorGameState = optimalSuccessorGameState;
        this.score = score;
        this.depth = depth;
    }

    public GameState getGameState() {
        return this.gameState;
    }

    public GameState getOptimalSuccessorGameState() {
        return this.optimalSuccessorGameState;
    }

    public int getScore() {
        return this.score;
    }

    public int getDepth() {
        return this.depth;
    }
}
