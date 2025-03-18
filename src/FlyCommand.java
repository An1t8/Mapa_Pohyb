public class FlyCommand extends Command{


    private Location playerLocation;
    private String destination;
    private Universe universe;
    private QuestionsControler questionsControler;
    private GalacticSailor player;


    public FlyCommand(Location playerLocation, QuestionsControler questionsControler, Universe universe) {
        this.playerLocation = playerLocation;
        this.questionsControler = questionsControler;
        this.universe = universe;
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
            return "Please specify a destination planet.";
        }

        String destinationName = destination.trim();
        //questionsControler.getGalacticSailor().setCurrentPGK(null);

        if(destination.equalsIgnoreCase(playerLocation.getCurrentLocation())){
            System.out.println("You are already on a " + playerLocation.getCurrentLocation() + ".");
        }
         else {
            System.out.println("Flying to " + destinationName + "...");

            boolean success = playerLocation.move(destinationName);

            if (success) {
                String currentPlanet = playerLocation.getCurrentLocation();

                if ("Station".equalsIgnoreCase(currentPlanet)) {
                    System.out.println("You are now on Station.");
                } else {
                    System.out.println("Welcome to " + currentPlanet + "!");
                }

                PlanetGateKeeper pgk = questionsControler.getPlanetKeeper(currentPlanet);
                if (pgk != null) {
                    questionsControler.visitPlanet(currentPlanet);
                } else {
                    System.out.println("No PGK available on " + currentPlanet + ".");
                }

            } else {
                return "Invalid travel command.";
            }
        }
         return "";
    }



    @Override
    public boolean exit() {
        return false;
    }
}
