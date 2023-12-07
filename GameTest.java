public class GameTest {
    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
        testOnePlayerGame();
        testTwoPlayerGame();
    }

    private static void testOnePlayerGame() {
        String[][] board = new String[3][3];
        Game.createGameBoard(board);

        // Simulates a single player game
        int[] playerMoves = {1, 5, 2, 9};
        for (int move : playerMoves) {
            Game.onePlayerGame(board, move);
        }

        // Verify the final status of the board
        System.out.println("Test One Player Game:");
        Game.printBoard(board);
        System.out.println("Game Over: " + Game.checkGameOver(board));
        System.out.println();
    }

    private static void testTwoPlayerGame() {
        String[][] board = new String[3][3];
        Game.createGameBoard(board);

        // Simulates a two-player game
        int[] player1Moves = {1, 5, 2};
        int[] player2Moves = {3, 8, 9};
        for (int i = 0; i < player1Moves.length; i++) {
            Game.twoPlayerGamePlayer1(board, player1Moves[i]);
            Game.twoPlayerGamePlayer2(board, player2Moves[i]);
        }

        // Verify the final status of the board
        System.out.println("Test Two Player Game:");
        Game.printBoard(board);
        System.out.println("Game Over: " + Game.checkGameOver(board));
        System.out.println();
    }
}

