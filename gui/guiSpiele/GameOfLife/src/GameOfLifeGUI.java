import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameOfLifeGUI extends JFrame {
    private final GameOfLife game;

    public GameOfLifeGUI(final GameOfLife game) {
        this.game = game;

        setTitle("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Add a panel for drawing the game grid
        final JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(final Graphics g) {
                super.paintComponent(g);
                drawGameGrid(g);
            }
        };
        panel.setPreferredSize(new Dimension(500, 500));
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent e) {
                // Get the x and y position of the mouse click
                final int x = e.getX() / 10;
                final int y = e.getY() / 10;
                game.setCell(x, y, !game.getCell(x, y));
                panel.repaint();
            }
        });
        add(panel);

        // Add a button for advancing the simulation one step
        final JButton stepButton = new JButton("Step");
        stepButton.addActionListener(e -> {
            game.step();
            panel.repaint();
        });
        add(stepButton, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    // Draw the game grid
    private void drawGameGrid(final Graphics g) {
        final int width = game.getWidth();
        final int height = game.getHeight();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width * 10, height * 10);

        g.setColor(Color.BLACK);
        for (int i = 0; i <= width; i++) {
            g.drawLine(i * 10, 0, i * 10, height * 10);
        }
        for (int i = 0; i <= height; i++) {
            g.drawLine(0, i * 10, width * 10, i * 10);
        }

        g.setColor(Color.BLUE);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (game.getCell(i, j)) {
                    g.fillRect(i * 10, j * 10, 10, 10);
                }
            }
        }
    }

    public static void main(final String[] args) {
        final GameOfLife game = new GameOfLife();
        new GameOfLifeGUI(game);
    }
}
