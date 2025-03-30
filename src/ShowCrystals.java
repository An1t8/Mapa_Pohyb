import java.util.List;

/**
 * A command that displays the crystals the player currently holds in their bag
 * and, if at the base station, the crystals placed there.
 */
public class ShowCrystals extends Command{

    private GalacticSailor player;
    private BaseStation baseStation;


    /**
     * Constructs the ShowCrystals command with the given player and base station.
     * @param player      The player whose crystals will be displayed.
     * @param baseStation The base station where placed crystals are stored.
     */
    public ShowCrystals(GalacticSailor player, BaseStation baseStation) {
        this.player = player;
        this.baseStation = baseStation;
    }


    /**
     * Executes the command to display the player's crystals and, if applicable, the crystals placed at the base station.
     * @return A string describing the crystals in the player's bag and at the base station.
     */
    @Override
    public String execute() {
        StringBuilder result = new StringBuilder();

        CrystalBag bag = player.getCrystalBag();
        if (bag.isEmpty()) {
            result.append(" Your crystal bag is empty.\n");
        } else {
            result.append("You have the following crystals in your bag:\n");
            for (Crystal c : bag.getCrystals()) {
                result.append("- ").append(c.getName()).append("\n");
            }
        }

        if (player.getLocation().getCurrentLocation().equalsIgnoreCase("Station")) {
            List<Crystal> placedCrystals = baseStation.getPlacedCrystals();
            if (placedCrystals.isEmpty()) {
                result.append("\n No crystals have been placed at the base station yet.");
            } else {
                result.append("\n Crystals placed at the base station:\n");
                for (Crystal c : placedCrystals) {
                    result.append("- ").append(c.getName()).append("\n");
                }
            }

        } else {
            result.append("\n You are not at the base station, so you can only see your crystal bag.");
        }

        return result.toString();
    }

    /**
     * Determines whether the command causes the game to exit.
     * @return False, since this command does not exit the game.
     */
    @Override
    public boolean exit() {
        return false;
    }
}
