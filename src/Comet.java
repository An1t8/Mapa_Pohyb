import java.util.ArrayList;
import java.util.List;


public class Comet extends Command {

        private List<Crystal> crystals;
        private static final int REQUIRED_CRYSTALS = 5;

        public Comet() {
            this.crystals = new ArrayList<>();
        }

        public void addCrystal(Crystal crystal) {
            if (crystal != null && crystals.size() < REQUIRED_CRYSTALS) {
                crystals.add(crystal);
                System.out.println("Crystal " + crystal.getName() + " has been added to the comet.");
            } else if (crystals.size() >= REQUIRED_CRYSTALS) {
                System.out.println("The comet already has the required number of crystals.");
            } else {
                System.out.println("Invalid crystal!");
            }
        }

        public boolean isComplete() {
            return crystals.size() == REQUIRED_CRYSTALS;
        }

        public void showCrystals() {
            if (crystals.isEmpty()) {
                System.out.println("The comet is empty.");
            } else {
                System.out.println("The comet contains the following crystals:");
                for (Crystal c : crystals) {
                    System.out.println("- " + c.getName());
                }
            }
        }

        public void clear() {
            crystals.clear();
            System.out.println("The comet has been cleared.");
        }

        public void removeLastCrystal() {
            if (!crystals.isEmpty()) {
                Crystal removed = crystals.remove(crystals.size() - 1);
                System.out.println("Crystal " + removed.getName() + " has been removed from the comet.");
            } else {
                System.out.println("The comet is already empty.");
            }
        }

        public int getCrystalCount() {
            return crystals.size();
        }


        @Override
        public String execute() {

            if (crystals.isEmpty()) {
                return "The comet is empty.";
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("The comet contains the following crystals:\n");
                for (Crystal c : crystals) {
                    sb.append("- ").append(c.getName()).append("\n");
                }
                return sb.toString();
            }
        }

        @Override
        public boolean exit() {
            return false;
        }

}
