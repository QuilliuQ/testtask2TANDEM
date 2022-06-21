package ru.tandemservice.test.game;


import ru.tandemservice.test.model.Player;

import java.util.List;

interface IGameService {


    void gameStage(String input);

    List<Player> getScoreboardTable();

    void stopGame(String name);
}
