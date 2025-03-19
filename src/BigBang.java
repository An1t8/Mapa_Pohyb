
public class BigBang extends Command {


    private Comet comet;

    public BigBang(Comet comet) {
        if (comet == null) {
            throw new IllegalArgumentException("Comet cannot be null!");
        }
        this.comet = comet;
    }

    @Override
    public String execute() {
        if (comet.areBothCometsFull()) {
            createEarth();
            return "🌍 Big Bang has occurred! The Earth has been created!";
        }
        return "Both comets are not full yet. Add more crystals to each comet.";
    }

    private void createEarth() {
        Planet earth = new Planet("Earth");
        System.out.println("A new planet, Earth, has been created!");
    }

    @Override
    public boolean exit() {
        return true;
    }
}
