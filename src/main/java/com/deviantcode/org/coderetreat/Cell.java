package com.deviantcode.org.coderetreat;

class Cell {
    private boolean alive;
    private int neighborCount;

    Cell(boolean alive) {
        this.alive = alive;
    }

    boolean isAlive() {
        return alive;
    }

    void setNeighbors(int neighborCount) {
        this.neighborCount = neighborCount;
    }

    int getNeighborCount() {
        return neighborCount;
    }

    void tick() {
        alive = (alive && neighborCount == 2) || neighborCount == 3;
    }
}
