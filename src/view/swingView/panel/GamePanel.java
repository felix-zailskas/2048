package view.swingView.panel;

import controller.ShiftKeyListener;
import model.Game;
import model.Tile;
import util.observer.Listener;
import util.view.ColorCollection;


import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Listener {

    private Game game;
    private final int GRID_SIZE = 400;
    private final int TILE_SIZE = 100;

    public GamePanel(Game game) {
        super(new BorderLayout());
        this.game = game;
        setBackground(Color.GRAY);
        this.game.addObserver(this);
        this.setFocusable(true);
        new ShiftKeyListener(game, this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintGrid(g);
        paintTiles(g);
    }

    private void paintTiles(Graphics g) {
        g.setColor(Color.black);
        Tile[][] tiles = game.getGrid().getTiles();
        int size = game.getGrid().getSize();
        int xOff = (getWidth() - GRID_SIZE) / 2;
        int yOff = (getHeight() - GRID_SIZE) / 2;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (tiles[i][j].isActive()) {
                    int xRect = xOff + j * TILE_SIZE;
                    int yRect = yOff + i * TILE_SIZE;
                    int xNum = xRect + TILE_SIZE / 2;
                    int yNum = yRect + TILE_SIZE / 2;
                    g.setColor(ColorCollection.getColor(tiles[i][j].getValue()));
                    g.fillRect(xRect, yRect, TILE_SIZE, TILE_SIZE);
                    g.setColor(Color.black);
                    g.drawString(Integer.toString(tiles[i][j].getValue()), xNum, yNum);
                }
            }
        }
    }

    private void paintGrid(Graphics g) {
        g.setColor(Color.black);
        int xOff = (getWidth() - GRID_SIZE) / 2;
        int yOff = (getHeight() - GRID_SIZE) / 2;
        // draw 5 horizontal lines
        for (int i = 0; i < 5 * TILE_SIZE; i += TILE_SIZE) {
            g.drawLine(xOff, yOff + i, getWidth() - xOff, yOff + i);
        }
        // draw 5 vertical lines
        for (int i = 0; i < 5 * TILE_SIZE; i += TILE_SIZE) {
            g.drawLine(xOff + i, yOff, xOff + i, getHeight() - yOff);
        }
    }

    @Override
    public void handleUpdate() {
        repaint();
    }
}
