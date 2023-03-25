package Service.Game.Impl;

import Players.Player;
import Service.Game.GameService;
import Service.log.Impl.ErrorServiceImpl;
import Service.log.Impl.LogServiceImpl;
import com.google.gson.Gson;
import exception.NumberException;

import java.io.File;
import java.nio.file.Path;
import java.util.ResourceBundle;
import java.util.Scanner;

import static java.lang.System.exit;

public class GameServiceImpl implements GameService {
    private final Scanner scanner = new Scanner(System.in);

    private final RoundServiceImpl ROUND_SERVICE;
    private final FileServiceImpl FILE_SERVICE;
    private final ResourceBundle RESOURCE_BUNDLE;
    private final LogServiceImpl LOG_SERVICE;
    private final ErrorServiceImpl ERROR_SERVICE;

    public GameServiceImpl(ResourceBundle resourceBundle) {
        this.RESOURCE_BUNDLE = resourceBundle;
        this.ROUND_SERVICE = new RoundServiceImpl(resourceBundle);
        this.LOG_SERVICE = new LogServiceImpl(resourceBundle);
        this.ERROR_SERVICE = new ErrorServiceImpl(resourceBundle);
        this.FILE_SERVICE = new FileServiceImpl(resourceBundle);
    }

    @Override
    public void start() {
        String[] strings = RESOURCE_BUNDLE.getString("Console_game").split("\\.");
        System.out.print(strings[0]);
        int choice = checkInput(scanner.next());
        switch (choice){
            case 1 : createNewGame(strings);
            case 2 : continueGame();
            default: ERROR_SERVICE.StateExceptionLog(String.valueOf(choice));
        }
    }

    @Override
    public void createNewGame(String[] strings) {
        Player player = new Player();

        System.out.print(strings[1]);
        player.setName(scanner.next());
        System.out.print(strings[2]);
        player.setTotalRounds(checkInput(scanner.next()));

        if (player.getTotalRounds() < 0) {
            NumberException numberException = new NumberException();
            ERROR_SERVICE.numberRoundsException(numberException);
            throw numberException;
        }

        LOG_SERVICE.createLog(player.getName(), player.getTotalRounds());
        gameLife(player);
    }

    @Override
    public void save(Player player) {
        Path path = FILE_SERVICE.getPath();
        File file = new File(path.toString(), "/folder");
        file.mkdir();
        FILE_SERVICE.writeFile(new File(file, "game file.json"), true, player.toString());
    }

    @Override
    public void continueGame() {
        String json = FILE_SERVICE.readFile(Path.of("folder/game_file.json"));
        Player player = new Gson().fromJson(json, Player.class);
        LOG_SERVICE.continueLog();
        LOG_SERVICE.playerLog(player);

        do {
            gameLife(player);
        } while (player.getTotalRounds() != player.getRoundsCounter());
    }

    @Override
    public void gameLife(Player player) {
        while (player.getTotalRounds() != player.getRoundsCounter()) {

            int roundResult = ROUND_SERVICE.start(player.getRoundsCounter() + 1);

            if (roundResult > 1 | roundResult < -1) {
                save(player);
                stop("save", player);
            } else {
                player.updateScore(roundResult);
                LOG_SERVICE.RoundResultLog(roundResult);
            }
            save(player);
        }
        stop("end", player);
    }

    @Override
    public void stop(String str, Player player) {
        LOG_SERVICE.playerLog(player);
        LOG_SERVICE.stopLog(str);

        if (str.equalsIgnoreCase("end")) {
            save(new Player('c'));
        }

        exit(0);
    }


    private int checkInput(String string) {
        int result;
        try {
            result = Integer.parseInt(string);
        } catch (NumberFormatException exception) {
            ERROR_SERVICE.numberFormatException(exception);
            throw exception;
        }
        return result;
    }
}