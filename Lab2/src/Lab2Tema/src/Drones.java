class Drone extends Vehicle {
    private int maxFlightDuration;

    public Drone(String name, Depot depot, int maxFlightDuration) {
        super(name, depot);
        this.maxFlightDuration = maxFlightDuration;
    }

    // getter and setter for maxFlightDuration
    public int getMaxFlightDuration() {
        return maxFlightDuration;
    }

    public void setMaxFlightDuration(int maxFlightDuration) {
        this.maxFlightDuration = maxFlightDuration;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Depot depot = (Depot) obj;
        return name.equals(depot.name);
    }

    //getType method
    public String toString() {
        return "Depot{" +
                "name='" + name + '\'' +
                '}';
    }
}
