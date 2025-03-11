public class TakeCrystal extends Command{
    private CrystalBag crystalBag;
    private PlanetGateKeeper pgk;

    public TakeCrystal(CrystalBag crystalBag, PlanetGateKeeper pgk) {
        this.crystalBag = crystalBag;
        this.pgk = pgk;
    }

    @Override
    public String execute() {
        if (pgk.canTakeCrystal()) {
            Crystal crystal = pgk.allowCrystalTake();
            if (crystal != null) {
                crystalBag.addCrystal(crystal);
                return "You have collected a " + crystal.getName() + " crystal.";
            }
        }
        return "PGK does not allow you to take a crystal right now.";
    }


    @Override
    public boolean exit() {
        return false;
    }
}
