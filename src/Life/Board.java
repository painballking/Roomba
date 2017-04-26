package Life;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {

    private final static int TILE_SIZE = 15;
    private final static int BOARD_SIZE = 20;
    private final static int BORDER = 2;
    private final static int TILE_GAP = 2;


    private Cell[][] grid;

    public Board (Life parent) {
        initBoard();
    }

    private void initBoard() {

        setFocusable(true);
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(BORDER + TILE_SIZE * BOARD_SIZE + TILE_GAP * (BOARD_SIZE - 1) + BORDER,
                BORDER + TILE_SIZE * BOARD_SIZE + TILE_GAP * (BOARD_SIZE - 1) + BORDER
        ));

        createGrid();
        setBasicShape();

        Timer timer = new Timer(700, this);
        timer.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < BOARD_SIZE; i++) {
            for(int j = 0 ; j < BOARD_SIZE; j++) {

                if (grid[i][j].getState()) g.setColor(Color.black);
                else g.setColor(Color.white);

                g.fillRect(BORDER + i * (TILE_SIZE + TILE_GAP), BORDER + j * (TILE_SIZE + TILE_GAP), TILE_SIZE, TILE_SIZE);
            }
        }
    }

    private void setBasicShape() {
        grid[BOARD_SIZE/2][BOARD_SIZE/2 - 1].setState();
        grid[BOARD_SIZE/2][BOARD_SIZE/2].setState();
        grid[BOARD_SIZE/2][BOARD_SIZE/2 + 1].setState();
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


