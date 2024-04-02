package com.company.documents.shell;

// Interface for executing commands
public interface CommandExecutor {
    void execute(String commandName, String[] args) throws CommandExecutionException;
}

// Exception for command execution errors
class CommandExecutionException extends Exception {
    public CommandExecutionException(String message) {
        super(message);
    }
}
