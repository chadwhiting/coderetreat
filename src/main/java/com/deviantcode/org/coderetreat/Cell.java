package com.deviantcode.org.coderetreat;

public class Cell {
    private boolean alive = true;
    private int neighborCount;

    public Cell(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive || neighborCount == 2 || neighborCount == 3;
    }

    public void setNeighbors(int neighborCount) {
        this.neighborCount = neighborCount;
    }

    public int getNeighborCount() {
        return neighborCount;
    }

    public void tick() {
        alive = !alive;
    }
}
