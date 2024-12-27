import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        char currentPlayer = 'X';
        boolean winner = false;

        Scanner sc = new Scanner(System.in);

        for (int move = 0; move < 9; move++) {
            displayBoard(board);
            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;

            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                if (checkWinner(board, currentPlayer)) {
                    displayBoard(board);
                    System.out.println("Player " + currentPlayer + " wins!");
                    winner = true;
                    break;
                }
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("This spot is already taken. Try again.");
                move--;
            }
        }

        if (!winner) {
            System.out.println("It's a draw!");
        }

        sc.close();
    }

    public static void displayBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print("[" + cell + "]");
            }
            System.out.println();
        }
    }

    public static boolean checkWinner(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            || (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }
}
