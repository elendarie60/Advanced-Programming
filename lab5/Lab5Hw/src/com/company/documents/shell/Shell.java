package com.company.documents.shell;

import java.util.Scanner;

public class Shell {
    private final Scanner scanner;
    private final CommandExecutor commandExecutor;

    public Shell(CommandExecutor commandExecutor) {
        this.scanner = new Scanner(System.in);
        this.commandExecutor = commandExecutor;
    }

    // Method to start the shell
    public void start() {
        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }
            String[] tokens = input.split("\\s+");
            String commandName = tokens[0];
            String[] args = tokens.length > 1 ? tokens[1].split(",") : new String[0];
            try {
                commandExecutor.execute(commandName, args);
            } catch (CommandExecutionException e) {
                System.out.println("Error executing command: " + e.getMessage());
            }
        }
    }

    // Method to close the shell
    public void close() {
        scanner.close();
    }
}
