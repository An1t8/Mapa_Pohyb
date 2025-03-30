import java.util.Random;

public class Astrokoala {



    private BaseStation baseStation;
    private Comet comet;

    /**
     * Constructs an Astrokoala with a specified BaseStation and Comet.
     * @param baseStation The base station associated with the Astrokoala.
     * @param comet       The comet associated with the Astrokoala.
     */
    public Astrokoala(BaseStation baseStation, Comet comet) {
        this.baseStation = baseStation;
        this.comet = comet;
    }

    /**
     * Provides a random hint to the player.
     *
     * @return A randomly selected hint from a predefined set of hints.
     */
    public String giveHint() {
        String[] hints = {
                "Don't forget to place the crystals correctly at the base station!",
                "Each planet holds a unique crystal, make sure to collect them all.",
                "Some gatekeepers are friendly, but others will test your knowledge!",
                "You can always use the 'help' command to see available actions.",
                "Remember, you need two comets to create the Big Bang!"
        };
        return hints[new Random().nextInt(hints.length)];
    }
}