package Life;

import javax.swing.*;

public class Life extends JFrame {

    public Life() {
        initUI();
    }

    private void initUI() {

        Board board = new Board();
        Modifiers mod = new Modifiers();
        createLayout(board, mod);
        pack();

        setTitle("Game of Life");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void createLayout(JComponent... arg) {
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        for (int i = 0; i < arg.length; i++) {
            add(arg[i]);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            Life game = new Life();
            game.setVisible(true);
        });
    }
}
