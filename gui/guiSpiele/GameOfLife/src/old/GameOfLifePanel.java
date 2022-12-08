import javax.swing.*;
import java.awt.*;

public class GameOfLifePanel extends JPanel {
    GameOfLife game;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set the color of the cells
        g.setColor(Color.BLACK);

        // Draw the cells
        for (int i = 0; i < game.x; i++) {
            for (int j = 0; j < game.y; j++) {
                if (game.grid[i][j]) {
                    g.fillRect(i * 10, j * 10, 10, 10);
                }
            }
        }
    }
}