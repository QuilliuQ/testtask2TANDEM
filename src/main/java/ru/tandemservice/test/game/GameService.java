package ru.tandemservice.test.game;

import ru.tandemservice.test.scoreboard.IScoreboardService;
import ru.tandemservice.test.model.Player;
import ru.tandemservice.test.scoreboard.ScoreboardService;
import ru.tandemservice.test.words.IWordService;
import ru.tandemservice.test.words.WordService;
import java.util.ArrayList;
import java.util.List;


/**
 * Базовая реализация интерфейса {@link IGameService}
 * Singleton не реализован для создания нового экземпляра каждому игроку
 */

class GameService implements IGameService {

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
     * Переменная содержащяя количество очков игрока
     */

    private int score;

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
                score += array.length;
            }
        }
    }

    /**
     * Метод получения таблицы лидеров
     * @return Список лидеров по убыванию
     */
    @Override
    public List<Player> getScoreboardTable() {
        return scoreboardService.getScoreboardTable();
    }

    /**
     * Метод окончания игры
     * @param name Имя пользователя, таблица лидеров из цифр будет не информативной
     */
    @Override
    public void stopGame(String name) {
        scoreboardService.addScores(new Player(name,score));
    }
}
