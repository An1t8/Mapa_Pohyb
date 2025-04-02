package test;

import commands.Comet;
import game.BaseStation;
import game.Planet;
import game.Crystal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for verifying the functionality of the commands.Comet class.
 */
public class CometTest {

    private Comet comet;
    private BaseStation baseStation;

    /**
     * Initializes objects before each test.
     */
    @BeforeEach
    void init() {
        Planet station = new Planet("Station");
        baseStation = new BaseStation(station);
        comet = new Comet(baseStation);
    }

    /**
     * Tests whether the comet correctly detects when it is full.
     */
    @Test
    void cometsFull() {
        Assertions.assertFalse(comet.areBothCometsFull(), "Comets should be empty initially");

        baseStation.getPlacedCrystals().add(new Crystal("Ruby"));
        baseStation.getPlacedCrystals().add(new game.Crystal("Emerald"));

        comet.addCrystal("Ruby");
        Assertions.assertFalse(comet.areBothCometsFull(), "Comets should not be full after adding just one crystal");

        comet.addCrystal("Emerald");
        Assertions.assertTrue(comet.areBothCometsFull(), "Comets should be full after adding two crystals");
    }
}
