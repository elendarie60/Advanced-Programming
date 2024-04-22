public class TimeKeeper extends Thread {
    private final int timeLimit;
    private long startTime;

    public TimeKeeper(int timeLimit) {
        this.timeLimit = timeLimit;
        startTime = System.currentTimeMillis();
        setDaemon(true);
    }

    public void run() {
        while (true) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            if (elapsedTime >= timeLimit) {
                System.out.println("Game over");
                System.exit(0);
            }
            try {
                Thread.sleep(1000); // Check every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
