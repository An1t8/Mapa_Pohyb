import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GalacticSailorTest {

    private GalacticSailor player;
    private CrystalBag crystalBag;
    private BaseStation baseStation;
    private Location playerLocation;
    private Astrokoala astroKoala;
    private Comet comet;
    private PlanetGateKeeper pgk;
    private BigBang bigbang;

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
        player = new GalacticSailor(crystalBag, baseStation, playerLocation, astroKoala, bigbang, comet, pgk);
    }

    @Test
    void usePrompter() {
        String hint = player.usePrompter();
        assertNotNull(hint);
        assertTrue(hint.contains("hint"));
    }

    @Test
    void playerMovement() {
        Location newLocation = new Location(new Planet("Colverde"));
        player.moveTo(newLocation);
        assertEquals(newLocation, player.getLocation());
    }

    @Test
    void isAtBaseStationTest() {
        Planet baseStationPlanet = baseStation.getPlanet();
        player.setPlayerLocation(new Location(baseStationPlanet));

        boolean isAtBaseStation = player.isAtBaseStation();
        assertTrue(isAtBaseStation, "Player should be at the Base Station");
    }
}
