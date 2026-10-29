package tictactoe;

public interface WinStrategy {
    GameResult checkWin(int row, int col, Board board, Player player);
}
