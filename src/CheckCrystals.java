public class CheckCrystals extends Command {


    private Astrokoala astroKoala;

    public CheckCrystals(Astrokoala astroKoala) {
        this.astroKoala = astroKoala;
    }

    @Override
    public String execute() {
        astroKoala.checkCrystals();
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
