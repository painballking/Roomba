import javax.swing.*;
import java.awt.*;

public class TwentyFour extends JFrame {

    public TwentyFour() {
        initUI();
    }

    private void initUI() {

        Board board = new Board(this);
        add(board);

        setSize(211, 234);
        setTitle("2048");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

                TwentyFour game = new TwentyFour();
                game.setVisible(true);
        });
    }
}
