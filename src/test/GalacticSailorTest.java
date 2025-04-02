package test;

import game.*;
import commands.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the functionality of the game.GalacticSailor class.
 */
public class GalacticSailorTest {

    private GalacticSailor player;
    private CrystalBag crystalBag;
    private BaseStation baseStation;
    private Location playerLocation;
    private Astrokoala astroKoala;
    private Comet comet;
    private PlanetGateKeeper pgk;
    private BigBang bigbang;

    /**
     * Initializes objects before each test.
     */
    @BeforeEach
    void init() {
        Planet station = new Planet("Station");

        crystalBag = new game.CrystalBag();
        baseStation = new BaseStation(station);
        playerLocation = new Location(new Planet("Station"));
        astroKoala = new Astrokoala();
        comet = new Comet(baseStation);
        pgk = new PlanetGateKeeper();
        bigbang = new BigBang(comet);
        player = new GalacticSailor(crystalBag, baseStation, playerLocation, astroKoala, bigbang, comet, pgk);
    }

    /**
     * Tests whether the usePrompter() method returns a valid hint.
     */
    @Test
    void usePrompter() {
        String hint = player.usePrompter();
        assertNotNull(hint);
        assertTrue(hint.contains("hint"));
    }

    /**
     * Tests whether the player can correctly change their location.
     */
    @Test
    void playerMovement() {
        Location newLocation = new Location(new Planet("Colverde"));
        player.moveTo(newLocation);
        Assertions.assertEquals(newLocation, player.getLocation());
    }

    /**
     * Verifies that the isAtBaseStation() method correctly detects when the player is at the base station.
     */
    @Test
    void isAtBaseStationTest() {
        Planet baseStationPlanet = baseStation.getPlanet();
        player.setPlayerLocation(new Location(baseStationPlanet));

        boolean isAtBaseStation = player.isAtBaseStation();
        assertTrue(isAtBaseStation, "Player should be at the Base Station");
    }
}
