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

    private void runTestsOnLivingCellThatDies(int neighborCount) {
        Cell cell = new Cell();
        assertTrue(cell.isAlive(), "Expected a cell to start out alive");
        cell.setNeighbors(neighborCount);
        assertEquals(cell.getNeighborCount(), neighborCount, "Expected " + neighborCount + " living neighbor(s)");
        cell.tick();
        assertFalse(cell.isAlive(), "Expected a cell to end up dead due to underpopulation");
    }

}
