

public class GalacticSailor {

    private CrystalBag crystalBag;
    private BaseStation baseStation;
    private Location playerLocation;
    private Astrokoala astroKoala;
    private BigBang bigBang;
    private Comet comet;
    private PlanetGateKeeper pgk;
    private QuestionSession currentSession;
    private Prompter prompter;


    public GalacticSailor(CrystalBag crystalBag, BaseStation baseStation, Location playerLocation, Astrokoala astroKoala, BigBang bigBang, Comet comet, PlanetGateKeeper pgk) {
        this.crystalBag = crystalBag;
        this.baseStation = baseStation;
        this.playerLocation = playerLocation;
        this.astroKoala = astroKoala;
        this.bigBang = bigBang;
        this.comet = comet;
        this.pgk = pgk;
        this.prompter = new Prompter(this);
    }


    public PlanetGateKeeper getCurrentPGK() {
        return pgk;
    }

    public void setCurrentPGK(PlanetGateKeeper pgk) {
        this.pgk = pgk;
        this.currentSession = null;
    }

    public String usePrompter() {
        if (prompter == null) {
            return "Prompter is not available.";
        }
        return prompter.getHint();
    }

    public QuestionSession getCurrentSession() {
        return currentSession;
    }

    public Prompter getPrompter() {
        return prompter;
    }

    public void setCurrentSession(QuestionSession session) {
        this.currentSession = session;
    }

    public Location getLocation() {
        return playerLocation;
    }

    public Location getPlayerLocation() {
        return playerLocation;
    }

    public void setPlayerLocation(Location playerLocation) {
        this.playerLocation = playerLocation;
    }

    public String getCurrentPlanetName() {
        return playerLocation.getCurrentLocation();
    }

    public CrystalBag getCrystalBag() {
        return crystalBag;
    }

    public void checkCrystals() {
        crystalBag.showCrystals();
    }


}
