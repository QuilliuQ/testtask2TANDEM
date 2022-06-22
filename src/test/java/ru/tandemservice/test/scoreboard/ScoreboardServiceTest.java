package ru.tandemservice.test.scoreboard;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.tandemservice.test.model.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ScoreboardServiceTest {

    private final IScoreboardService scoreboardService = ScoreboardService.INSTANCE;

    @AfterEach
    void clearList(){
        scoreboardService.clear();
    }

    @Test
    void checkThatScoresAdded() {
        List<Player> testScoreBoardList = new ArrayList<>();
        Player testPlayer = new Player("Test",11);
        testScoreBoardList.add(testPlayer);
        scoreboardService.addScores(testPlayer);

        assertEquals(testScoreBoardList,scoreboardService.getScoreboardTable());

    }

    @Test
    void checkThatSavedOnlyFivePlaces(){
        generatePlayers();

        assertEquals(5, scoreboardService.getScoreboardTable().size());
    }

    @Test
    void checkThatListSorted(){
        List<Player> testScoreBoardList = generatePlayers();
        testScoreBoardList.sort(Comparator.reverseOrder());

        assertEquals(testScoreBoardList.subList(0,5), scoreboardService.getScoreboardTable());
    }

    private List<Player> generatePlayers(){
        List<Player> testScoreBoardList = new ArrayList<>();
        Random random = new Random();
        for (int i =1;i<10;i++){
            int rndScore =  random.nextInt(1,100);
            Player testPlayer = new Player("Test"+i,rndScore);
            testScoreBoardList.add(testPlayer);
            scoreboardService.addScores(testPlayer);
        }
        return testScoreBoardList;
    }
}
