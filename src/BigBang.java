import java.util.ArrayList;

public class BigBang extends Command {

    private ArrayList<Comet> comets;

    public BigBang() {
        this.comets = new ArrayList<>();
    }

    public void addComet(Comet comet) {
        if (comet != null) {
            comets.add(comet);
            System.out.println("Comet added to Big Bang process.");
        }
    }

    @Override
    public String execute() {
        if (comets.size() == 2) {
            boolean allCometsComplete = true;
            for (Comet comet : comets) {
                if (!comet.isComplete()) {
                    allCometsComplete = false;
                    break;
                }
            }

            if (allCometsComplete) {
                createEarth();
                comets.clear();
                return "Big Bang has occurred! The Earth has been created!";
            } else {
                return "Not all comets are complete. Make sure each comet has 5 crystals.";
            }
        } else {
            return "You need two comets to create the Big Bang.";
        }
    }

    private void createEarth() {
        Planet earth = new Planet("Earth");
        System.out.println("A new planet, Earth, has been created!");

    }

    @Override
    public boolean exit() {
        return false;
    }
}
