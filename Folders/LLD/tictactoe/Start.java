package tictactoe;
import java.util.*;

class Start {
    int player;
    String choice;
    Scanner sc = new Scanner(System.in);   // FIX

    public void run() {
        startMessage();
        userChoice();
        beginGame();
    }

    public void startMessage() {
        System.out.println("Starting Tic-Tac-Toe game...");
    }

    public void userChoice() {
        System.out.println("Select which player will begin, player 1 or 2");
        String playerChoice = sc.nextLine();

        if (playerChoice.equalsIgnoreCase("player 1")) {
            this.player = 1;
        } else {
            this.player = 2;
        }

        System.out.println("X or O?");
        String xo = sc.next();

        if (xo.equalsIgnoreCase("x")) {
            this.choice = "X";
        } else {
            this.choice = "O";
        }
    }

    public void beginGame() {
        User user = new User(player, choice);
        user.getBoard();
    }
}
