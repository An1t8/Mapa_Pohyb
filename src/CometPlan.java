
public class CometPlan extends Command{

    private Comet comet;

    public CometPlan(Comet comet) {
        if (comet == null) {
            throw new IllegalArgumentException("Comet cant be null");
        }
        this.comet = comet;
    }

    @Override
    public String execute() {
        comet.showComets();
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
