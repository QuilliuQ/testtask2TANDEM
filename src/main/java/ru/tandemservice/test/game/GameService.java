package ru.tandemservice.test.game;

import ru.tandemservice.test.scoreboard.IScoreboardService;
import ru.tandemservice.test.model.Player;
import ru.tandemservice.test.scoreboard.ScoreboardService;
import ru.tandemservice.test.word.IWordService;
import ru.tandemservice.test.word.WordService;
import java.util.ArrayList;
import java.util.List;


/**
 * Базовая реализация интерфейса {@link IGameService}
 * Singleton не реализован для создания нового экземпляра каждому игроку
 */

public class GameService implements IGameService {

    public GameService(String name) {
        player = new Player(name);
    }

    /**
     * Получаем для Singleton instance {@link IScoreboardService} и {@link IWordService}
     */

    private final IScoreboardService scoreboardService = ScoreboardService.INSTANCE;
    private final IWordService wordService = WordService.INSTANCE;

    /**
     * Черный список слов
     */

    private final List<String> blackList = new ArrayList<>();

    /**
     * Переменная содержащяя данные игрока
     */

    private final Player player;


    public Player getPlayer() {
        return player;
    }

    /**
     * Основной метод проверки слова/фразы на палиндром
     * @param input Введенное пользователем фраза/слово
     */
    @Override
    public void gameStage(String input) {
        if(!blackList.contains(input)){
            String[] array = input.replace(" ", "").split("");
            if (wordService.checkWord(array)) {
                blackList.add(input);
                player.setScore(array.length);
                scoreboardService.addScores(player);
            }
            return;
        }
        throw new IllegalArgumentException("Word in blacklist");
    }

    /**
     * Метод получения таблицы лидеров
     * @return Список лидеров по убыванию
     */
    @Override
    public List<Player> getScoreboardTable() {
        return scoreboardService.getScoreboardTable();
    }

}
