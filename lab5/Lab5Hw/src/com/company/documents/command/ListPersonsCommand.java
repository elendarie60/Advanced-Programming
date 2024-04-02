package com.company.documents.command;

import com.company.documents.exception.InvalidCommandException;
import com.company.documents.repository.DocumentRepository;
import com.company.documents.exception.RepositoryAccessException;

// Command to list persons in the repository
class ListPersonsCommand implements Command {
    private final DocumentRepository repository;

    public ListPersonsCommand(DocumentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() throws InvalidCommandException {
        try {
            repository.listPersons();
        } catch (RepositoryAccessException e) {
            throw new InvalidCommandException("Error accessing repository: " + e.getMessage());
        }
    }
}
