public class Player {
    private String name;
    private int timeRemaining;

    public Player(String name) {
        this.name = name;
        this.timeRemaining = 60; // 60 seconds initial time per player (adjust as needed)
    }
}