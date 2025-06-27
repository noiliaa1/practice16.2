import java.util.Scanner;
import java.time.LocalDateTime;

public class Game {
    public static void playGame(Scanner scanner) {
        int size = Config.fieldSize;
        char[][] board = new char[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                board[i][j] = ' ';

        char current = 'X';
        String currentPlayer = Config.player1;
        boolean gameOver = false;

        while (!gameOver) {
            printBoard(board);
            System.out.println(currentPlayer + " (" + current + "), введіть рядок і стовпець:");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (row >= 0 && row < size && col >= 0 && col < size && board[row][col] == ' ') {
                board[row][col] = current;
                if (checkWin(board, current)) {
                    printBoard(board);
                    System.out.println("Переможець: " + currentPlayer);
                    Stats.save(currentPlayer, size);
                    gameOver = true;
                } else if (isDraw(board)) {
                    printBoard(board);
                    System.out.println("Нічия!");
                    Stats.save("Нічия", size);
                    gameOver = true;
                } else {
                    current = (current == 'X') ? 'O' : 'X';
                    currentPlayer = (currentPlayer.equals(Config.player1)) ? Config.player2 : Config.player1;
                }
            } else {
                System.out.println("Невірний хід. Спробуйте ще раз.");
            }
        }
    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row)
                System.out.print("[" + cell + "]");
            System.out.println();
        }
    }

    private static boolean checkWin(char[][] b, char ch) {
        int size = b.length;
        for (int i = 0; i < size; i++) {
            if (checkLine(b[i], ch)) return true;  // рядок
            boolean colWin = true;
            for (int j = 0; j < size; j++)
                if (b[j][i] != ch) colWin = false;
            if (colWin) return true;
        }
        boolean diag1 = true, diag2 = true;
        for (int i = 0; i < size; i++) {
            if (b[i][i] != ch) diag1 = false;
            if (b[i][size - 1 - i] != ch) diag2 = false;
        }
        return diag1 || diag2;
    }

    private static boolean checkLine(char[] line, char ch) {
        for (char c : line)
            if (c != ch) return false;
        return true;
    }

    private static boolean isDraw(char[][] board) {
        for (char[] row : board)
            for (char c : row)
                if (c == ' ') return false;
        return true;
    }
}