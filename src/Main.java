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
                    System.out.print("Enter the planet name you want to travel to or 'exit' to quit: ");
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