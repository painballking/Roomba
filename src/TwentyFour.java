import javax.swing.*;

public class TwentyFour extends JFrame {

    public TwentyFour() {
        initUI();
    }

    private void initUI() {

        Board board = new Board(this);
        add(board);

        setSize(50, 50);
        setTitle("2048");
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
