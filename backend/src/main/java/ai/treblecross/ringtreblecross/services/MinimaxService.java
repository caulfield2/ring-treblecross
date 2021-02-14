package ai.treblecross.ringtreblecross.services;

import ai.treblecross.ringtreblecross.models.GameState;
import ai.treblecross.ringtreblecross.models.Node;
import ai.treblecross.ringtreblecross.services.interfaces.IMinimaxService;
import ai.treblecross.ringtreblecross.exceptions.RingTreblecrossException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class MinimaxService implements IMinimaxService {

    public Node minimax(GameState gameState, int k) throws RingTreblecrossException {
        if (k > gameState.getBoard().length) {
            throw new RingTreblecrossException("Board length must be less than or equal to k.");
        }

        if (isTerminalState(gameState, k)) {
            throw new RingTreblecrossException("A move cannot be made on a victory state.");
        }

        return minimax(gameState, k, true, 0);
    }

    // Returns a Node containing the optimal successor game state and score based
    // on current gameState, k, isMaxTurn, and the depth of the successor nodes
    private Node minimax(GameState gameState, int k, boolean isMaxTurn, int depth) {
        if (isTerminalState(gameState, k)) {
            int score = isMaxTurn ? -1 : 1;

            return new Node(gameState, score, depth);
        }

        // Recursive call
        List<Node> successorNodes = getSuccessorNodes(gameState, k, isMaxTurn, depth);

        Comparator<Node> optimalSuccessorNodeComparator;

        if (isMaxTurn) {
            boolean maxVictorySuccessorNodeExists = successorNodes.stream().anyMatch(n -> n.getScore() == 1);

            if (maxVictorySuccessorNodeExists) {
                optimalSuccessorNodeComparator = Comparator.comparing(Node::getScore).reversed();
                optimalSuccessorNodeComparator.thenComparing(Node::getDepth);
            } else {
                optimalSuccessorNodeComparator = Comparator.comparing(Node::getDepth).reversed();
            }
        } else {
            boolean minVictorySuccessorNodeExists = successorNodes.stream().anyMatch(n -> n.getScore() == -1);

            if (minVictorySuccessorNodeExists) {
                optimalSuccessorNodeComparator = Comparator.comparing(Node::getScore);
                optimalSuccessorNodeComparator.thenComparing(Node::getDepth);
            } else {
                optimalSuccessorNodeComparator = Comparator.comparing(Node::getDepth).reversed();
            }
        }

        Node optimalSuccessorNode = successorNodes.stream().min(optimalSuccessorNodeComparator).get();

        return new Node(
                gameState,
                optimalSuccessorNode.getGameState(),
                optimalSuccessorNode.getScore(),
                optimalSuccessorNode.getDepth() + 1
        );
    }

    // Calls minimax for each possible successor of gameState and returns a list of possible successor nodes
    private List<Node> getSuccessorNodes(GameState gameState, int k, boolean isMaxTurn, int depth) {
        boolean[] board = gameState.getBoard();
        List<Node> successorNodes = new ArrayList<>(board.length);

        for (int i = 0; i < board.length; i++) {
            boolean curr = board[i];

            if (!curr) {
                boolean[] successorBoard = gameState.getBoard();
                successorBoard[i] = true;
                Node successorNode = minimax(new GameState(successorBoard), k, !isMaxTurn, depth + 1);
                successorNodes.add(successorNode);
            }
        }

        return successorNodes;
    }

    private boolean isTerminalState(GameState gameState, int k) {
        boolean[] board = gameState.getBoard();
        int streak = 0;

        for (int i = 0; i < board.length; i++) {
            boolean curr = board[i];

            if (curr) {
                streak++;

                if (streak >= k) {
                    return true;
                }
            } else {
                streak = 0;
            }

            // If on the last node and it is true, start from the beginning again and loop once
            if (i == board.length - 1 && curr) {
                for (boolean b : board) {
                    if (b) {
                        streak++;

                        if (streak >= k) {
                            return true;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }

        return false;
    }
}
