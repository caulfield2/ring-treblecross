package ai.treblecross.ringtreblecross.services;

import ai.treblecross.ringtreblecross.exceptions.RingTreblecrossException;
import ai.treblecross.ringtreblecross.models.GameState;
import ai.treblecross.ringtreblecross.models.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MinimaxServiceTests {

    @InjectMocks
    MinimaxService minimaxService;

    @Test
    public void kIsLargerThanBoardTest() {
        boolean[] board = new boolean[3];
        int k = 4;
        GameState gameState = new GameState(board);

        RingTreblecrossException exception =
                assertThrows(RingTreblecrossException.class, () -> minimaxService.minimax(gameState, k));

        String expectedMessage = "Board length must be less than or equal to k.";

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void gameStateIsTerminalTest() {
        boolean[] board = new boolean[] {true, true, true, true};
        GameState gameState = new GameState(board);
        int k = 4;

        RingTreblecrossException exception =
                assertThrows(RingTreblecrossException.class, () -> minimaxService.minimax(gameState, k));

        String expectedMessage = "A move cannot be made on a victory state.";

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void gameStateIsTerminalAtEdgesTest() {
        boolean[] board = new boolean[] {true, false, true};
        GameState gameState = new GameState(board);
        int k = 2;

        RingTreblecrossException exception =
                assertThrows(RingTreblecrossException.class, () -> minimaxService.minimax(gameState, k));

        String expectedMessage = "A move cannot be made on a victory state.";

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void gameStateIsNotTerminalTest() {
        boolean[] board = new boolean[3];
        GameState gameState = new GameState(board);
        int k = 1;

        Assertions.assertDoesNotThrow(() -> minimaxService.minimax(gameState, k));
    }

    @Test
    public void gameStateIsNotTerminalAtEdgesTest() {
        boolean[] board = new boolean[] {true, false, true, true, false, true};
        GameState gameState = new GameState(board);
        int k = 3;

        Assertions.assertDoesNotThrow(() -> minimaxService.minimax(gameState, k));
    }

    @Test
    public void gameplayScenario1() throws RingTreblecrossException {
        boolean[] board = new boolean[] {true, true, true, false, false, false, true, false, false, false};
        GameState gameState = new GameState(board);
        int k = 5;

        Node result = minimaxService.minimax(gameState, k);

        boolean[] expectedResultOptimalSuccessorBoard =
                new boolean[] {true, true, true, false, false, true, true, false, false, false};
        boolean[] resultOptimalSuccessorBoard = result.getOptimalSuccessorGameState().getBoard();

        assertArrayEquals(expectedResultOptimalSuccessorBoard, resultOptimalSuccessorBoard);
    }

    @Test
    public void gamePlayScenario2() throws RingTreblecrossException {
        boolean[] board = new boolean[] {true, true, false, false, false};
        GameState gameState = new GameState(board);
        int k = 5;

        Node result = minimaxService.minimax(gameState, k);

        boolean[] expectedResultOptimalSuccessorBoard =
                new boolean[] {true, true, true, false, false};
        boolean[] resultOptimalSuccessorBoard = result.getOptimalSuccessorGameState().getBoard();

        assertArrayEquals(expectedResultOptimalSuccessorBoard, resultOptimalSuccessorBoard);
    }
}
