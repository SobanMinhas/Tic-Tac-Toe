/**
 * the state of the block and implementing the constants given
 */
public class block implements global {

	private int state;

	/**
	 * Parent constructor
	 * @param state of the cell
	 */
	public block(int state) {
		this.state = state;
	}

	/**
	 * Makes the board empty using default constructor
	 */
	public block() {
		this.state = EMPTY;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getState() {
		return this.state;
	}

	/**
	 * changes the states of the board from integers to the concurring symbol
	 * @return the representing symbol
	 */
	public String toString() {
		if (this.state == X) {
			return "X";
		} else if (this.state == O) {
			return "O";
		} else {
			return " ";
		}
	}
}
