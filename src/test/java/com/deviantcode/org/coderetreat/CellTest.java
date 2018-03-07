package com.deviantcode.org.coderetreat;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CellTest {

    @Test
    public void aCellCanBeAlive() {
        final boolean alive = true;
        final Cell cell = new Cell(alive);
        assertTrue(cell.isAlive(), "Expected a cell to be alive");
    }

    @Test
    public void aCellCanBeDead() {
        final boolean alive = false;
        final Cell cell = new Cell(alive);
        assertFalse(cell.isAlive(), "Expected a cell to be dead");
    }
}
