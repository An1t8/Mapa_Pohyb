public class FlyCommand extends Command {


    private Location playerLocation;
    private String destination;
    private Universe universe;
    private QuestionsControler questionsControler;
    private GalacticSailor player;
    private PlanetGateKeeper pgk;
    private BaseStation station;

    public FlyCommand(Location playerLocation, QuestionsControler questionsControler, Universe universe, PlanetGateKeeper pgk, BaseStation station) {
        this.playerLocation = playerLocation;
        this.questionsControler = questionsControler;
        this.universe = universe;
        this.pgk = pgk;
        this.station = station;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public QuestionsControler getQuestionsControler() {
        return questionsControler;
    }


    @Override
    public String execute() {
        if (destination == null || destination.isEmpty()) {
            return "Please specify a destination planet. 'fly [planet]'";
        }

        String destinationName = destination.trim();

        if (destination.equalsIgnoreCase(playerLocation.getCurrentLocation())) {
            System.out.println("You are already on a " + playerLocation.getCurrentLocation() + ".");
        } else {

            boolean success = playerLocation.move(destinationName);

            if (success) {

                System.out.println("\uD83D\uDEF8 Flying to " + destinationName + "... ");
                String currentPlanet = playerLocation.getCurrentLocation();

                if ("Station".equalsIgnoreCase(currentPlanet)) {
                    station.text();
                } else {
                    System.out.println("\uD83D\uDC7D : Welcome to " + currentPlanet + "! \nIf you wish to take one of our crystals, you must answer all my questions correctly.");
                }

                PlanetGateKeeper pgk = questionsControler.getPlanetKeeper(currentPlanet);
                if (pgk != null) {
                    questionsControler.visitPlanet(currentPlanet);
                } else {
                    System.out.println("No PGK available on " + currentPlanet + ".");
                }

            } else {
                return "this planet doesnt exist in this universe";
            }
        }
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
