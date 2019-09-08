public class board implements global {

    private block[][] blocks = new block[3][3]; //3 by 3 board
    private int state;

    /**
     * Fill board with empty values
     */
    public void fillBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                blocks[i][j] = new block();
            }
        }
    }

    /**
     * Display board with X and O for console
     */
    public void displayBoard() {
        String symbol;
        for ( int i = 0; i < 3; i++ )
        {
            for ( int j = 0; j < 3; j++ )
            {
                System.out.print("|");

                switch (blocks[i][j].getState()) {
                    case X:
                        symbol = "X";
                        break;
                    case O:
                        symbol = "O";
                        break;
                    default:
                        symbol = "" + (3 * i + j);
                        break;
                }System.out.print(symbol);
            }System.out.println("|");
        }
    }

    /**
     * Display options for user to enter from 0-9
     */
    public void displayPlayerSelectionBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String symbol;
                switch (blocks[i][j].getState()) {
                    case X:
                        symbol = "X";
                        break;
                    case O:
                        symbol = "O";
                        break;
                    default:
                        symbol = "" + (3 * i + j);
                        break;
                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    public int getState() {
        return state;
    }

    /**
     * determines the state of the board if it is a win or draw
     * @return
     */
    public int updateState() {
        int i = checkRow(0) + checkRow(1) + checkRow(2) + checkCol(0) + checkCol(1) + checkCol(2) + checkDiagonal();    //all methods return value greater than 0 to determine if there is a winner
        if (i != 0) {
            this.state = i;
        } else {
            this.state = checkDraw();
        }
         return this.state;
    }

    /**
     * Determine if the row user entered all have the same states
     * @param rowNum user determined row number
     * @return 0 if not all values are equal
     */
    public int checkRow(int rowNum) {
        if (blocks[rowNum][0].getState() == blocks[rowNum][1].getState()
                && blocks[rowNum][1].getState() == blocks[rowNum][2].getState()
                && blocks[rowNum][2].getState() == blocks[rowNum][0].getState()) {
            return blocks[rowNum][0].getState();
        } else {
            return 0;
        }
    }

    /**
     * determine if the column user entered all have the same states
     * @param colNum user entered column
     * @return o if not all values are equal
     */
    public int checkCol(int colNum) {
        if (blocks[0][colNum].getState() == blocks[1][colNum].getState()
                && blocks[1][colNum].getState() == blocks[2][colNum].getState()
                && blocks[2][colNum].getState() == blocks[0][colNum].getState()) {
            return blocks[0][colNum].getState();
        } else {
            return 0;
        }
    }

    /**
     * checks if both diagonals on the board have the same state
     * @return 0 if neither diogonals have the same states
     */
    public int checkDiagonal() {
        if (blocks[0][0].getState() == blocks[1][1].getState() && blocks[0][0].getState() == blocks[2][2].getState()
                && blocks[1][1].getState() == blocks[2][2].getState()) {
            return blocks[0][0].getState();
        } else if (blocks[2][0].getState() == blocks[1][1].getState()
                && blocks[2][0].getState() == blocks[0][2].getState()
                && blocks[1][1].getState() == blocks[0][2].getState()) {
            return blocks[2][0].getState();
        } else {
            return 0;
        }

    }

    /**
     * If there is not a valid return in all row and column checks return a value greater than 0
     * @return 0 or 1 to determine weather a draw happens
     */
    public int checkDraw() {
        for (int i = 0; i < 3; i++) {
            if (checkRow(i) + checkCol(i) + checkDiagonal() == 0) {
                return 0;
            }
        }
        return 1;
    }

    /**
     * All user option when entered and filling it in the concurring cell in the board and determineing whether its valid
     * @param position 0-9 as shown by the display method
     * @param symbol either X or O
     * @return true or false based on whether the move is valid
     */
    public boolean makeMove(int position, int symbol) {
        int x, y;

        switch (position) {
            case 0:
                x = 0;
                y = 0;
                break;
            case 1:
                x = 1;
                y = 0;
                break;
            case 2:
                x = 2;
                y = 0;
                break;
            case 3:
                x = 0;
                y = 1;
                break;
            case 4:
                x = 1;
                y = 1;
                break;
            case 5:
                x = 2;
                y = 1;
                break;
            case 6:
                x = 0;
                y = 2;
                break;
            case 7:
                x = 1;
                y = 2;
                break;
            case 8:
                x = 2;
                y = 2;
                break;
            default:
                x = -1;
                y = -1;
        }

        if (x == -1 && y == -1) {
            return false;
        }

        if (blocks[y][x].getState() == 0) {
            blocks[y][x].setState(symbol);
            return true;
        } else {
            return false;
        }
    }
}
