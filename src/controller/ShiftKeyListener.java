package controller;

import model.Game;
import util.game.Direction;
import view.swingView.panel.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ShiftKeyListener implements KeyListener {

    private Game game;
    private GamePanel gamePanel;

    public ShiftKeyListener(Game game, GamePanel gamePanel) {
        this.game = game;
        this.gamePanel = gamePanel;
        gamePanel.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                game.shiftTiles(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                game.shiftTiles(Direction.DOWN);
                break;
            case KeyEvent.VK_RIGHT:
                game.shiftTiles(Direction.RIGHT);
                break;
            case KeyEvent.VK_LEFT:
                game.shiftTiles(Direction.LEFT);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
