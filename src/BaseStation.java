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

    public boolean isComplete() {
        return placedCrystals.size() >= 10;
    }

    public void showPlacedCrystals() {
        if (placedCrystals.isEmpty()) {
            System.out.println("No crystals have been placed yet.");
        } else {
            System.out.println("Crystals at the base station:");
            for (Crystal c : placedCrystals) {
                System.out.println("- " + c.getName());
            }
        }
    }

    public String createBigBang() {
       return "";
    }

    public List<Crystal> getPlacedCrystals() {
        return placedCrystals;
    }

}
