public class RulesCommand extends Command {

    private Astrokoala astroKoala;

    public RulesCommand(Astrokoala astroKoala) {
        this.astroKoala = astroKoala;
    }

    @Override
    public String execute() {
        astroKoala.explainRules();
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
