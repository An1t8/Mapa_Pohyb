package commands;

import game.*;
import questions.QuestionSession;

import java.io.Serializable;

/**
 * A command that allows the player to take a crystal from the game.PlanetGateKeeper after successfully answering all the questions.
 * The crystal is stored in the player's game.CrystalBag.
 */

public class TakeCrystal extends Command implements Serializable {
    private CrystalBag crystalBag;
    private GalacticSailor player;
    private BaseStation baseStation;
    private Universe universe; // Přidáme odkaz na Universe pro kontrolu vzatých krystalů



    /**
     * Constructs the commands.TakeCrystal command with the given crystal bag and player.
     * @param crystalBag The crystal bag where collected crystals are stored.
     * @param player     The player attempting to take the crystal.
     */
    public TakeCrystal(CrystalBag crystalBag, GalacticSailor player, Universe universe) {
        this.crystalBag = crystalBag;
        this.player=  player;
        this.universe = universe;
    }


    /**
     * Executes the command to allow the player to take a crystal from the PGK if the player has completed the necessary conditions.
     * @return A string describing the result of the action, either successful crystal collection or an error message.
     */
    @Override
    public String execute() {
        try {
            PlanetGateKeeper pgk = player.getCurrentPGK();

            if (pgk == null) {
                return "There's no Planet Gate Keeper here to allow you to take a crystal.";
            }

            QuestionSession session = player.getCurrentSession();
            if (session == null || !session.isSessionCompleted()) {
                return "You must correctly answer all the Planet Gate Keeper's questions before taking a crystal.";
            }

            /*if (pgk.canTakeCrystal()) {
                Crystal crystal = pgk.allowCrystalTake();
                if (crystal != null) {
                    crystalBag.addCrystal(crystal);
                    return "You have collected a " + crystal.getName();

                }
            }

             */
            if (pgk.canTakeCrystal()) {
                Crystal crystal = pgk.allowCrystalTake();

                if (crystal != null) {
                    if (crystalBag.getCrystals().contains(crystal)) {
                        return "You already have this crystal in your bag.";
                    }

                    if (player.getBaseStation().getPlacedCrystals().contains(crystal)) {
                        return "This crystal is already on the base station.";
                    }
                    // Kontrola, zda krystal už nebyl vzat v rámci hry
                    if (universe.isCrystalTaken(crystal.getName())) {
                        return "This crystal has already been taken from this planet.";
                    }

                    crystalBag.addCrystal(crystal);
                    universe.markCrystalAsTaken(crystal.getName());

                    return "You have collected a " + crystal.getName();
                }
            }


        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        return "You've already taken the crystal from this planet.";
    }

        @Override
    public boolean exit() {
        return false;
    }
}
