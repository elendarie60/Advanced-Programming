import java.util.ArrayList;
import java.util.List;

class Problem {
    private List<Depot> depots = new ArrayList<>();
    private List<Truck> trucks = new ArrayList<>();
    private List<Drone> drones = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();

    public Problem() {
        this.depots = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.drones = new ArrayList<>();
        this.trucks = new ArrayList<>();
    }

    //methods to add depots,trucks,dones and clients
    public void addDepot(Depot depot) {
        if (!depots.contains(depot))
            depots.add(depot);
    }

    public void addTruck(Truck truck) {
        if (!trucks.contains(truck))
            trucks.add(truck);
    }

    public void addDrone(Drone drone) {
        if (!drones.contains(drone))
            drones.add(drone);
    }

    public void addClient(Client client) {
        if (!clients.contains(client))
            clients.add(client);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    // method to get all vehicles from all depots
    public Vehicle[] getVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.addAll(trucks);
        vehicles.addAll(drones);
        return vehicles.toArray(new Vehicle[0]);
    }
}
