package ru.tandemservice.test.game;

import org.junit.jupiter.api.Test;
import ru.tandemservice.test.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    @Test
    void checkThatGameWork(){
        IGameService gameService = new GameService("TestPlayer");
        gameService.gameStage("a roza azora");
        assertTrue(gameService.getScoreboardTable().contains(gameService.getPlayer()));

    }

    @Test
    void checkThatBlackListWork(){
        IGameService gameService = new GameService("TestPlayer");
        gameService.gameStage("a roza azora");
        assertThrowsExactly(IllegalArgumentException.class,()-> gameService.gameStage("a roza azora"));

    }


    @Test
    void checkThatScoreboardDisplayed(){
        IGameService gameService = new GameService("Test");
        generatePlayers();
        assertNotNull(gameService.getScoreboardTable());
    }

    @Test
    void checkThatNullScoreboardDisplayed(){
        IGameService gameService = new GameService("Test");
        assertNull(gameService.getScoreboardTable());
    }

    private void generatePlayers() {
        for (int j = 0; j < 5; j++) {
            IGameService gameService = new GameService("Player" + j);
            gameService.gameStage("3asa" + j);
            gameService.gameStage("2aa" + j);
            gameService.gameStage("1a" + j);
        }

    }




}