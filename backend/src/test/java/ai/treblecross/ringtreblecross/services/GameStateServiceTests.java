package ai.treblecross.ringtreblecross.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import ai.treblecross.ringtreblecross.exceptions.RingTreblecrossException;
import ai.treblecross.ringtreblecross.dtos.GameStateDto;
import ai.treblecross.ringtreblecross.models.GameState;
import ai.treblecross.ringtreblecross.models.Node;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GameStateServiceTests {

    @Mock
    MinimaxService minimaxServiceMock;

    @InjectMocks
    GameStateService gameStateService;

    @Test
    public void makeMoveTest() throws RingTreblecrossException {
        boolean[] board = new boolean[4];
        int k = 1;
        GameStateDto gameStateDto = new GameStateDto(board, k);

        GameState mockGameState = new GameState(board);
        boolean[] mockOptimalSuccessorBoard = new boolean[] {true, false, false, false};
        GameState mockOptimalSuccessorGameState = new GameState(mockOptimalSuccessorBoard);

        Node makeMoveMockResult = new Node(mockGameState, mockOptimalSuccessorGameState, -1, 1);

        when(minimaxServiceMock.minimax(any(), anyInt())).thenReturn(makeMoveMockResult);

        GameStateDto resultGameStateDto = gameStateService.makeMove(gameStateDto);

        assertArrayEquals(mockOptimalSuccessorBoard, resultGameStateDto.getBoard());
        assertEquals(k, resultGameStateDto.getK());
    }
}
