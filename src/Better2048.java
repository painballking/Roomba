
public class Better2048 {

    enum Move {
        LEFT, RIGHT, UP, DOWN
    }

    public static void move(int[][] grid, Move direction) {

        rotate(grid, direction);
        collapse(grid);

        if (direction == Move.UP) {
            rotate(grid, Move.DOWN);
        } else if (direction == Move.DOWN) {
            rotate(grid, Move.UP);
        } else if (direction == Move.RIGHT) {
            rotate(grid, Move.RIGHT);
        }
    }

    public static void rotate(int[][] grid, Move direction){
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

    public static void collapse(int[][] grid){
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
                            grid[i][j] = 0;
                        } else {
                            grid[i][placePointer] = grid[i][lastValIndex];
                        }
                        if (placePointer != lastValIndex) grid[i][lastValIndex] = 0;
                        lastValIndex = (grid[i][j] == 0) ? -1 : j;
                        placePointer++;
                    }
                }
            }
            if (lastValIndex > 0){
                grid[i][placePointer] = grid[i][lastValIndex];
                if (placePointer != lastValIndex) grid[i][lastValIndex] = 0;
            }
        }
    }

    public static void printGrid(int[][] grid) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}