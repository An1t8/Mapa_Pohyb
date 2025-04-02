package game;

import commands.Comet;

import java.util.Random;

public class Astrokoala {



    private BaseStation baseStation;
    private Comet comet;

    /**
     * Constructs an game.Astrokoala with a specified game.BaseStation and commands.Comet.
     * @param baseStation The base station associated with the game.Astrokoala.
     * @param comet       The comet associated with the game.Astrokoala.
     */
    public Astrokoala(BaseStation baseStation, Comet comet) {
        this.baseStation = baseStation;
        this.comet = comet;
    }

    public Astrokoala() {

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

    public BaseStation getBaseStation() {
        return baseStation;
    }

    public void setBaseStation(BaseStation baseStation) {
        this.baseStation = baseStation;
    }

    public Comet getComet() {
        return comet;
    }

    public void setComet(Comet comet) {
        this.comet = comet;
    }
}