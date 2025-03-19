public class PositionCrystal extends Command {

    private CrystalBag crystalBag ;
    private BaseStation baseStation;
    private GalacticSailor player;

    public PositionCrystal(CrystalBag crystalBag, BaseStation baseStation, GalacticSailor player) {
        this.crystalBag = crystalBag;
        this.baseStation = baseStation;
        this.player = player;
    }

    @Override
    public String execute() {
        if (crystalBag.isEmpty()) {
            return "You don't have any crystals to position.";
        }
        if (!player.getPlayerLocation().getCurrentLocation().equals("Station")) {
            return "You can't place crystals here! You must be at the Base Station.";
        }

        while (!crystalBag.isEmpty()) {
            Crystal crystal = crystalBag.removeCrystal();
            baseStation.placeCrystal(crystal);

        }

        return "All your crystals have been placed at the base station.";

    }

    @Override
    public boolean exit() {
        return false;
    }


}
