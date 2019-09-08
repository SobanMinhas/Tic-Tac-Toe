/**
 * Parent class to for player information
 * 
 * @author soban Minhas
 */
public abstract class player implements global {
	
	private int playerSign; // either X or O
	private board boardStatus; // updates the board after each play
	private String userName; // player Name

	/**
	 * Parent constructor for all players
	 * 
	 * @param playerSign user either X or O
	 * @param boardStatus new board updated
	 * @param userName
	 */
	public player(int playerSign, board boardStatus, String userName) {
		this.playerSign = playerSign;
		this.boardStatus = boardStatus;
		this.userName = userName;
	}

	public int getPlayerSign() {
		return playerSign;
	}

	public void setPlayerSign(int playerSign) {
		this.playerSign = playerSign;
	}

	public board getBoardStatus() {
		return boardStatus;
	}

	public void setBoardStatus(board boardStatus) {
		this.boardStatus = boardStatus;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * toString to return user information
	 */
	public String toString() {
		return this.userName;
	}

	public abstract void play(board boardStatus); // method to be used by all sub classes
}
