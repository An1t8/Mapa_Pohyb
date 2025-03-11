public class TalkCommand extends Command {

    private GalacticSailor player;
    private PlanetGateKeeper pgk;

    public TalkCommand(GalacticSailor player, PlanetGateKeeper pgk) {
        this.player = player;
        this.pgk = pgk;
    }

    @Override
    public String execute() {
        player.talkToPGK();
        return "Talking to the PGK...";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
