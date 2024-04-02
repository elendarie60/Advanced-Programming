package com.company.documents.command;
import java.util.HashMap;
import java.util.Map;
import com.company.documents.exception.InvalidCommandException;
import com.company.documents.repository.DocumentRepository;
import com.company.documents.exception.RepositoryAccessException;

public class CommandFactory {
    private static final
    Map<String, Command> commands = new HashMap<>();

    static {
        commands.put("view", new ViewCommand());
        commands.put("report", new ReportCommand());
        commands.put("export", new ExportCommand());
        commands.put("list", new ListPersonsCommand(repository)); // Add list command
    }

    //methos by name
    public static Command getCommand(String commandName) throws InvalidCommandException {
        Command command = commands.get(commandName);
        if (command == null) {
            throw new InvalidCommandException("Invalid command: " + commandName);
        }
        return command;
    }
}
