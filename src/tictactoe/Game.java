package tictactoe;

public class Game {
    private final Board board;
    private final Player[] players;
    private int currentPlayerIdx;
    private GameResult gameResult;
    private final WinStrategy winStrategy;

    public Game(Board board, Player[] players, WinStrategy winStrategy) {
        this.board = board;
        this.players = players;
        this.currentPlayerIdx = 0;
        this.gameResult = new GameResult(GameStatus.IN_PROGRESS, null);
        this.winStrategy = winStrategy;
    }

    public void makeMove(int row, int col) throws Exception {
        if (gameOver()) {
            throw new Exception("This game is over");
        }
        if (!this.board.isCellEmpty(row, col)) {
            throw new Exception("INVALID MOVE : This cell is already marked");
        }
        board.placeSymbol(row, col, this.players[currentPlayerIdx].getSymbol());
        board.print();
        this.gameResult = winStrategy.checkWin(row, col, this.board, this.players[currentPlayerIdx]);
        if (gameResult.getGameStatus() == GameStatus.WINNER) {
            System.out.println(
                    "WINNER: " + gameResult.getWinner()
            );
        } else if (gameResult.getGameStatus() == GameStatus.DRAW) {
            System.out.println("Game ended in a draw!");
        } else {
            moveToNextPlayer();
        }
    }

    private void moveToNextPlayer() {
        this.currentPlayerIdx = (this.currentPlayerIdx + 1) % this.players.length;
    }

    private boolean gameOver() {
        return this.gameResult.getGameStatus() != GameStatus.IN_PROGRESS;
    }

}
