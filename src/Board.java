import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel{

    private static final int SQUARE_SIZE = 40;

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

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                g.setColor(Color.LIGHT_GRAY);
                drawSquare(g, 45 * i + 15, 45 * j + 15);

                g.setColor(Color.BLACK);
                drawCenteredNum(g, grid.grid[j][i], 45 * i + 15, 45 * j + 15, g.getFont());
            }
        }
    }

    private void drawCenteredNum(Graphics g, int num, int x, int y, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);

        x += (SQUARE_SIZE - metrics.stringWidth(Integer.toString(num))) / 2;
        y += (SQUARE_SIZE - metrics.getHeight()) / 2 + metrics.getAscent();

        g.setFont(font);
        g.drawString(Integer.toString(num), x, y);
    }

    private void drawSquare(Graphics g, int x, int y) {
        g.fillRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
    }

    class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int keycode = e.getKeyCode();

            switch (keycode) {

                case KeyEvent.VK_LEFT:
                    System.out.println("Left");
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
