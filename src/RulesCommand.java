/**
 * A command that displays the game rules when executed.
 */
public class RulesCommand extends Command {

    /**
     * Executes the command to display the game rules.
     * @return A string containing the rules of the game.
     */
    @Override
    public String execute() {
        return """
                --------------- .𖥔 🪐˖ Game Rules - The Beginning: .𖥔 🪐˖ -------------------------------
                Travel between planets using the command 'fly [planet name]'.
                Answer the gatekeepers questions correctly to collect a crystal. If you dont know the answer try using 'prompter'.
                Bring the crystals to the base station and place them using 'position'.
                Arrange two stacks of 5 crystals correctly.
                You can always use 'cometPlan' to see your crystals arrangement in your comets!
                Use 'comet' and then type in the the name of the crystal to add crystal to the comet.
                Activate 'bigbang' and witness the Big Bang!
                You can always use 'help' to see available commands and planets you can travel to.
               
                """;

    }

    /**
     * Determines whether the command causes the game to exit.
     * @return False, since this command does not exit the game.
     */
    @Override
    public boolean exit() {
        return false;
    }
}
