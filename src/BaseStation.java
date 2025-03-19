import java.util.ArrayList;
import java.util.List;

public class BaseStation {

    private ArrayList<Crystal> placedCrystals;

    public BaseStation() {
        this.placedCrystals = new ArrayList<>();
    }

    public void placeCrystal(Crystal crystal) {
        if (crystal != null) {
            placedCrystals.add(crystal);
        }
    }

    public void text() {
        System.out.println("\nYou are now on Station. Use 'position' to place all crystals from your crystalBag on the base station. \nYour friend, Astrokoala is here, when you think your comets are ready use 'check' and Astrokoala will check if you have all the crystals!");
    }

    public List<Crystal> getPlacedCrystals() {
        return placedCrystals;
    }

}
