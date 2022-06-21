package ru.tandemservice.test.game;

import ru.tandemservice.test.scoreboard.IScoreboardService;
import ru.tandemservice.test.model.Player;
import ru.tandemservice.test.scoreboard.ScoreboardService;
import ru.tandemservice.test.words.IWordService;
import ru.tandemservice.test.words.WordService;
import java.util.ArrayList;
import java.util.List;

public class GameService implements IGameService {

    private final IScoreboardService scoreboardService = ScoreboardService.INSTANSE;
    private final IWordService wordService = WordService.INSTANSE;

    private final List<String> blackList = new ArrayList<>();

    private int score;

    @Override
    public void gameStage(String input) {
        if(!blackList.contains(input)){
            String[] array = input.replace(" ", "").split("");
            if (wordService.checkWord(array)) {
                blackList.add(input);
                score += array.length;
            }
        }
    }

    @Override
    public List<Player> getScoreboardTable() {
        return scoreboardService.getScoreboardTable();
    }

    @Override
    public void stopGame(String name) {
        scoreboardService.addScores(new Player(name,score));
    }
}
