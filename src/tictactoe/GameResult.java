package tictactoe;

public class GameResult {

    private final GameStatus gameStatus;
    private final Player winner;

    public GameResult(GameStatus gameStatus, Player winner) {
        this.gameStatus = gameStatus;
        this.winner = winner;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Player getWinner() {
        return winner;
    }
}
