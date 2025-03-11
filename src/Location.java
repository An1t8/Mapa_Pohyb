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
            return false;
        }

        String formattedDestination = destination.substring(0, 1).toUpperCase() + destination.substring(1).toLowerCase();

        if (formattedDestination.equals(currentPlanet.name)) {
            return true;
        }

        if (currentPlanet.connections.containsKey(formattedDestination)) {
            currentPlanet = currentPlanet.connections.get(formattedDestination);
            return true;

        } else {

            return false;
        }
    }

    public String getCurrentLocation() {
        return currentPlanet.name;
    }


    public Planet getCurrentPlanet() {
        return currentPlanet;
    }



}

