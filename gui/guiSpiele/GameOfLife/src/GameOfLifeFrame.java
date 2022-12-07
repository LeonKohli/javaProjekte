
import javax.swing.JFrame;
import java.awt.event.*;

public class GameOfLifeFrame extends JFrame implements Runnable, MouseListener {
    GameOfLife game;
    // Variables for the size of the window
    int width = 500;
    int height = 500;

    public GameOfLifeFrame() {
        // Set the size and title of the window
        setSize(width, height);
        setTitle("Game of Life");

        // Create a GameOfLife instance and store it in the game field
        game = new GameOfLife();

        // Create a panel for drawing the game
        GameOfLifePanel panel = new GameOfLifePanel();
        add(panel);

        // Show the window
        setVisible(true);

        // Add a mouse listener to the panel
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Get the x and y position of the mouse click
        int x = e.getX();
        int y = e.getY();

        // Set the Value of x in the grid array at the position of the mouse click
        game.grid[x / 10][y / 10] = true;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // not used
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // not used
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // not used
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // not used
    }

    public void run() {
        // Main game loop
        while (true) {
            // Apply the rules of the game and update the state of the grid
            game.berechneNeueGeneration();
            game.updateGrid();

            // Repaint the panel to show the updated grid
            repaint();

            // Sleep for a short time to slow down the game
            // try {
            // Thread.sleep(100);
            // } catch (InterruptedException e) {
            // e.printStackTrace();
            // }
        }
    }
}
