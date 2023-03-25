package Players;

public class Player {
    private String name;
    private int totalRounds;
    private int roundsCounter;
    private int victoryCounter;
    private int defeatCounter;

    public Player(char clear) {
        this.name = "";
        this.totalRounds = 0;
        this.roundsCounter = 0;
        this.victoryCounter = 0;
        this.defeatCounter = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public void setTotalRounds(int totalRounds) {
        this.totalRounds = totalRounds;
    }

    public int getRoundsCounter() {
        return roundsCounter;
    }

    public void setRoundsCounter(int roundsCounter) {
        this.roundsCounter = roundsCounter;
    }

    public int getVictoryCounter() {
        return victoryCounter;
    }

    public void setVictoryCounter(int victoryCounter) {
        this.victoryCounter = victoryCounter;
    }

    public int getDefeatCounter() {
        return defeatCounter;
    }

    public void setDefeatCounter(int defeatCounter) {
        this.defeatCounter = defeatCounter;
    }
    public void updateScore(int roundResult) {
        if (roundResult == 1) {
            victoryCounter++;
        } else if (roundResult == -1) {
            defeatCounter++;
        }
        roundsCounter++;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", totalRounds=" + totalRounds +
                ", roundsCounter=" + roundsCounter +
                ", victoryCounter=" + victoryCounter +
                ", defeatCounter=" + defeatCounter +
                '}';
    }
}
