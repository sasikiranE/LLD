import tictactoe.*;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(3);
        Player A = new Player("A");
        A.setSymbol(Symbol.X);
        Player B = new Player("B");
        B.setSymbol(Symbol.O);
        Player[] players = new Player[2];
        players[0] = A;
        players[1] = B;
        WinStrategy strategy = new StandardWinStrategy();
        Game game = new Game(board, players, strategy);
        try {
            game.makeMove(1, 1);
            game.makeMove(0, 0);
            game.makeMove(0, 2);
            game.makeMove(1, 0);
            game.makeMove(2, 0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}