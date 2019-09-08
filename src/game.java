
import java.util.Random;
import java.util.Scanner;

/**
 * Main methods that interact with the user in order to get information
 *
 * @author soban minhas
 */
public class game implements global {
    board gameBoard;
    player playerX;
    player playerO;
    int turn, opt, finish = 1;
    String p1, p2;
    Random rnd = new Random();

    Scanner sc = new Scanner(System.in);

    /**
     * Combines all objects created and gets user information
     */
    public void start() {

        this.gameBoard = new board();   //sets new board that is empty
        this.gameBoard.fillBoard();
        System.out.println("! Welcome to tic-tac-toe !");

        while (finish != 0) {
            System.out.println("1 - Human vs Human\n2 - Human vs AI\n3 - AI vs AI\n4 - EXIT");  //user menu
            opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1:
                    System.out.println("Enter player X name:");
                    p1 = sc.nextLine();
                    sc.nextLine();
                    System.out.println("Enter player O name:");
                    p2 = sc.nextLine();
                    finish = 0;
                    this.playerX = new HumanPlayer(X, this.gameBoard, p1);  //player one to be constructed using all information collected
                    this.playerO = new HumanPlayer(O, this.gameBoard, p2);  //player two to be constructed using all information collected
                    break;
                case 2:
                    System.out.println("Enter player X name:");
                    p1 = sc.nextLine();
                    System.out.println("Hello " + p1 + " My name is Soban and we will face off in tic-tac-toe.");
                    finish = 0;
                    this.playerX = new HumanPlayer(X, this.gameBoard, p1);
                    this.playerO = new AIPlayer(O, this.gameBoard, "Soban");    //My very novice AI that goes to random spots that are valid
                    break;
                case 3:
                    System.out.println("This is a game between SobanX and SobanO.");
                    finish = 0;
                    this.playerX = new AIPlayer(X, this.gameBoard, "SobanX");
                    this.playerO = new AIPlayer(O, this.gameBoard, "SobanO");
                    break;
                case 4:
                    System.out.println("Goodbye");
                    finish = 0;
                    return;
                default:
                    System.out.println("Invalid!");
                    break;
            }
        }

        int coinToss = rnd.nextInt(2) + 1;  //random number either one or two
        if (coinToss == 1) {
            System.out.println("Player X won the coin toss, therefore they begin");
        } else if (coinToss == 2) {
            System.out.println("Player O won the coin toss, therefore they begin");
        }
        turn = coinToss;

        while ((finish = gameBoard.updateState()) == EMPTY) {
            gameBoard.displayBoard();
            switch (turn) {
                case X:
                    this.playerX.play(this.gameBoard);
                    this.turn = O;
                    continue;
                case O:
                    this.playerO.play(this.gameBoard);
                    this.turn = X;
                    continue;
            }
        }

        if (finish == 0) {
            if (this.turn == X) {
                this.turn = O;
            } else {
                this.turn = O;
            }
        }

        this.gameBoard.displayBoard();

        if (this.gameBoard.getState() == 3) {
            System.out.println("It is a DRAW! no winner...");   //if board is full with no winner is draw
        } else if (this.turn == 1) {
            System.out.println("The winner is player " + this.playerX);
        } else {
            System.out.println("The winner is player " + this.playerO);
        }
    }
}
