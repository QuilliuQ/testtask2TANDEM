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
        scoreboardService.clearList();
    }

    @Test
    void checkThatScoresAdded() {

        Player testPlayer = new Player("Test",11);
        scoreboardService.addScores(testPlayer);

        assertTrue(scoreboardService.getScoreboardTable().contains(testPlayer));

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

    @Test
    void checkThatScoresUpdate(){

        Player testPlayer = new Player("Test",11);
        scoreboardService.addScores(testPlayer);
        testPlayer.setScore(20);
        scoreboardService.addScores(testPlayer);
        List<Player> resultList = scoreboardService.getScoreboardTable();
        assertEquals(1, resultList.size());
        assertTrue(testPlayer.containsWithScore(resultList.get(0)));
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

