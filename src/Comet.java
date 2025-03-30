import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents a celestial body that can hold crystals.
 * Two comets are required to be filled with crystals to trigger the Big Bang.
 */

public class Comet extends Command {

    private static final int REQUIRED_CRYSTALS = 1;
    private List<Crystal> comet1;
    private List<Crystal> comet2;
    private BaseStation baseStation;

    public Comet(BaseStation baseStation) {
        this.baseStation = baseStation;
        this.comet1 = new ArrayList<>();
        this.comet2 = new ArrayList<>();
    }

    /**
     * Retrieves the list of crystals for the specified comet.
     * @return The list of crystals in the specified comet.
     */

    public List<Crystal> getCrystals(int cometNumber) {
        return (cometNumber == 1) ? comet1 : comet2;
    }

    /**
     * Adds a crystal from the base station to one of the comets.
     * @param crystalName The name of the crystal to add.
     * @return A message indicating whether the crystal was successfully added or not.
     */

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

    /**
     * Checks if both comets have the required number of crystals.
     */

    public boolean areBothCometsFull() {
        return comet1.size() == REQUIRED_CRYSTALS && comet2.size() == REQUIRED_CRYSTALS;
    }



    /**
     * Displays the current distribution of crystals in both comets.
     */
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

    /**
     * Executes the command to prompt the user for a crystal name and add it to a comet.
     * @return A message indicating the result of adding a crystal.
     */
    @Override
    public String execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter crystal name - [planet name] + 'crystal':  ");
        return addCrystal(scanner.nextLine());
    }

    @Override
    public boolean exit() {
        return false;
    }
}
