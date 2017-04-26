package Life;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {

    private final static int TILE_SIZE = 10;
    private final static int BOARD_SIZE = 50;


    private Cell[][] grid;

    public Board (Life parent) {
        initBoard();
    }

    private void initBoard() {

        setFocusable(true);
        setBackground(Color.WHITE);

        createGrid();
        setBasicShape();

        Timer timer = new Timer(400, this);
        timer.start();

    }

    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < BOARD_SIZE; i++) {
            for(int j = 0 ; j < BOARD_SIZE; j++) {
                if (grid[j][i].getState()) {
                    g.fillRect(2 + i * (TILE_SIZE + 2), 2 + j * (TILE_SIZE + 2), TILE_SIZE, TILE_SIZE);
                }
            }
        }
    }

    private void setBasicShape() {
        grid[25][24].setState();
        grid[25][25].setState();
        grid[25][26].setState();
    }

    public void actionPerformed(ActionEvent e) {
        updateGrid();
        repaint();
    }

    private void createGrid() {
        grid = new Cell[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    private void updateGrid() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                grid[j][i].getNextState(grid, j, i);
            }
        }
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                grid[j][i].update();
            }
        }

    }


}


