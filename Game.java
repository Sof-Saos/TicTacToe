import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        String board[][] = new String[3][3];
        createGameBoard(board);
        Scanner sc = new Scanner(System.in);

        boolean gameOver = false;
        while (!gameOver) {
            System.out.println("\u001B[32m" + "Welcome to Tic-Tac-Toe Java!" + "\u001B[0m");

            if (!gameOver) {
                printBoard(board);
                System.out.println("\u001B[34m" + "1. " + "\u001B[0m" + "One player mode");
                System.out.println("\u001B[34m" + "2. " + "\u001B[0m" + "Two players mode");
                System.out.print("Please select the game mode (enter the number): ");
                int option = sc.nextInt();

                if (option == 1) {
                    while (!gameOver) {
                        printBoard(board);
                        System.out.print("Please enter a position: ");
                        int position = sc.nextInt();
                        onePlayerGame(board, position);
                    }
                } else if (option == 2) {
                    System.out.println("Coming soon.");
                } else {
                    System.out.println("Invalid option, please select another one.");
                }
            }
            System.out.println("Thank you for playing Tic-Tac-Toe!");
        }
    }

    private static boolean checkGameOver(String[][] board) {
        boolean result = false;

        //Verify diagonals
        if(board[0][0].equalsIgnoreCase(board[1][1]) && board[1][1].equalsIgnoreCase(board[2][2]) || board[0][2].equalsIgnoreCase(board[1][1]) && board[1][1].equalsIgnoreCase(board[2][0])){
            result = true;
        }

        //Verify horizontals
        if(board[1][0].equalsIgnoreCase(board[1][1]) && board[1][1].equalsIgnoreCase(board[1][2])
        || board[0][0].equalsIgnoreCase(board[0][1]) && board[0][1].equalsIgnoreCase(board[0][2])
        || board[2][0].equalsIgnoreCase(board[2][1]) && board[2][1].equalsIgnoreCase(board[2][2]) ) {
            result = true;
        }

        //verify verticals
        if(board[0][0].equalsIgnoreCase(board[1][0]) && board[1][0].equalsIgnoreCase(board[2][0])
        || board[0][1].equalsIgnoreCase(board[1][1]) && board[1][1].equalsIgnoreCase(board[2][1])
        || board[0][2].equalsIgnoreCase(board[1][2]) && board[1][2].equalsIgnoreCase(board[2][2]) ) {
            result = true;
        }
        return result;
    }

    private static void createGameBoard(String[][] board) {
        int counter = 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = String.valueOf(counter);
                counter++;
                }
            }
    }

    private static void printBoard(String[][] board) {
        for (int i=0; i<3; i++) {
            for (int f =0; f < 3; f++) {
                System.out.print(" " + board[i][f] + " ");

                if (f < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("-----------");
            }
        }
    }

    private static void onePlayerGame(String[][] board, int x) {
        int position = x - 1;
        Random random = new Random();

        if (position >= 0 && position < 9) {
            int row = position / 3;
            int col = position % 3;

            if (board[row][col].equalsIgnoreCase("X") || board[row][col].equalsIgnoreCase("O")) {
                System.out.println("This position is already filled. Please select another one");
            } else {
                board[row][col] = "X";

                if (checkGameOver(board)) {
                    System.out.println("Game over! You won!");
                    return;
                }

                int computerPosition;
                int computerRow, computerCol;

                do {
                    computerPosition = random.nextInt(9);
                    computerRow = computerPosition / 3;
                    computerCol = computerPosition % 3;
                } while (board[computerRow][computerCol].equalsIgnoreCase("X") || board[computerRow][computerCol].equalsIgnoreCase("O"));

                board[computerRow][computerCol] = "O";


                if (checkGameOver(board)) {
                    System.out.println("Game over! Computer won!");
                    return;
                }
            }
        } else {
            System.out.println("Invalid position. Remember the number must be between 1 and 9.");
        }
    }

}
