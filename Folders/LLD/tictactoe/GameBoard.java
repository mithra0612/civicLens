package tictactoe;

import java.util.*;

class GameBoard {

    char[][] board = new char[3][3];
    int turns;
    boolean first = false;
    boolean gameOver = false;

    char choice1;
    char choice2;
    boolean repeated = false;
    Map<Integer, String> map = new HashMap<>();

    GameBoard(char choice1, char choice2) {
        this.choice1 = choice1;
        this.choice2 = choice2;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }

        map.put(1, "00");
        map.put(2, "01");
        map.put(3, "02");
        map.put(4, "10");
        map.put(5, "11");
        map.put(6, "12");
        map.put(7, "20");
        map.put(8, "21");
        map.put(9, "22");

        System.out.println("Displaying position markings on board:");
        printBoardPosition();

        while (turns < 9 && !gameOver) {
            playing();
            if (!repeated)
                turns++;
        }

        if (!gameOver) {
            System.out.println("Game Draw!");
        }
    }

    void playing() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter position:");
        int pos = sc.nextInt();

        String idx = map.get(pos);

        int i = idx.charAt(0) - '0';
        int j = idx.charAt(1) - '0';

        char current;
        if (board[i][j] != '_') {
            System.out.println("Position already taken, choose another position.");
            repeated = true;
            return;
        } else {
            repeated = false;
        }
        if (!first) {
            current = choice1;
            board[i][j] = choice1;
            first = true;
        } else {
            current = choice2;
            board[i][j] = choice2;
            first = false;
        }

        System.out.println("Board after marking:");
        printBoard();

        if (checkWinner(current)) {
            System.out.println("Player with '" + current + "' wins!");
            gameOver = true;
        }
    }

    boolean checkWinner(char c) {

        for (int i = 0; i < 3; i++)
            if (board[i][0] == c && board[i][1] == c && board[i][2] == c)
                return true;

        for (int j = 0; j < 3; j++)
            if (board[0][j] == c && board[1][j] == c && board[2][j] == c)
                return true;

        if (board[0][0] == c && board[1][1] == c && board[2][2] == c)
            return true;

        if (board[0][2] == c && board[1][1] == c && board[2][0] == c)
            return true;
        return false;
    }

    void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    void printBoardPosition() {
        for (int i = 1; i <= 9; i++) {
            System.out.print(i + " ");
            if (i % 3 == 0)
                System.out.println();
        }
    }
}
