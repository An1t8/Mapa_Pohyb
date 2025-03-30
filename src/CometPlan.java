/**
 * The CometPlan command displays the current crystal distribution in both comets.
 */
public class CometPlan extends Command{

    private Comet comet;

    /**
     * Constructs a CometPlan command with the specified comet
     * @param comet The comet whose crystal distribution will be displayed.
     * @throws IllegalArgumentException if the comet is null.
     */
    public CometPlan(Comet comet) {
        if (comet == null) {
            throw new IllegalArgumentException("Comet cant be null");
        }
        this.comet = comet;
    }

    /**
     * Executes the command to display the crystals in both comets.
     */
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
