package Service.Game;

public interface RoundService {
    int start(int round);

    int playerTurn(int round);

    int computerTurn();

    int determinateWinner(int player, int computer);
}
