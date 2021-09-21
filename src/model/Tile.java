package model;


public class Tile {

    private int value;
    private boolean active;
    private boolean merged;

    public Tile(int value) {
        this.value = value;
        this.active = value != 0;
        this.merged = false;
    }

    public Tile() {
        this(0);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isMerged() {
        return merged;
    }

    public void setMerged(boolean hasMerged) {
        this.merged = hasMerged;
    }

    public boolean canMergeWith(Tile t) {
        return (value == t.getValue() && (!(merged || t.isMerged())));
    }

    public void mergeInto(Tile t) {
        t.setValue(getValue() + t.getValue());
        t.setMerged(true);
        setValue(0);
        setActive(false);
    }

    public void swapWith(Tile t) {
        int initVal = t.getValue();
        boolean initActive = t.isActive();
        t.setValue(getValue());
        t.setActive(isActive());
        setValue(initVal);
        setActive(initActive);
    }
}
