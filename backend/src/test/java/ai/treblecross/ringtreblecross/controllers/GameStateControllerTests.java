package ai.treblecross.ringtreblecross.controllers;

import ai.treblecross.ringtreblecross.dtos.GameStateDto;
import ai.treblecross.ringtreblecross.services.GameStateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameStateControllerTests {

    @Mock
    GameStateService gameStateServiceMock;

    @InjectMocks
    GameStateController gameStateController;

    @Test
    public void makeMoveTest() throws Exception {
        boolean[] board = new boolean[4];
        int k = 2;
        GameStateDto gameStateDto = new GameStateDto(board, k);

        boolean[] mockOptimalSuccessorBoard = new boolean[] {true, false, false, false};
        GameStateDto makeMoveMockResult = new GameStateDto(mockOptimalSuccessorBoard, k);

        when(gameStateServiceMock.makeMove(gameStateDto)).thenReturn(makeMoveMockResult);

        GameStateDto resultGameStateDto = gameStateController.makeMove(gameStateDto);

        assertArrayEquals(mockOptimalSuccessorBoard, resultGameStateDto.getBoard());
        assertEquals(resultGameStateDto.getK(), k);
    }
}
