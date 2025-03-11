public class Help extends Command{
    @Override
    public String execute() {

        StringBuilder sb = new StringBuilder();
        sb.append("\nAvailable Commands:\n" +
                "- fly [planet]      → Travel to a new planet.\n" +
                "- talk              → Interact with someone on the planet.\n" +
                "- take              → Collect a crystal from the environment.\n" +
                "- position          → Place a collected crystal at the base station.\n" +
                "- help              → Show available commands.\n" +
                "- leave             → Exit the game.\n" +
                "                ");
        sb.append("\nStation - The main station where your space journey begins.\n" +
                "Colverde - A green planet full of vegetation and oxygen.\n" +
                "Luminara - A glowing planet filled with light sources.\n" +
                "Rosetta - A planet with pink rocks and a strange atmosphere.\n" +
                "Crystalia - A planet covered in icy crystals.\n" +
                "Lavatron - A hot planet with active volcanoes.\n" +
                "Aquarix - A water world with endless oceans.\n" +
                "Solaria - A sun-scorched desert planet.\n" +
                "Glacius - An icy planet with extremely low temperatures.\n" +
                "Verdania - A planet covered in dense forests and exotic creatures.\n" +
                "Mysterra - A mysterious planet shrouded in mist and secrets. ");

        System.out.print("\n\nEnter the planet name you want to travel to or 'exit' to quit: ");

        return sb.toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
