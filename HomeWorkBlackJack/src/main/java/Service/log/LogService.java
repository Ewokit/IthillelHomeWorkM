package Service.log;

import Players.Player;

public interface  LogService {
    void createLog(String name, int numberRounds);

    void startLog(int roundCounter);

    void RoundResultLog(int roundResult);

    void getShapeLog(int shape, String essence);

    void continueLog();

    void stopLog(String target);

    void playerLog(Player player);
}
