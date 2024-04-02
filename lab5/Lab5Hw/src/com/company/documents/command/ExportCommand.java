package com.company.documents.command;

import java.io.FileWriter;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExportCommand implements Command {
    private DocumentRepository repository;

    public ExportCommand(DocumentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(repository);
            FileWriter writer = new FileWriter("repository.json");
            writer.write(json);
            writer.close();
            System.out.println("Repository exported to repository.json successfully.");
        } catch (IOException e) {
            System.out.println("Error exporting repository: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
