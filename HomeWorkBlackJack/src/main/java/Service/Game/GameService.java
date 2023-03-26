package Service.Game;

import Players.Player;

public interface  GameService {
    void start();
    void createNewGame(String[] strings);
    void save(Player player);
    void continueGame();
    void gameLife(Player player);
    void stop(String str, Player player);
}
