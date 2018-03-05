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

    private void runTestsOnLivingCellThatLives(int neighborCount) {
        Cell cell = initializeCell(neighborCount);
        assertTrue(cell.isAlive(), "Expected a cell to end up dead due to underpopulation");
    }

    private void runTestsOnLivingCellThatDies(int neighborCount) {
        Cell cell = initializeCell(neighborCount);
        assertFalse(cell.isAlive(), "Expected a cell to end up dead due to underpopulation");
    }

    private Cell initializeCell(int neighborCount) {
        Cell cell = new Cell();
        assertTrue(cell.isAlive(), "Expected a cell to start out alive");
        cell.setNeighbors(neighborCount);
        assertEquals(cell.getNeighborCount(), neighborCount, "Expected " + neighborCount + " living neighbor(s)");
        cell.tick();
        return cell;
    }

}
