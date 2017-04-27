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
    private Timer timer;

    public Board () {
        initBoard();
    }

    private void initBoard() {

        setFocusable(true);
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(BORDER + TILE_SIZE * BOARD_SIZE + TILE_GAP * (BOARD_SIZE - 1) - TILE_SIZE / 2 - 1,
                BORDER + TILE_SIZE * BOARD_SIZE + TILE_GAP * (BOARD_SIZE - 1) - TILE_SIZE / 2 - 1
        ));
        addKeyListener(new TAdapter());
        addMouseListener(new Mouse());

        createGrid();
        setBasicShape();

        timer = new Timer(400, this);
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
        grid[BOARD_SIZE/2][BOARD_SIZE/2 - 1].setState(true);
        grid[BOARD_SIZE/2][BOARD_SIZE/2].setState(true);
        grid[BOARD_SIZE/2][BOARD_SIZE/2 + 1].setState(true);
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

    private void switchTimer(){
        if (timer.isRunning()) {
            timer.stop();
        } else {
            timer.start();
        }
    }

    class Mouse extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            Cell cell = grid[(e.getX() - 2) / (TILE_GAP + TILE_SIZE)][(e.getY() - 2) / (TILE_GAP + TILE_SIZE )];
            cell.swapState();

            repaint();
        }
    }

    class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int keycode = e.getKeyCode();
            if (keycode == KeyEvent.VK_SPACE) {
                switchTimer();
            }
        }
    }

}


