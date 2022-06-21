package ru.tandemservice.test.scoreboard;

import ru.tandemservice.test.model.Player;
import ru.tandemservice.test.words.IWordService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * Базовая реализация интерфейса {@link IWordService}
 */

public class ScoreboardService implements IScoreboardService{

    /**
     * Singleton instance
     */
    public static final IScoreboardService INSTANCE = new ScoreboardService();

    /**
     * Таблица лидеров
     */
    private final List<Player> scoreboardList = new ArrayList<>();

    /**
     * Метод добавления пользователя в таблицу лидеров
     * @param player данный о пользователе(имя, очки)
     * Если пользователей больше 5 удаляет последний элемент списка
     */
    @Override
    public void addScores(Player player) {
        scoreboardList.add(player);
        scoreboardList.sort(Comparator.reverseOrder());
        if(scoreboardList.size()>5){
            scoreboardList.remove(scoreboardList.remove(scoreboardList.size()-1));
        }
    }

    /**
     * Метод получения таблицы лидеров
     */
    @Override
    public List<Player> getScoreboardTable() {
        return scoreboardList;
    }
}
