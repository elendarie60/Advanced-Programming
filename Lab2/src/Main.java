import java.lang.NullPointerException;

public class Main {
    public static void main(String[] args) {
        
       //create depots,trucks,drones
        Depot depot1 = new Depot("Depot A");
        Depot depot2 = new Depot("Depot B");

        Truck truck1 = new Truck("Truck 1", depot1, 1000);
        Truck truck2 = new Truck("Truck 2", depot2, 1500);

        Drone drone1 = new Drone("Drone 1", depot1, 60);
        Drone drone2 = new Drone("Drone 2", depot2, 90);

        Client client1 = new Client("Client 1", ClientType.REGULAR, 8, 10);
        Client client2 = new Client("Client 2", ClientType.PREMIUM, 9, 12);
        
        System.out.println(client1);
        System.out.println(client2);

        // objects and problem instance
        System.out.println(depot1);
        System.out.println(depot2);
        System.out.println(truck1);
        System.out.println(truck2);
        System.out.println(drone1);
        System.out.println(drone2);
        System.out.println(client1);
        System.out.println(client2);

        Problem problem = new Problem();
        problem.addClient(client1);
        problem.addClient(client2);
    }
}
