class Truck extends Vehicle {
    private int capacity;

    public Truck(String name, Depot depot, int capacity) {
        super(name, depot);
        this.capacity = capacity;
    }

    // getter and setter for capacity
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return "Truck";
    }
}
