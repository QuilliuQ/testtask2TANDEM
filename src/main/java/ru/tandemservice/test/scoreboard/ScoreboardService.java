package ru.tandemservice.test.scoreboard;

import ru.tandemservice.test.model.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScoreboardService implements IScoreboardService{

    public static final IScoreboardService INSTANSE = new ScoreboardService();

    private List<Player> scoreboardList = new ArrayList<>();

    @Override
    public void addScores(Player player) {
        scoreboardList.add(player);
        scoreboardList.sort(Comparator.reverseOrder());
        if(scoreboardList.size()>5){
            scoreboardList = scoreboardList.subList(0, 4);
        }
    }

    @Override
    public List<Player> getScoreboardTable() {
        return scoreboardList;
    }
}
