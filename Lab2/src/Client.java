import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

enum ClientType{ REGULAR, PREMIUM}

class Client {
    private String name;
    private ClientType type;
    private int timeStart;
    private int timeEnd;

    public Client(String name, ClientType type, int timeStart, int timeEnd) {
        this.name = name;
        this.type = type;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
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

    public int timeStart() {
        return timeStart;
    }

    public void setTimeStart(int timeStart) {
        this.timeStart = timeStart;
    }

    public int getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(int timeEnd) {
        this.timeEnd = timeEnd;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return timeStart == client.timeStart &&
                timeEnd == client.timeEnd &&
                name.equals(client.name) &&
                type == client.type;
    }

    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", timeStart =" + timeStart +
                ", timeEnd =" + timeEnd +
                ", type=" + type +
                '}';
    }

    public int hashCode() {
        return Objects.hash(name, timeStart, timeEnd, type);
    }
}
