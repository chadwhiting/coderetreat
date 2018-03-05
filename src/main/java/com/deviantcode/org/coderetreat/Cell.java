package com.deviantcode.org.coderetreat;

public class Cell {
    private boolean alive = true;
    private int neighborCount;

    public boolean isAlive() {
        return alive;
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
