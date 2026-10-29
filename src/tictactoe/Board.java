package tictactoe;

public class Board {
    private final Cell[][] board;
    private int size;

    public Board(int size) {
        this.size = size;
        this.board = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = new Cell(Symbol.EMPTY);
            }
        }
    }

    private boolean isInside(int row, int col) {
        return row >= 0 && col >= 0 && row < this.size && col < this.size;
    }

    public void placeSymbol(int row, int col, Symbol symbol) throws IllegalArgumentException {
        if (!isInside(row, col)) throw new IllegalArgumentException("Invalid row or column");
        this.board[row][col].setSymbol(symbol);
    }

    public Symbol getSymbol(int row, int col) throws IllegalArgumentException {
        if (!isInside(row, col)) throw new IllegalArgumentException("Invalid row or column");
        return this.board[row][col].getSymbol();
    }

    public boolean isCellEmpty(int row, int col) throws IllegalArgumentException {
        if (!isInside(row, col)) throw new IllegalArgumentException("Invalid row or column");
        return this.board[row][col].isEmpty();
    }

    public boolean isFull() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (isCellEmpty(i, j)) return false;
            }
        }
        return true;
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                System.out.print(this.board[i][j].getSymbol().getDisplayChar() + "\t");
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

}
