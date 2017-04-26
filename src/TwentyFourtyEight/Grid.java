package TwentyFourtyEight;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private boolean moveHappened;
    private int topNum;

    protected enum Move {
        LEFT, RIGHT, UP, DOWN
    }

    public int[][] grid;

    public Grid() {
        topNum = 2;
        grid = new int[4][4];
        for (int i = 0; i < 2; i++) {
            grid[(int) (Math.random() * 4)][(int) (Math.random() * 4)] = 2;
        }
    }

    public void moveLeft() { move(Move.LEFT); }

    public void moveRight() { move(Move.RIGHT); }

    public void moveUp() { move(Move.UP); }

    public void moveDown() { move(Move.DOWN); }

    private void move(Move direction) {

        rotate(direction);
        collapse();

        if (direction == Move.UP) {
            rotate(Move.DOWN);
        } else if (direction == Move.DOWN) {
            rotate(Move.UP);
        } else if (direction == Move.RIGHT) {
            rotate(Move.RIGHT);
        }

        if (moveHappened) addNum();
        moveHappened = false;
    }

    private void rotate(Move direction){
        int[][] temp = new int[4][4];
        for (int i = 0; i < 4; i++) {
            temp[i] = grid[i].clone();
        }

        switch(direction){

            case UP:
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        grid[3 - j][i] = temp[i][j];
                    }
                }
                break;

            case DOWN:
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        grid[j][3 - i] = temp[i][j];
                    }
                }
                break;

            case RIGHT:
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        grid[i][3 - j] = temp[i][j];
                    }
                }
                break;

            default:
                break;
        }
    }

    private void collapse(){
        for (int i = 0; i < 4; i++) {

            int placePointer = 0;
            int lastValIndex = -1;

            for (int j = 0; j < 4; j++) {

                if (grid[i][j] != 0) {
                    if (lastValIndex < 0) {
                        lastValIndex = j;
                    } else {
                        if (grid[i][j] == grid[i][lastValIndex]) {
                            grid[i][placePointer] = grid[i][j] * 2;
                            if (grid[i][placePointer] > topNum) topNum = grid[i][placePointer];
                            grid[i][j] = 0;
                        } else {
                            grid[i][placePointer] = grid[i][lastValIndex];
                        }
                        if (placePointer != lastValIndex) grid[i][lastValIndex] = 0;
                        if (grid[i][j] == 0) {
                            moveHappened = true;
                            lastValIndex = -1;
                        } else {
                            lastValIndex = j;
                        }
                        placePointer++;

                    }
                }
            }
            if (lastValIndex > 0){
                grid[i][placePointer] = grid[i][lastValIndex];
                if (placePointer != lastValIndex) grid[i][lastValIndex] = 0;
                moveHappened = true;
            }
        }
    }

    private void addNum() {
        List<Integer> placeable = getPlaceable();
        int spot = placeable.get((int) (Math.random() * placeable.size()));
        int num = twoOrFour();
        if (num > topNum) topNum = num;
        grid[spot / 4][spot % 4] = num;
    }

    private int twoOrFour(){
        return Math.random() < .8 ? 2 : 4;
    }

    private List<Integer> getPlaceable() {
        List<Integer> placeable = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j] == 0) {
                    placeable.add((i * 4) + j);
                }
            }
        }
        return placeable;
    }

    public void printGrid() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public float getTopNum() { return (float) topNum; }

}
