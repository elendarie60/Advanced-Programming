abstract class Vehicle {
    public String name;
    private Depot depot;

    public Vehicle(String name, Depot depot) {
        this.name = name;
        this.depot = depot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    // abstract method
    public abstract String getType();

    //  equals method
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Vehicle vehicle = (Vehicle) obj;
        return name.equals(vehicle.name);
    }

    public String toString() {
        return "Vehicle{" + "name='" +
                name + '\'' + ", depot=" + depot +
                '}';
    }
}
