import java.util.Objects;

abstract class Vehicle {
    private String name;
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
    public abstract String getVehicleType();

    //  equals method
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return name.equals(vehicle.name) && depot.equals(vehicle.depot);
    }

    public int hashCode() {
        return Objects.hash(name, depot);
    }
    public String toString() {
        return "Vehicle{" + "name='" +
                name + '\'' + ", depot=" + depot +
                '}';
    }
}

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public String toString() {
        return "Vehicle{" + "name='" + name + '\'' + ", depot=" + depot + '}';
    }
}
