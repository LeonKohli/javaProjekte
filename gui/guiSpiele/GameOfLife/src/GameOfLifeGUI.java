import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSlider;

public class GameOfLifeGUI extends JFrame {
    private final GameOfLife game;
    private boolean running = false; // whether the game is running
    private final JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 1000, 100); // slider to control the speed of the

    // Add ActionListener to the men

    public GameOfLifeGUI(final GameOfLife game) {
        this.game = game;

        setTitle("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

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

        // Add a button for starting and stopping the simulation
        final JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            if (!running) {
                running = true;
                startButton.setText("Stop");
                new Thread(() -> {
                    while (running) {
                        game.step();
                        panel.repaint();
                        try {
                            Thread.sleep(slider.getValue());
                        } catch (final InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }).start();
            } else {
                running = false;
                startButton.setText("Start");
                Thread.currentThread().interrupt();
            }
        });
        add(startButton, BorderLayout.SOUTH);
        add(slider, BorderLayout.NORTH);

        pack();
        setVisible(true);

    }

    // Draw the game grid
    private void drawGameGrid(final Graphics g) { // Draw the game grid
        final int width = game.getWidth(); // Get the width of the game grid
        final int height = game.getHeight(); // Get the height of the game grid

        g.setColor(Color.WHITE); // Set the color of the background
        g.fillRect(0, 0, width * 10, height * 10); // Draw the background

        g.setColor(Color.BLACK); // Set the color of the cells
        for (int i = 0; i <= width; i++) { // für jede Spalte der Zeichenfläche
            g.drawLine(i * 10, 0, i * 10, height * 10); // zeichne eine vertikale Linie
        }
        for (int i = 0; i <= height; i++) { // für jede Zeile der Zeichenfläche
            g.drawLine(0, i * 10, width * 10, i * 10); // zeichne eine horizontale Linie
        }

        g.setColor(Color.BLUE); // Set the color of the cells
        for (int i = 0; i < width; i++) { // für jede Spalte der Zeichenfläche
            for (int j = 0; j < height; j++) { // für jede Zeile der Zeichenfläche
                if (game.getCell(i, j)) { // wenn die Zelle lebt
                    g.fillRect(i * 10, j * 10, 10, 10); // zeichne eine schwarze Zelle
                }
            }
        }
    }

    public static void main(final String[] args) { // Create a new GameOfLife instance
        final GameOfLife game = new GameOfLife(); // Create a new GameOfLifeGUI instance
        new GameOfLifeGUI(game); // Start the game by calling the run method
    }
}
