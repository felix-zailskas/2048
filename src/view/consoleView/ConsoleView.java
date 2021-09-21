package view.consoleView;

import controller.ShiftKeyListener;
import model.Game;
import model.Tile;
import util.observer.Listener;

import java.util.ArrayList;

public class ConsoleView implements Listener {

    private Game game;

    public ConsoleView(Game game) {
        this.game = game;
        game.addObserver(this);
    }

    private void display() {
        Tile[][] tiles = game.getGrid().getTiles();
        int size = game.getGrid().getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(tiles[i][j].getValue());
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void handleUpdate() {
        display();
    }
}
