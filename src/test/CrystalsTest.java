package test;

import static org.junit.jupiter.api.Assertions.*;

import game.BaseStation;
import game.Crystal;
import game.*;
import commands.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Test class for verifying the functionality of crystal collection and placement.
 */
public class CrystalsTest {

    private GalacticSailor player;
    private game.CrystalBag crystalBag;
    private BaseStation baseStation;
    private Location playerLocation;
    private Astrokoala astroKoala;
    private Comet comet;
    private PlanetGateKeeper pgk;
    private BigBang bigbang;
    private CheckCrystals checkCrystals;
    private Crystal crystal;


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
        crystal = new game.Crystal("Colverde");
        player = new GalacticSailor(crystalBag, baseStation, playerLocation, astroKoala, bigbang, comet, pgk);

        checkCrystals = new CheckCrystals(astroKoala, player, baseStation, comet);
    }

    /**
     * Tests whether there's enough crystals in the comets
     * plus if the player is at base station
     */
    @Test
    void checkCrystals() {
        CheckCrystals checkCrystals = new CheckCrystals(astroKoala, player, baseStation, comet);

        Planet baseStationPlanet = baseStation.getPlanet();
        System.out.println("Base Station: " + (baseStationPlanet != null ? baseStationPlanet.getName() : "null"));

        player.setPlayerLocation(new Location(baseStationPlanet));

        System.out.println("Player game.Location: " + player.getPlayerLocation().getCurrentLocation());
        System.out.println("Base Station game.Location: " + baseStation.getPlanet().getName());

        boolean isAtBaseStation = player.isAtBaseStation();
        System.out.println("Is player at base station? " + isAtBaseStation);
        assertTrue(isAtBaseStation, "Player should be at the Base Station");

        baseStation.getPlacedCrystals().add(new game.Crystal("Rosetta"));
        baseStation.getPlacedCrystals().add(new Crystal("Lavatron"));

        System.out.println("Adding first crystal: Rosetta");
        comet.addCrystal("Rosetta");
        System.out.println("Are both comets full after first crystal? " + comet.areBothCometsFull());

        Assertions.assertFalse(comet.areBothCometsFull(), "Comets should not be full after adding just one crystal");

        System.out.println("Adding second crystal: Lavatron");
        comet.addCrystal("Lavatron");
        System.out.println("Are both comets full after second crystal? " + comet.areBothCometsFull());

        Assertions.assertTrue(comet.areBothCometsFull(), "Comets should be full after adding two crystals");

        String result = checkCrystals.execute();
        System.out.println("commands.Command result: " + result);
        assertEquals("Both comets are ready for the Big Bang!\nUse 'bigbang' to create Earth!", result);
    }

    /**
     * Tests the toString() method of the game.Crystal class.
     */
    @Test
    void testToString() {
        crystal.setName("Luminara");
        assertEquals("Crystal{name='Luminara'}", crystal.toString());
    }

}
