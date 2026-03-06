package tictactoe;

class User {
    int player1;
    int player2;
    char choice1;
    char choice2;

    User(int player1, String choice) {
        this.player1 = player1;

        if (player1 == 1) {
            player2 = 2;
        } else {
            player2 = 1;
        }

        this.choice1 = choice.charAt(0);

        if (choice1 == 'X') {
            choice2 = 'O';
        } else {
            choice2 = 'X';
        }
    }

    public void getBoard() {
        new GameBoard(choice1, choice2);
    }
}
