import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CometTest {

    private Comet comet;
    private BaseStation baseStation;

    @BeforeEach
    void init() {
        Planet station = new Planet("Station");
        baseStation = new BaseStation(station);
        comet = new Comet(baseStation);
    }

    @Test
    void cometsFull() {
        assertFalse(comet.areBothCometsFull(), "Comets should be empty initially");

        baseStation.getPlacedCrystals().add(new Crystal("Ruby"));
        baseStation.getPlacedCrystals().add(new Crystal("Emerald"));

        comet.addCrystal("Ruby");
        assertFalse(comet.areBothCometsFull(), "Comets should not be full after adding just one crystal");

        comet.addCrystal("Emerald");
        assertTrue(comet.areBothCometsFull(), "Comets should be full after adding two crystals");
    }
}
