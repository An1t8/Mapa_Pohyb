//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Universe universe = new Universe();

        universe.loadMap("map.csv");

                Planet startPlanet = universe.getPlanet("Station");
                if (startPlanet == null) {
                    System.out.println("Station not found in the universe.");
                    return;
                }

                Location playerLocation = new Location(startPlanet);

                Scanner sc = new Scanner(System.in);
                while (true) {
                    System.out.println("You are currently on " + playerLocation.getCurrentLocation());
                    System.out.print("\nStation - The main station where your space journey begins.\n" +
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
                    String destination = sc.nextLine().trim();


                    if (destination.equalsIgnoreCase("exit")) {
                        break;
                    }

                    playerLocation.move(destination);
                }

                sc.close();
                System.out.println("Thank you for playing!");
            }
        }