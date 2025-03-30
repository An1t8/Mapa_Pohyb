/**
 * The CheckCrystals command is responsible for verifying whether the player's comets contain
 * the required crystals for the Big Bang event.
 */
public class CheckCrystals extends Command {


    private Astrokoala astroKoala;
    private GalacticSailor player;
    private BaseStation station;
    private Comet comet;
    private static final int REQUIRED_CRYSTALS = 1;



    public CheckCrystals(Astrokoala astroKoala, GalacticSailor player, BaseStation station, Comet comet) {
        this.astroKoala = astroKoala;
        this.player = player;
        this.station = station;
        this.comet = comet;
    }

    /**
     * Executes the command to check if the required crystals are correctly placed on both comets.
     * @return A message indicating whether the comets are ready for the Big Bang or if crystals are missing.
     */
    @Override
    public String execute() {
        if (!player.isAtBaseStation()) {
            return "You cant have your comets checked while not at the Base Station! Fly to your station and have your friend Astrokoala check the placement of your crystals!\n You can use 'show' to see the crystals in your crystalBag";
        }
        if (comet.getCrystals(1).size() == REQUIRED_CRYSTALS &&
                comet.getCrystals(2).size() == REQUIRED_CRYSTALS) {
                return "Both comets are ready for the Big Bang!\nUse 'bigbang' to create Earth!";
        }
        return "❗ Some crystals are still missing or misplaced. Try using 'cometPlan' to see the missing crystals!";
    }


    /**
     * Determines whether this command should terminate the game.
     * @return false since this command does not exit the game.
     */
    @Override
    public boolean exit() {
        return false;
    }


}

