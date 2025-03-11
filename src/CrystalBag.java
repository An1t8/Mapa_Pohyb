import java.util.ArrayList;

public class CrystalBag {

    private ArrayList<Crystal> crystals;

    public CrystalBag() {
        this.crystals = new ArrayList<>();
    }

    public void addCrystal(Crystal crystal) {
        if (crystal != null) {
            crystals.add(crystal);
            System.out.println("You have collected a " + crystal.getName() + " crystal.");
        }
    }

    public Crystal removeCrystal() {
        if (!crystals.isEmpty()) {
            return crystals.remove(0);
        }
        return null;
    }

    public boolean isEmpty() {
        return crystals.isEmpty();
    }

    public void showCrystals() {
        if (crystals.isEmpty()) {
            System.out.println("Your crystal bag is empty.");
        } else {
            System.out.println("You have the following crystals:");
            for (Crystal c : crystals) {
                System.out.println("- " + c.getName());
            }
        }
    }
}
