package com.deviantcode.org.coderetreat;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class WorldTest {

    @Test
    public void anEmptyWorldStaysEmptyAfterATick() {
        final World world = new World();
        assertTrue(world.isEmpty(), "An empty world should start out empty");
        world.tick();
        assertTrue(world.isEmpty(), "An empty world should still be empty after a tick");
    }

}
