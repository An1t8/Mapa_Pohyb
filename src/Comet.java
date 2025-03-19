import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Comet extends Command {

    private static final int REQUIRED_CRYSTALS = 5;
    private List<Crystal> comet1;
    private List<Crystal> comet2;
    private BaseStation baseStation;

    public Comet(BaseStation baseStation) {
        this.baseStation = baseStation;
        this.comet1 = new ArrayList<>();
        this.comet2 = new ArrayList<>();
    }

    public List<Crystal> getCrystals(int cometNumber) {
        return (cometNumber == 1) ? comet1 : comet2;
    }

    public String addCrystal(String crystalName) {
        List<Crystal> placedCrystals = baseStation.getPlacedCrystals();
        Crystal selectedCrystal = null;

        for (Crystal crystal : placedCrystals) {
            if (crystal.getName().equalsIgnoreCase(crystalName)) {
                selectedCrystal = crystal;
                break;
            }
        }

        if (selectedCrystal == null) {
            return "Crystal '" + crystalName + "' not found at the base station.";
        }

        if (comet1.size() < REQUIRED_CRYSTALS) {
            comet1.add(selectedCrystal);
        } else if (comet2.size() < REQUIRED_CRYSTALS) {
            comet2.add(selectedCrystal);
        } else {
            return "Both comets are already full!";
        }

        placedCrystals.remove(selectedCrystal);
        return "Crystal '" + crystalName + "' has been added to a comet.";
    }

    public boolean areBothCometsFull() {
        return comet1.size() == REQUIRED_CRYSTALS && comet2.size() == REQUIRED_CRYSTALS;
    }



    public void showComets() {
        System.out.println("🌠 Comet crystal distribution:");

        System.out.println("\n Comet 1:");
        if (comet1.isEmpty()) {
            System.out.println("   - Empty");
        } else {
            for (Crystal c : comet1) {
                System.out.println("   - " + c.getName());
            }
        }

        System.out.println("\n Comet 2:");
        if (comet2.isEmpty()) {
            System.out.println("   - Empty");
        } else {
            for (Crystal c : comet2) {
                System.out.println("   - " + c.getName());
            }
        }
        System.out.println("\nuse 'comet' to add crystals to the comet." );
    }

    @Override
    public String execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter crystal name: ");
        return addCrystal(scanner.nextLine());
    }

    @Override
    public boolean exit() {
        return false;
    }
}
