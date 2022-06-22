package ru.tandemservice.test.scoreboard;

import ru.tandemservice.test.model.Player;

import java.util.*;


/**
 * Интерфейс таблицы лидеров
 */
public interface IScoreboardService {

    void addScores(Player player);

    List<Player> getScoreboardTable();

    void clearList();
}
