public class Help extends Command{
    @Override
    public String execute() {

        StringBuilder sb = new StringBuilder();
        System.out.println("\n Available Commands:");
        System.out.println("""
                - fly [planet]      → Travel to a new planet.
                - talk              → Interact with someone on the planet.
                - take              → Collect a crystal from the environment.
                - position          → Place a all collected crystals at the base station.
                - hint              → Astrokoala gives you a random hint of the game.
                - check             → Astrokoala checks if the crystals are placed correctly plus displays are at the BaseStation.
                                      You can use this ONLY when youre at the base station since Astrokoala doesnt travel with you.
                - rules             → Display game rules. Use this whenever you feel lost!
                - help              → Show available commands and planets you can travel to.
                - show              → Displays the crystals in your crystal bag or at the base station. You can use this whenever you want.
                - leave             → Exit the game.
                - bigbang           → Trigger the Big Bang event when two comets are ready.
                - comet             → Show all informations about the comets.
                - cometplan         → Displays comet crystal distribution.
                """);

        System.out.println("\n\uD83C\uDF0D Available Planets:");
        System.out.println("""
                - Station    - The main station where your space journey begins.
                - Colverde   - A green planet full of vegetation and oxygen.
                - Luminara   - A glowing planet filled with light sources.
                - Rosetta    - A planet with pink rocks and a strange atmosphere.
                - Crystalia  - A planet covered in icy crystals.
                - Lavatron   - A hot planet with active volcanoes.
                - Aquarix    - A water world with endless oceans.
                - Solaria    - A sun-scorched desert planet.
                - Glacius    - An icy planet with extremely low temperatures.
                - Verdania   - A planet covered in dense forests and exotic creatures.
                - Mysterra   - A mysterious planet shrouded in mist and secrets.
                """);
        System.out.print("\nEnter the planet name you want to travel to or 'exit' to quit: ");

        return sb.toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
