import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrystalsTest {

    private GalacticSailor player;
    private CrystalBag crystalBag;
    private BaseStation baseStation;
    private Location playerLocation;
    private Astrokoala astroKoala;
    private Comet comet;
    private PlanetGateKeeper pgk;
    private BigBang bigbang;
    private CheckCrystals checkCrystals;
    private Crystal crystal;

    @BeforeEach
    void init() {
        Planet station = new Planet("Station");

        crystalBag = new CrystalBag();
        baseStation = new BaseStation(station);
        playerLocation = new Location(new Planet("Station"));
        astroKoala = new Astrokoala();
        comet = new Comet(baseStation);
        pgk = new PlanetGateKeeper();
        bigbang = new BigBang(comet);
        crystal = new Crystal("Colverde");
        player = new GalacticSailor(crystalBag, baseStation, playerLocation, astroKoala, bigbang, comet, pgk);

        checkCrystals = new CheckCrystals(astroKoala, player, baseStation, comet);
    }

    @Test
    void checkCrystals() {
        CheckCrystals checkCrystals = new CheckCrystals(astroKoala, player, baseStation, comet);

        Planet baseStationPlanet = baseStation.getPlanet();
        System.out.println("Base Station: " + (baseStationPlanet != null ? baseStationPlanet.getName() : "null"));

        player.setPlayerLocation(new Location(baseStationPlanet));

        System.out.println("Player Location: " + player.getPlayerLocation().getCurrentLocation());
        System.out.println("Base Station Location: " + baseStation.getPlanet().getName());

        boolean isAtBaseStation = player.isAtBaseStation();
        System.out.println("Is player at base station? " + isAtBaseStation);
        assertTrue(isAtBaseStation, "Player should be at the Base Station");

        baseStation.getPlacedCrystals().add(new Crystal("Ruby"));
        baseStation.getPlacedCrystals().add(new Crystal("Emerald"));

        System.out.println("Adding first crystal: Ruby");
        comet.addCrystal("Ruby");
        System.out.println("Are both comets full after first crystal? " + comet.areBothCometsFull());

        assertFalse(comet.areBothCometsFull(), "Comets should not be full after adding just one crystal");

        System.out.println("Adding second crystal: Emerald");
        comet.addCrystal("Emerald");
        System.out.println("Are both comets full after second crystal? " + comet.areBothCometsFull());

        assertTrue(comet.areBothCometsFull(), "Comets should be full after adding two crystals");

        String result = checkCrystals.execute();
        System.out.println("Command result: " + result);
        assertEquals("Both comets are ready for the Big Bang!\nUse 'bigbang' to create Earth!", result);
    }

    @Test
    void testToString() {
        crystal.setName("Luminara");
        assertEquals("Crystal{name='Luminara'}", crystal.toString());
    }
}
