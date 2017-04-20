import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel implements ActionListener{

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
    public void actionPerformed(ActionEvent e) {

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
        }
    }

}
