package model;


public class Grid {

    private final int size;
    private Tile[][] tiles;

    public Grid(int size) {
        this.size = size;
        tiles = new Tile[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tiles[i][j] = new Tile();
            }
        }
    }

    public int getSize() {
        return size;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void shiftRight() {
        Tile currTile;
        Tile nextTile;
        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j >= 0; j--) {
                currTile = tiles[i][j];
                if (!currTile.isActive()) continue;
                int nextTileIdx = j + 1;
                while (nextTileIdx < size) {
                    nextTile = tiles[i][nextTileIdx++];
                    if (!nextTile.isActive()) {
                        currTile.swapWith(nextTile);
                    }
                    if (currTile.canMergeWith(nextTile)) {
                        currTile.mergeInto(nextTile);
                        break;
                    }
                    currTile = nextTile;
                }
            }
        }
    }

    public void shiftLeft() {
        Tile currTile;
        Tile nextTile;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                currTile = tiles[i][j];
                if (!currTile.isActive()) continue;
                int nextTileIdx = j - 1;
                while (nextTileIdx >= 0) {
                    nextTile = tiles[i][nextTileIdx--];
                    if (!nextTile.isActive()) {
                        currTile.swapWith(nextTile);
                    }
                    if (currTile.canMergeWith(nextTile)) {
                        currTile.mergeInto(nextTile);
                        break;
                    }
                    currTile = nextTile;
                }
            }
        }
    }

    public void shiftUp() {
        Tile currTile;
        Tile nextTile;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                currTile = tiles[j][i];
                if (!currTile.isActive()) continue;
                int nextTileIdx = j - 1;
                while (nextTileIdx >= 0) {
                    nextTile = tiles[nextTileIdx--][i];
                    if (!nextTile.isActive()) {
                        currTile.swapWith(nextTile);
                    }
                    if (currTile.canMergeWith(nextTile)) {
                        currTile.mergeInto(nextTile);
                        break;
                    }
                    currTile = nextTile;
                }
            }
        }
    }

    public void shiftDown() {
        Tile currTile;
        Tile nextTile;
        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j >= 0; j--) {
                currTile = tiles[j][i];
                if (!currTile.isActive()) continue;
                int nextTileIdx = j + 1;
                while (nextTileIdx < size) {
                    nextTile = tiles[nextTileIdx++][i];
                    if (!nextTile.isActive()) {
                        currTile.swapWith(nextTile);
                    }
                    if (currTile.canMergeWith(nextTile)) {
                        currTile.mergeInto(nextTile);
                        break;
                    }
                    currTile = nextTile;
                }
            }
        }
    }
}
