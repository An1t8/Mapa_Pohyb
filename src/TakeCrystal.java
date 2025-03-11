public class TakeCrystal extends Command{
    private CrystalBag crystalBag;
    private GalacticSailor player;


    public TakeCrystal(CrystalBag crystalBag, GalacticSailor player) {
        this.crystalBag = crystalBag;
        this.player=  player;
    }

    @Override
    public String execute() {
        PlanetGateKeeper pgk = player.getCurrentPGK();

        if (pgk == null) {
            return "There's no Planet Gate Keeper here to allow you to take a crystal.";
        }

        QuestionSession session = player.getCurrentSession();
        if (session == null || !session.isSessionCompleted()) {
            return "You must correctly answer all the Planet Gate Keeper's questions before taking a crystal.";
        }

        if (pgk.canTakeCrystal()) {
            Crystal crystal = pgk.allowCrystalTake();
            if (crystal != null) {
                crystalBag.addCrystal(crystal);
                return "You have collected a " + crystal.getName() + " crystal.";

            }
        }

        return "You've already taken the crystal from this planet.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
