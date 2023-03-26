package Service.Game.Impl;

import Service.Game.RoundService;
import Service.log.Impl.ErrorServiceImpl;
import Service.log.Impl.LogServiceImpl;

import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class RoundServiceImpl implements RoundService {
    private final int SAVE_TARGET = 909090;

    private final LogServiceImpl LOG_SERVICE;
    private final ErrorServiceImpl ERROR_SERVICE;
    private final ResourceBundle RESOURCE_BUNDLE;

    public RoundServiceImpl(ResourceBundle resourceBundle) {
        this.LOG_SERVICE = new LogServiceImpl(resourceBundle);
        this.ERROR_SERVICE = new ErrorServiceImpl(resourceBundle);
        this.RESOURCE_BUNDLE = resourceBundle;
    }
    @Override
    public int start(int round) {
        int playerShape = playerTurn(round);

        if (playerShape != SAVE_TARGET) {
            return determinateWinner(playerShape, computerTurn());
        } else {
            return SAVE_TARGET;
        }
    }

    @Override
    public int playerTurn(int round) {
        System.out.print(RESOURCE_BUNDLE.getString("console_new_round"));
        String playerInput = new Scanner(System.in).next();
        int playerShape;

        try {
            playerShape = Integer.parseInt(playerInput);
        } catch (NumberFormatException exception) {
            ERROR_SERVICE.numberFormatException(exception);
            throw exception;
        }

        switch (playerShape) {
            case 0 : playerShape = SAVE_TARGET + 1;
            case 1 :
                LOG_SERVICE.startLog(round);
                LOG_SERVICE.getShapeLog(playerShape, "player");
            case 2: LOG_SERVICE.startLog(round);
                LOG_SERVICE.getShapeLog(playerShape, "player");
            case 3 : LOG_SERVICE.startLog(round);
                LOG_SERVICE.getShapeLog(playerShape, "player");
            default : ERROR_SERVICE.StateExceptionLog(String.valueOf(playerShape));
        }
        return playerShape - 1;
    }

    @Override
    public int computerTurn() {
        int computerShape = new Random().nextInt(3);
        LOG_SERVICE.getShapeLog(computerShape + 1, "computer");
        return computerShape;
    }

    @Override
    public int determinateWinner(int player, int computer) {
        if (player != SAVE_TARGET) {
            int[][] gameState = {{0, 1, -1}, {-1, 0, 1}, {1, -1, 0}};
            return gameState[player][computer];
        } else {
            return SAVE_TARGET;
        }    }
}
