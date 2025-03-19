import java.util.List;

public class ShowCrystals extends Command{

    private GalacticSailor player;
    private BaseStation baseStation;


    public ShowCrystals(GalacticSailor player, BaseStation baseStation) {
        this.player = player;
        this.baseStation = baseStation;
    }

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

    @Override
    public boolean exit() {
        return false;
    }
}
