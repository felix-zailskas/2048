package model;

import util.game.Direction;
import util.observer.Observed;

import java.util.ArrayList;
import java.util.Random;

public class Game extends Observed {

    private Grid grid;
    private int score;

    public Game(int size) {
        this.listeners = new ArrayList<>();
        this.grid = new Grid(size);
        this.score = 0;
    }

    public Game() {
        this(4);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Grid getGrid() {
        return grid;
    }

    private void resetTiles() {
        int size = grid.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid.getTiles()[i][j].setMerged(false);
            }
        }
    }

    public void shiftTiles(Direction dir) {
        switch (dir) {
            case UP:
                grid.shiftUp();
                break;
            case DOWN:
                grid.shiftDown();
                break;
            case LEFT:
                grid.shiftLeft();
                break;
            case RIGHT:
                grid.shiftRight();
                break;
        }
        resetTiles();
        try {
            spawnTile();
        } catch (IllegalArgumentException e) {
            gameOver();
        }
        notifyListeners();
    }

    private void gameOver() {
        System.out.println("GAME OVER!");
    }

    public void spawnTile() throws IllegalArgumentException {
        Random rand = new Random();
        int tileVal = rand.nextInt(100) < 30 ? 4 : 2;
        // get all empty tiles
        ArrayList<Tile> emptyTiles = new ArrayList();
        for (int i = 0; i < grid.getSize(); i++) {
            for (int j = 0; j < grid.getSize(); j++) {
                Tile currTile = grid.getTiles()[i][j];
                if (!currTile.isActive()) emptyTiles.add(currTile);
            }
        }
        int tileIdx = rand.nextInt(emptyTiles.size());
        emptyTiles.get(tileIdx).setValue(tileVal);
        emptyTiles.get(tileIdx).setActive(true);
    }

    public void spawnTile(int value, int row, int col) {
        grid.getTiles()[row][col].setValue(value);
        grid.getTiles()[row][col].setActive(value != 0);
        notifyListeners();
    }
}
