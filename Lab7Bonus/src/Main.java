import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        int n = 5; // Number of distinct pairs of numbers
        Bag bag = new Bag(n);
        SmartPlayer player1 = new SmartPlayer("Player 1", bag, n);
        SmartPlayer player2 = new SmartPlayer("Player 2", bag, n);
        SmartPlayer player3 = new SmartPlayer("Player 3", bag, n);

        player1.start();
        player2.start();
        player3.start();

        try {
            player1.join();
            player2.join();
            player3.join();
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "Interrupted while waiting for players to finish", e);
        }

        logger.info("Game over!");

        // Example graph for Ore's condition and Hamiltonian cycle
        int[][] graph = {
                {0, 1, 1, 1, 0},
                {1, 0, 1, 0, 1},
                {1, 1, 0, 1, 1},
                {1, 0, 1, 0, 1},
                {0, 1, 1, 1, 0}
        };

        if (OreConditionChecker.satisfiesOreCondition(graph)) {
            logger.info("Satisfies Ore's condition.");
        } else {
            logger.warning("Not satisfy Ore's condition.");
        }

        if (OreConditionChecker.hasHamiltonianCycle(graph)) {
            logger.info("Hamiltonian cycle.");
        } else {
            logger.warning("No Hamiltonian cycle.");
        }
    }
}