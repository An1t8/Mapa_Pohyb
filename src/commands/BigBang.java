package commands;

/**
 * The commands.BigBang class represents the final command that triggers the creation
 * of Earth if both comets are full.
 */
public class BigBang extends Command {


    private Comet comet;

    /**
     * Constructs a commands.BigBang command with the specified comet.
     * @param comet The comet used in the Big Bang event.
     * @throws IllegalArgumentException if the comet is null.
     *
     */
    public BigBang(Comet comet) {
        if (comet == null) {
            throw new IllegalArgumentException("commands.Comet cannot be null!");
        }
        this.comet = comet;

    }

    /**
     * Executes the Big Bang event. If both comets are full, Earth is created, and the player wins the game.
     * @return A message indicating whether the Big Bang was successful or if more crystals are needed.
     */
    @Override
    public String execute() {
        if (comet.areBothCometsFull()) {
            return "🌍 Big Bang has occurred! Congratulations you won the game the Earth has been created! \n Thank you for playing 'The Beginning'! You can now use 'leave' to exit the game.";
        }
        return "Both comets are not full yet. Add more crystals to each comet.";
    }

    /**
     * @return false, since this command does not exit the game.
     */
    @Override
    public boolean exit() {
        return false;
    }
}
