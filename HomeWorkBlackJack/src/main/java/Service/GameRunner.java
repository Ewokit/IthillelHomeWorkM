package Service;

import Service.Game.GameService;
import Service.Game.Impl.GameServiceImpl;
import Service.Game.Impl.RoundServiceImpl;

import java.util.Locale;
import java.util.ResourceBundle;

public class  GameRunner {
    public static void main(String[] args) {
        ResourceBundle resourceBundle = getBundle(args);
        GameServiceImpl gameService = new GameServiceImpl(resourceBundle);
        gameService.start();
    }
    private static ResourceBundle getBundle(String[] args){
        Locale defaultLocale = (args.length != 0) ? new Locale(args[0]) : Locale.getDefault();
        return ResourceBundle.getBundle("language", defaultLocale);
    }
}
