public class FlyCommand extends Command{


    private Location location;
    private String destination;

    public FlyCommand(Location location) {
        this.location = location;
    }


    @Override
    public String execute() {
        if (super.command == null || super.command.isEmpty()) {
            return "Please enter a destination planet.";
        }
        boolean success = location.move(super.command.trim());

        return success ? "" : "Invalid travel command.";
    }


    @Override
    public boolean exit() {
        return false;
    }
}
