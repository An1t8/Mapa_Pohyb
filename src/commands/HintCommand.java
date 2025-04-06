package commands;

import game.Astrokoala;

import java.io.Serializable;

/**
 * The commands.HintCommand class represents a command that provides a hint from game.Astrokoala.
 * When executed, it retrieves a random hint from game.Astrokoala to assist the player.
 */

public class HintCommand extends Command implements Serializable {

    private Astrokoala astroKoala;

    public HintCommand(Astrokoala astroKoala) {
        this.astroKoala = astroKoala;
    }

    /**
     * Executes the commands.HintCommand by returning a random hint from game.Astrokoala.
     * @return A string containing a hint provided by game.Astrokoala.
     */
    @Override
    public String execute() {
        return astroKoala.giveHint();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
