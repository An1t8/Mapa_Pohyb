import java.util.Random;

public class Astrokoala {


    private BaseStation baseStation;

    public Astrokoala(BaseStation baseStation) {
        this.baseStation = baseStation;
    }



    public String giveHint() {
        String[] hints = {
                "Don't forget to place the crystals correctly at the base station!",
                "Each planet holds a unique crystal, make sure to collect them all.",
                "Some gatekeepers are friendly, but others will test your knowledge!",
                "You can always use the 'help' command to see available actions.",
                "Remember, you need two comets to create the Big Bang!"
        };
        Random rd = new Random();
        return hints[rd.nextInt(hints.length)];
    }


    public boolean checkCrystals() {
        if (baseStation.isComplete()) {
            System.out.println("The crystals are correctly placed! The Big Bang is near...");
            return true;
        } else {
            System.out.println("❗Some crystals are still missing or misplaced.");

            return false;
        }
    }


    public void explainRules() {
        System.out.println("""
                Game Rules - The Beginning:
                Travel between planets using the command 'fly [planet name]'.
                Answer the gatekeepers' questions correctly to collect a crystal.
                Bring the crystals to the base station and place them using 'position crystal'.
                Arrange two stacks of 5 crystals correctly.
                Use 'create comet' to form two comets.
                Activate 'create bang' and witness the Big Bang!
                You can always use 'help' to see available commands.
                """);
    }
}
