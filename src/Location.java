public class Location {
    private Planet currentPlanet;

    public Location(Planet startPlanet) {
        if (startPlanet == null) {
            throw new IllegalArgumentException("Start planet cannot be null");
        }
        this.currentPlanet = startPlanet;
    }

    public void move(String destination) {
        if (currentPlanet != null && currentPlanet.canTravel(destination)) {
            currentPlanet = currentPlanet.connections.get(destination);
            System.out.println("Moved to " + currentPlanet.name);
        } else {
            System.out.println("You cant go there.");
        }
    }

    public String getCurrentLocation() {
        return currentPlanet.name;
    }
}

