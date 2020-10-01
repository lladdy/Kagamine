package com.hjax.kagamine;

import junit.framework.TestCase;

/**
 * Runs matches on all the listed maps to ensure no issues.
 */
public class MapPoolTest extends TestCase {
    String[] mapPool = {"DeathAuraLE.SC2Map",
                        "EternalEmpireLE.SC2Map",
                        "EverDreamLE.SC2Map",
                        "GoldenWallLE.SC2Map",
                        "IceandChromeLE.SC2Map",
                        "PillarsofGoldLE.SC2Map",
                        "SubmarineLE.SC2Map"};

    public MapPoolTest() {
        super("Map pool test");
    }

    public void test() {
        // todo: this fails currently - probably due to Kaga/the API not being used to being reused.
        for (String map : this.mapPool) {
            // todo: detect errors
            System.out.println("Starting new game.");
            new TestMatchRunner().setMap(map).run();
        }
    }
}
