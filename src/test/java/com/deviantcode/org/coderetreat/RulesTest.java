package com.deviantcode.org.coderetreat;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class RulesTest {

    @Test
    public void anyLiveCellWithFewerThanTwoLiveNeighborsDies() {
        for (int neighborCount = 0; neighborCount < 2; neighborCount++) {
            runTestsOnLivingCellThatDies(neighborCount);
        }
    }

    @Test
    public void anyLiveCellWithMoreThanThreeLiveNeighborsDies() {
        for (int neighborCount = 4; neighborCount < 9; neighborCount++) {
            runTestsOnLivingCellThatDies(neighborCount);
        }
    }

    @Test
    public void anyLiveCellWithTwoOrThreeLiveNeighborsLivesOnToTheNextGeneration() {
        for (int neighborCount = 2; neighborCount < 4; neighborCount++) {
            runTestsOnLivingCellThatLives(neighborCount);
        }
    }

    @Test
    public void anyDeadCellWithExactlyThreeLiveNeighborsBecomesALiveCell() {
        final int neighborCount = 3;
        runTestsOnDeadCellThatComesToLife(neighborCount);
    }

    @Test
    public void anyDeadCellWithFewerThanOrGreaterThanThreeLiveNeighborsStaysDead() {
        final int[] neighborCounts = { 0, 1, 2, 4, 5, 6, 7, 8 };
        for (int neighborCount : neighborCounts) {
            runTestsOnDeadCellThatStaysDead(neighborCount);
        }
    }

    private void runTestsOnDeadCellThatStaysDead(int neighborCount) {
        Cell cell = initializeCell(neighborCount, false);
        assertFalse(cell.isAlive(), "Expected a dead cell with " + neighborCount + " neighbors to stay dead");
    }

    private void runTestsOnDeadCellThatComesToLife(int neighborCount) {
        Cell cell = initializeCell(neighborCount, false);
        assertTrue(cell.isAlive(), "Expected a dead cell with " + neighborCount + " neighbors to come to life");
    }

    private void runTestsOnLivingCellThatLives(int neighborCount) {
        Cell cell = initializeCell(neighborCount, true);
        assertTrue(cell.isAlive(), "Expected a living cell with " + neighborCount + " neighbors to stay alive");
    }

    private void runTestsOnLivingCellThatDies(int neighborCount) {
        Cell cell = initializeCell(neighborCount, true);
        assertFalse(cell.isAlive(), "Expected a living cell with " + neighborCount + " neighbors to end up dead due to underpopulation");
    }

    private Cell initializeCell(int neighborCount, boolean isAlive) {
        Cell cell = new Cell(isAlive);
        assertEquals(cell.isAlive(), isAlive, "Expected a cell to be alive? " + isAlive);
        cell.setNeighbors(neighborCount);
        assertEquals(cell.getNeighborCount(), neighborCount, "Expected " + neighborCount + " living neighbor(s)");
        cell.tick();
        return cell;
    }

}
