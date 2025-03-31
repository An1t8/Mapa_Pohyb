import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class GameTest {


    private GalacticSailor player;
    private CrystalBag crystalBag;
    private BaseStation baseStation;
    private Location playerLocation;
    private Astrokoala astroKoala;
    private Comet comet;
    private PlanetGateKeeper pgk;
    private BigBang bigbang;
    private Crystal crystal;


    @org.junit.jupiter.api.BeforeEach
    void init() {
        Planet station = new Planet("Station");

        crystalBag = new CrystalBag();
        baseStation = new BaseStation(station);
        playerLocation = new Location(new Planet("Station"));
        astroKoala = new Astrokoala();
        comet = new Comet(baseStation);
        pgk = new PlanetGateKeeper();
        bigbang = new BigBang(comet);
        player = new GalacticSailor(crystalBag, baseStation, playerLocation, astroKoala, bigbang, comet, pgk);
        crystal = new Crystal("Colverde");
    }

    @org.junit.jupiter.api.Test
    void addCrystal() {
        Crystal crystal = new Crystal("Ruby");
        player.getCrystalBag().addCrystal(crystal);
        assertEquals(1, player.getCrystalBag().getCrystals().size());
        assertEquals("Ruby", player.getCrystalBag().getCrystals().get(0).getName());
    }

    @org.junit.jupiter.api.Test
    void removeCrystal() {
        Crystal crystal = new Crystal("Emerald");
        player.getCrystalBag().addCrystal(crystal);
        Crystal removedCrystal = player.getCrystalBag().removeCrystal();
        assertEquals("Emerald", removedCrystal.getName());
        assertTrue(player.getCrystalBag().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertTrue(player.getCrystalBag().isEmpty());
        player.getCrystalBag().addCrystal(new Crystal("Rosetta"));
        assertFalse(player.getCrystalBag().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void usePrompter() {
        String hint = player.usePrompter();
        assertNotNull(hint);
        assertTrue(hint.contains("hint"));
    }

    @Test
    void playerMovement() {
        Location newLocation = new Location(new Planet("PlanetB"));
        player.moveTo(newLocation);
        assertEquals(newLocation, player.getLocation());
    }


    @Test
    void testToString() {
        crystal.setName("Luminara");
        assertEquals("Crystal{name='Luminara'}", crystal.toString());
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

    @AfterEach
    void cleanUp() {
    }





}