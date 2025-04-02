package commands;

import game.BaseStation;
import game.Crystal;
import game.CrystalBag;
import game.GalacticSailor;

/**
 * Represents a command that allows the player to position all collected crystals at the Base Station.
 */
public class PositionCrystal extends Command {

    private CrystalBag crystalBag ;
    private BaseStation baseStation;
    private GalacticSailor player;

    public PositionCrystal(CrystalBag crystalBag, BaseStation baseStation, GalacticSailor player) {
        this.crystalBag = crystalBag;
        this.baseStation = baseStation;
        this.player = player;
    }


    /**
     * Executes the command to position crystals at the base station.
     * @return A message indicating the result of the action.
     */
    @Override
    public String execute() {
        if (crystalBag.isEmpty()) {
            return "You don't have any crystals to position.";
        }
        if (!player.getPlayerLocation().getCurrentLocation().equals("Station")) {
            return "You can't place crystals here! You must be at the Base Station.";
        }

        while (!crystalBag.isEmpty()) {
            Crystal crystal = crystalBag.removeCrystal();
            baseStation.placeCrystal(crystal);

        }

        return "All your crystals have been placed at the base station.";

    }

    /**
     * Indicates whether this command causes the game to exit.
     * @return {@code false}, since this command does not exit the game.
     */
    @Override
    public boolean exit() {
        return false;
    }


}
