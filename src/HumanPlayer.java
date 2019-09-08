
import java.util.Scanner;

/**
 * information needed to play with by a user
 * @author soban minhas
 */
public class HumanPlayer extends player implements global {

	Scanner sc = new Scanner(System.in);

	/**
	 * sub class constructor using super to use parent constructor
	 * @param playerSign user either X or O
	 * @param boardStatus new board status every time
	 * @param userName user entered name
	 */
	public HumanPlayer(int playerSign, board boardStatus, String userName) {
		super(playerSign, boardStatus, userName);
	}

	/**
	 * changes the board after each play to show available spots
	 */
	public void play(board boardStatus) {
		int n;

		int symb = this.getPlayerSign();

		this.setBoardStatus(boardStatus);

		boolean bool = false;

		while (bool == false) {
			System.out.println("Enter a valid move:");

			boardStatus.displayPlayerSelectionBoard();

			n = sc.nextInt();

			bool = boardStatus.makeMove(n, symb);
		}
	}
}
