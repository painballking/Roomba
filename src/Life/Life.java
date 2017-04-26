package Life;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Life extends JFrame {

    public Life() {
        initUI();
    }

    private void initUI() {

        Board board = new Board(this);
        add(board);
        pack();


        setTitle("Game of Life");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            Life game = new Life();
            game.setVisible(true);
        });
    }
}
