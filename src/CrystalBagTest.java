import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CrystalBagTest {
    private CrystalBag crystalBag;

    @BeforeEach
    void init() {
        crystalBag = new CrystalBag();
        System.out.println("CrystalBag initialized");
    }

    @Test
    void addCrystal() {
        System.out.println("\n>> TEST: addCrystal");

        Crystal crystal = new Crystal("Rosetta");
        System.out.println("Adding a new crystal do the crystalbag");
        crystalBag.addCrystal(crystal);
        System.out.println("Number of crystals in crystalBag: " + crystalBag.getCrystals().size());
        assertEquals(1, crystalBag.getCrystals().size());
        System.out.println("Name of the first crystal: " + crystalBag.getCrystals().getFirst().getName());
        assertEquals("Rosetta", crystalBag.getCrystals().getFirst().getName());
        System.out.println("test finished successfully");
    }

    @Test
    void removeCrystal() {
        System.out.println("\n>> TEST: removeCrystal");
        Crystal crystal = new Crystal("Luminara crystal");
        System.out.println("Adding a new crystal do the crystalbag");

        crystalBag.addCrystal(crystal);
        System.out.println("Removing crystal");
        Crystal removedCrystal = crystalBag.removeCrystal();
        System.out.println("the name of the removed crystal: " + removedCrystal.getName());
        assertEquals("Luminara crystal", removedCrystal.getName());
        System.out.println("checking whether the crystalBag is empty");
        assertTrue(crystalBag.isEmpty());
        System.out.println("test finished successfully");

    }

    @Test
    void isEmpty() {
        System.out.println("\n>> TEST: isEmpty" );
        System.out.println("checking if the bag is empty");
        assertTrue(crystalBag.isEmpty());
        System.out.println("creating a new crystal named 'Rosetta'");
        crystalBag.addCrystal(new Crystal("Rosetta"));
        System.out.println("checking whether bag with the crystal is empty");
        assertFalse(crystalBag.isEmpty());
        System.out.println("test finished successfully");

    }
}
