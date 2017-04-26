package Life;

public class Cell {

    private boolean state;
    private boolean nextState;
    private int neighbors;

    public Cell() {
        state = false;
        neighbors = 0;
    }

    public void updateNextState(Cell[][] field, int x, int y) {
        int n = (field[y-1][x].getState() ? 1 : 0) +
                (field[y+1][x].getState() ? 1 : 0) +
                (field[y][x-1].getState() ? 1 : 0) +
                (field[y][x+1].getState() ? 1 : 0);
    }

    public boolean getState() { return state; }

}
