package Life;

import java.util.ArrayList;

public class Field {

    private boolean[][] grid;
    private ArrayList<Integer> liveCells;

    public Field() {
        grid = new boolean[100][100];
        liveCells = new ArrayList<>();
    }

}
