class Drone extends Vehicle {
    private int maxFlightDuration;

    public Drone(String id, Depot depot, int maxFlightDuration) {
        super(id, depot);
        this.maxFlightDuration = maxFlightDuration;
    }

    public String getVehicleType() {
        return "Drone";
    }

    public int getMaxFlightDuration() {
        return maxFlightDuration;
    }

    public void setMaxFlightDuration(int maxFlightDuration) {
        this.maxFlightDuration = maxFlightDuration;
    }
}