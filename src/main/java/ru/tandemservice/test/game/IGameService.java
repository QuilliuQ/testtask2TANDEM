package ru.tandemservice.test.game;


import ru.tandemservice.test.model.Player;

import java.util.List;


    /**
    * Инфтерфейс основного ядра игры, соединияющего весь функционал внутри себя
    */

public interface IGameService {

    void gameStage(String input);

    List<Player> getScoreboardTable();

    Player getPlayer();
}
