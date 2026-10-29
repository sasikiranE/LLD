package tictactoe;

public class StandardWinStrategy implements WinStrategy {
    @Override
    public GameResult checkWin(int row, int col, Board board, Player player) {
        int size = board.getSize();
        Symbol symbol = board.getSymbol(row, col);
        // row
        boolean found = true;
        for (int j = 0; j < size; j++) {
            if (!symbol.equals(board.getSymbol(row, j))) {
                found = false;
                break;
            }
        }
        if (found) {
            // declare winner
            return winnerResult(player);
        }
        // col
        found = true;
        for (int i = 0; i < size; i++) {
            if (!symbol.equals(board.getSymbol(i, col))) {
                found = false;
                break;
            }
        }
        if (found) {
            // declare winner
            return winnerResult(player);

        }
        // primary diagonal
        if (row == col) {
            found = true;
            for (int i = 0; i < size; i++) {
                if (!symbol.equals(board.getSymbol(i, i))) {
                    found = false;
                    break;
                }
            }
            if (found) {
                // declare winner
                return winnerResult(player);
            }
        }
        // reverse diagonal
        if (row + col == size - 1) {
            found = true;
            for (int i = 0; i < size; i++) {
                if (!symbol.equals(board.getSymbol(i, size - 1 - i))) {
                    found = false;
                    break;
                }
            }
            if (found) {
                // declare winner
                return winnerResult(player);
            }
        }

        if (board.isFull()) {
            return new GameResult(GameStatus.DRAW, null);
        }

        return new GameResult(GameStatus.IN_PROGRESS, null);
    }

    private GameResult winnerResult(Player player) {
        return new GameResult(GameStatus.WINNER, player);
    }
}
