public class CheckCrystals extends Command {


    private Astrokoala astroKoala;
    private GalacticSailor player;
    private BaseStation station;

    public CheckCrystals(Astrokoala astroKoala, GalacticSailor player, BaseStation station) {
        this.astroKoala = astroKoala;
        this.player = player;
        this.station = station;
    }

    @Override
    public String execute() {
        astroKoala.checkCrystals();

        if (player != null) {
            player.checkCrystals();
        } else {
            System.out.println("❗ Warning: No player assigned. Crystals cannot be checked.");
        }

        station.showPlacedCrystals();


        return "";

    }

    @Override
    public boolean exit() {
        return false;
    }
}
