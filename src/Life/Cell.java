package Life;

public class Cell {

    private static final int BOARD_SIZE = 50;

    private boolean state;
    private boolean nextState;

    public Cell() {
        state = false;
    }

    public void getNextState(Cell[][] field, int x, int y) {
        int n = ( ((y - 1 >= 0) && field[y-1][x].getState()) ? 1 : 0 ) +
                ( ((y + 1 < BOARD_SIZE) && field[y+1][x].getState()) ? 1 : 0 ) +
                ( ((x - 1 >= 0) && field[y][x-1].getState()) ? 1 : 0 ) +
                ( ((x + 1 < BOARD_SIZE) && field[y][x+1].getState()) ? 1 : 0 ) +
                ( ((y - 1 >= 0) && (x - 1 >= 0) && field[y-1][x-1].getState()) ? 1 : 0 ) +
                ( ((y - 1 >= 0) && (x + 1 < BOARD_SIZE) && field[y-1][x+1].getState()) ? 1 : 0 ) +
                ( ((y + 1 < BOARD_SIZE) && (x - 1 >= 0) && field[y+1][x-1].getState()) ? 1 : 0 ) +
                ( ((y + 1 < BOARD_SIZE) && (x + 1 < BOARD_SIZE) && field[y+1][x+1].getState()) ? 1 : 0 );

        if (state) {
            if (n < 2 || n > 3) {
                nextState = false;
            } else {
                nextState = true;
            }
        } else if (n == 3) {
            nextState = true;
        }
    }

    public void update() {
        state = nextState;
    }

    public void setState() {state = true;}
    public boolean getState() { return state; }

}
