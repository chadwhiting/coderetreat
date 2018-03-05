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

    private void runTestsOnDeadCellThatComesToLife(int neighborCount) {
        Cell cell = initializeCell(neighborCount, false);
        assertTrue(cell.isAlive(), "Expected a cell to end up dead due to underpopulation");
    }

    private void runTestsOnLivingCellThatLives(int neighborCount) {
        Cell cell = initializeCell(neighborCount, true);
        assertTrue(cell.isAlive(), "Expected a cell to end up dead due to underpopulation");
    }

    private void runTestsOnLivingCellThatDies(int neighborCount) {
        Cell cell = initializeCell(neighborCount, true);
        assertFalse(cell.isAlive(), "Expected a cell to end up dead due to underpopulation");
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
