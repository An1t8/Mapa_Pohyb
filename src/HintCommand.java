/**
 * The HintCommand class represents a command that provides a hint from Astrokoala.
 * When executed, it retrieves a random hint from Astrokoala to assist the player.
 */

public class HintCommand extends Command {

    private Astrokoala astroKoala;

    public HintCommand(Astrokoala astroKoala) {
        this.astroKoala = astroKoala;
    }

    /**
     * Executes the HintCommand by returning a random hint from Astrokoala.
     * @return A string containing a hint provided by Astrokoala.
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
