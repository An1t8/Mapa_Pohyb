public class PositionCrystal extends Command {

    private CrystalBag crystalBag ;
    private BaseStation baseStation;

    public PositionCrystal(CrystalBag crystalBag, BaseStation baseStation) {
        this.crystalBag = crystalBag;
        this.baseStation = baseStation;
    }

    @Override
    public String execute() {
        if (crystalBag.isEmpty()) {
            return "You don't have any crystals to position.";
        }

        Crystal crystal = crystalBag.removeCrystal();
        baseStation.placeCrystal(crystal);
        return "You have placed the crystal" + crystal.getName() + ", at the base station.";
    }

    @Override
    public boolean exit() {
        return false;
    }


}
