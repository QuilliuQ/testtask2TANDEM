package ru.tandemservice.test.scoreboard;

import ru.tandemservice.test.model.Player;

import java.util.*;

public interface IScoreboardService {

    void addScores(Player player);

    List<Player> getScoreboardTable();
}
