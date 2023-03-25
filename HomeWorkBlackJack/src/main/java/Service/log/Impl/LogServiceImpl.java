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
        String[] strings = RESOURCE_BUNDLE.getString("new game").split("\\.");
        INFO.info(strings[0]);
    }

    @Override
    public void startLog(int roundCounter) {

    }

    @Override
    public void RoundResultLog(int roundResult) {

    }

    @Override
    public void getShapeLog(int shape, String essence) {

    }

    @Override
    public void continueLog() {

    }

    @Override
    public void stopLog(String target) {

    }

    @Override
    public void playerLog(Player player) {

    }
}
