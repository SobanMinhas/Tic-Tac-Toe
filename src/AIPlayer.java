import java.util.Random;

/**
 * inherits all values of the player class and implements random AI that is not very basic
 */
public class AIPlayer extends player {

    private Random rnd = new Random();

    /**
     * using parent constructor to same values of the AI
     * @param playerSign either X or O
     * @param boardStatus updated board to determine a win
     * @param userName name of the AI
     */
    public AIPlayer(int playerSign, board boardStatus, String userName) {
        super(playerSign, boardStatus, userName);
    }

    /**
     * AI makes plays based on where the random spots are that are available on the board
     * @param boardStatus determine a board status of play at that time
     */
    public void play(board boardStatus) {

        int n;

        int symbol = this.getPlayerSign();

        this.setBoardStatus(boardStatus);

        boolean bool = false;

        while (bool == false) {
            System.out.println(getUserName() + " is making a move...");

            n = rnd.nextInt(9); //random spot between 1 - 9 that the random AI selects

            bool = boardStatus.makeMove(n, symbol);
        }
    }
}
