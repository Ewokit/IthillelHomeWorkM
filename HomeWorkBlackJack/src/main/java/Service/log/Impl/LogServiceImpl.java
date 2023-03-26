package Service.log.Impl;

import Players.Player;
import Service.log.LogService;

import java.util.ResourceBundle;
import java.util.logging.Logger;

public class LogServiceImpl implements LogService {
    private final Logger INFO = Logger.getLogger("Info.log");
    private final ResourceBundle RESOURCE_BUNDLE;

    public LogServiceImpl(ResourceBundle resource_bundle) {
        this.RESOURCE_BUNDLE = resource_bundle;
    }

    @Override
    public void createLog(String name, int numberRounds) {
        String[] strings = RESOURCE_BUNDLE.getString("new_game").split("\\.");
        INFO.info(strings[0]);
        INFO.info(strings[1] + name);
        INFO.info(strings[2] + numberRounds);
    }

    @Override
    public void startLog(int roundCounter) {
        INFO.info(RESOURCE_BUNDLE.getString("log_action") + roundCounter);
    }

    @Override
    public void RoundResultLog(int roundResult) {
        String[] strings = RESOURCE_BUNDLE.getString("round_result" + roundResult).split("\\.");
        switch (roundResult) {
            case 0: INFO.info(strings[0]);
            case 1: INFO.info(strings[1]);
            case 2: INFO.info(strings[2]);
            default: throw new IllegalStateException("Value:" + roundResult);
        }
    }

    @Override
    public void getShapeLog(int shape, String essence) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = RESOURCE_BUNDLE.getString("log").split("\\.");
        switch (essence){
            case "P": stringBuilder.append(strings[0]);
            case "C": stringBuilder.append(strings[1]);
            default: throw new IllegalStateException("Value:" + essence);
        }
    }

    @Override
    public void continueLog() {
        INFO.info(RESOURCE_BUNDLE.getString("continue_log:"));
    }

    @Override
    public void stopLog(String target) {
        String[] strings = RESOURCE_BUNDLE.getString("log_stop:").split("\\.");
        switch (target){
            case "S": INFO.info(strings[0]);
            case "E": INFO.info(strings[1]);
            default: throw new IllegalStateException("Value:" + target);
        }
    }

    @Override
    public void playerLog(Player player) {
        String[] strings = RESOURCE_BUNDLE.getString("player_info").split("\\.");
        INFO.info(strings[0].concat(player.getName())
                .concat(strings[1]).concat(String.valueOf(player.getRoundsCounter()))
                .concat("||").concat(String.valueOf(player.getTotalRounds())).concat("||")
                .concat(strings[2]).concat(String.valueOf(player.getVictoryCounter())).concat("||")
                .concat(strings[3]).concat(String.valueOf(player.getDefeatCounter())).concat("||")
                .concat(strings[4]).concat(String.valueOf(player.getRoundsCounter() - player.getVictoryCounter() - player.getDefeatCounter())));
    }
}
