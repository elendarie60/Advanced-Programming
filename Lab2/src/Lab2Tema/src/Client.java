class Client {
    private String name;
    private ClientType type;
    private int arrivalTimeStart;
    private int arrivalTimeEnd;

    public Client(String name, ClientType type, int arrivalTimeStart, int arrivalTimeEnd) {
        this.name = name;
        this.type = type;
        this.arrivalTimeStart = arrivalTimeStart;
        this.arrivalTimeEnd = arrivalTimeEnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }

    public int getArrivalTimeStart() {
        return arrivalTimeStart;
    }

    public void setArrivalTimeStart(int arrivalTimeStart) {
        this.arrivalTimeStart = arrivalTimeStart;
    }

    public int getArrivalTimeEnd() {
        return arrivalTimeEnd;
    }

    public void setArrivalTimeEnd(int arrivalTimeEnd) {
        this.arrivalTimeEnd = arrivalTimeEnd;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Client client = (Client) obj;
        return name.equals(client.name);
    }


    public String toString() {
        return "Client{" + "name='" + name + '\'' + ", type=" + type + ", arrivalTimeStart=" + arrivalTimeStart +
                ", arrivalTimeEnd=" + arrivalTimeEnd + '}';
    }
}

enum ClientType {
    REGULAR, PREMIUM
}
