import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameServer server = new GameServer(1234);
        server.start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Command: (create <gameId>, join <gameId> <playerName>, submit <gameId> <x> <y>, exit)");
            String input = scanner.nextLine();
            String[] command = input.split(" ");
            switch (command[0]) {
                case "create":
                    handleCreateGame(server, command);
                    break;
                case "join":
                    handleJoinGame(server, command);
                    break;
                case "submit":
                    handleSubmitMove(server, command);
                    break;
                case "exit":
                    server.stop();
                    System.out.println("Server stopped.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Unknown command: " + command[0]);
            }
        }
    }

    private static void handleCreateGame(GameServer server, String[] command) {
        if (command.length != 2) {
            System.out.println("Invalid command format. Usage: create <gameId>");
            return;
        }
        String gameId = command[1];
        server.createGame(gameId);
        System.out.println("Game created: " + gameId);
    }

    private static void handleJoinGame(GameServer server, String[] command) {
        if (command.length != 3) {
            System.out.println("Invalid command format. Usage: join <gameId> <playerName>");
            return;
        }
        String gameId = command[1];
        String playerName = command[2];
        server.joinGame(gameId, playerName);
        System.out.println(playerName + " joined game: " + gameId);
    }

    private static void handleSubmitMove(GameServer server, String[] command) {
        if (command.length != 5) {
            System.out.println("Invalid command format. Usage: submit <gameId> <playerName> <x> <y>");
            return;
        }
        String gameId = command[1];
        String playerName = command[2];
        int x, y;
        try {
            x = Integer.parseInt(command[3]);
            y = Integer.parseInt(command[4]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid coordinates. Please provide integers for x and y.");
            return;
        }
        server.submitMove(gameId, playerName, x, y);
        System.out.println("Move submitted for game: " + gameId);
    }
}