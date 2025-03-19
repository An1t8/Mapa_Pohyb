import java.util.ArrayList;

public class CrystalBag {

    private ArrayList<Crystal> crystals;

    public CrystalBag() {
        this.crystals = new ArrayList<>();
    }

    public void addCrystal(Crystal crystal) {
        if (crystal != null) {
            crystals.add(crystal);
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


    public ArrayList<Crystal> getCrystals() {
        return crystals;
    }
}
