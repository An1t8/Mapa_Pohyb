package game;

import commands.BigBang;
import commands.Comet;
import commands.Prompter;
import commands.ShowCrystals;
import questions.QuestionSession;

import java.io.Serializable;

/**
 * The game.GalacticSailor class represents a player in the game, with various attributes and abilities related to the player's progress.
 * It contains methods for interacting with the environment, including the current location, the crystal bag, and the interaction with the game world (e.g., using the prompter, setting current planet).
 */

public class GalacticSailor implements Serializable {

    private static final long serialVersionUID = 1L;

    private CrystalBag crystalBag;
    private BaseStation baseStation;
    private Location playerLocation;
    private Astrokoala astroKoala;
    private BigBang bigBang;
    private Comet comet;
    private PlanetGateKeeper pgk;
    private QuestionSession currentSession;
    private Prompter prompter;
    private ShowCrystals showCrystals;
    private Planet planet;


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


    private boolean gameCompleted; // Stav hry (dokonalá hra nebo ne)

    // Getter a setter pro tento atribut
    public boolean isGameCompleted() {
        return gameCompleted;
    }

    public void setGameCompleted(boolean gameCompleted) {
        this.gameCompleted = gameCompleted;
    }

    public PlanetGateKeeper getCurrentPGK() {
        return pgk;
    }

    /**
     * Sets a new game.PlanetGateKeeper for the session
     */
    public void setCurrentPGK(PlanetGateKeeper pgk) {
        this.pgk = pgk;
        this.currentSession = null;
    }

    /**
     * Uses the prompter to get a hint for the player.
     * @return A hint from the prompter or a message if the prompter is not available.
     */
    public String usePrompter() {
        if (prompter == null) {
            return "Prompter is not available.";
        }
        return prompter.getHint();
    }


    public BaseStation getBaseStation() {
        return baseStation;
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


    /**
     * Checks if the player is currently at the base station.
     * @return {@code true} if the player is at the base station, {@code false} otherwise.
     */

    public boolean isAtBaseStation() {
        return this.getPlayerLocation().getCurrentLocation().equals(baseStation.getPlanet().getName());
    }

    /**
     * Moves the player to a new location.
     * @param newLocation The new {@code game.Location} the player is moving to.
     */
    public void moveTo(Location newLocation) {
        this.playerLocation = newLocation;
    }



}
