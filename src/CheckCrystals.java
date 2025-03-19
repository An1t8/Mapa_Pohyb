public class CheckCrystals extends Command {


    private Astrokoala astroKoala;
    private GalacticSailor player;
    private BaseStation station;
    private Comet comet;
    private static final int REQUIRED_CRYSTALS = 5;


    public CheckCrystals(Astrokoala astroKoala, GalacticSailor player, BaseStation station, Comet comet) {
        this.astroKoala = astroKoala;
        this.player = player;
        this.station = station;
        this.comet = comet;
    }

    @Override
    public String execute() {
        if (!player.isAtBaseStation()) {
            return "You cant use 'check' while not at the Base Station! Fly to your station and have your friend Astrokoala check the placement of your crystals!";
        }
        if (comet.getCrystals(1).size() == REQUIRED_CRYSTALS &&
                comet.getCrystals(2).size() == REQUIRED_CRYSTALS) {
                return "Both comets are ready for the Big Bang!\nUse 'bigbang' to create Earth!";
        }
        return "❗ Some crystals are still missing or misplaced. Try using 'cometPlan' to see the missing crystals!";
    }

    @Override
    public boolean exit() {
        return false;
    }


}

