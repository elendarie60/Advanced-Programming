class Client {
    public String name;
    public ClientType type;

    public Client(String name, ClientType type) {
        this.name = name;
        this.type = type;
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

    public String toString() {
        return "Client{" + "name='" + name + '\'' + ", type=" + type + '}';
    }
}

enum ClientType {
    REGULAR, PREMIUM
}
