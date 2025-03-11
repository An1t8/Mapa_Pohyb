public class HintCommand extends Command {

    private Astrokoala astroKoala;

    public HintCommand(Astrokoala astroKoala) {
        this.astroKoala = astroKoala;
    }

    @Override
    public String execute() {
        return astroKoala.giveHint();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
