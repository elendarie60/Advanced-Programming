package com.company.documents.shell;

import com.company.documents.command.Command;
import com.company.documents.command.CommandFactory;

import java.util.Scanner;

public class ShellInterface {
    private final CommandFactory commandFactory;

    public ShellInterface(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting shell.");
                break;
            }

            executeCommand(input);
        }
    }

    private void executeCommand(String input) {
        Command command = commandFactory.createCommand(input);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Invalid command.");
        }
    }
}
