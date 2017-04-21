import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel{


    private Grid grid;

    public Board(TwentyFour parent) {

        initBoard(parent);
    }

    private void initBoard(TwentyFour parent) {

        setFocusable(true);

        grid = new Grid();
        addKeyListener(new TAdapter());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        String[] rows = getRows();
        for (int i = 0; i < 4; i++) {
            g.drawString(rows[i], 5, (i * 15 + 15));
        }
    }

    private String[] getRows() {
        String[] rows = new String[4];
        for (int i = 0; i < 4; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < 4; j++) {
                row.append(grid.grid[i][j] + " ");
            }
            rows[i] = row.toString();
        }
        return rows;
    }

    class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int keycode = e.getKeyCode();

            switch (keycode) {

                case KeyEvent.VK_LEFT:
                    grid.moveLeft();
                    break;
                case KeyEvent.VK_RIGHT:
                    grid.moveRight();
                    break;
                case KeyEvent.VK_UP:
                    grid.moveUp();
                    break;
                case KeyEvent.VK_DOWN:
                    grid.moveDown();
                    break;

            }

            repaint();
        }
    }

}
