public class Location {
    private Planet currentPlanet;

    public Location(Planet startPlanet) {
        if (startPlanet == null) {
            throw new IllegalArgumentException("Start planet cannot be null");
        }
        this.currentPlanet = startPlanet;
    }

    public boolean move(String destination) {
        if (destination == null || destination.isEmpty()) {
            System.out.println("Invalid destination.");
            return false;
        }

        String formattedDestination = destination.substring(0, 1).toUpperCase() + destination.substring(1).toLowerCase();

        if (formattedDestination.equals(currentPlanet.name)) {
            System.out.println("You are already on " + currentPlanet.name + ".");
            return true;
        }

        if (currentPlanet.connections.containsKey(formattedDestination)) {
            currentPlanet = currentPlanet.connections.get(formattedDestination);
            System.out.println("Flying to " + formattedDestination + "...");
            System.out.println("You are now on " + currentPlanet.name + ".");
            return true;
        } else {
            System.out.println("You can't travel to " + formattedDestination + ".");
            return false;
        }
    }


    public String getCurrentLocation() {
        return currentPlanet.name;
    }
}

