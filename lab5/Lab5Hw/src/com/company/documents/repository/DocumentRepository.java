package com.company.documents.repository;

import com.company.documents.exception.RepositoryAccessException;
import com.company.documents.exception.RepositoryInitializationException;
import com.company.documents.model.Document;
import com.company.documents.model.Person;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class DocumentRepository {
    private final Path repositoryPath;

    public DocumentRepository(Path repositoryPath) {
        if (!Files.exists(repositoryPath) || !Files.isDirectory(repositoryPath)) {
            throw new RepositoryInitializationException("Master directory does not exist: " + repositoryPath);
        }
        this.repositoryPath = repositoryPath;
    }

    public List<Person> listPersons() {
        try {
            return Files.list(repositoryPath)
                    .filter(Files::isDirectory)
                    .map(path -> new Person(path.getFileName().toString(), ""))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RepositoryAccessException("Error accessing repository", e);
        }
    }

    public List<Document> listDocuments(Person person) {
        try {
            Path personDireDrawctory = repositoryPath.resolve(person.id());
            return Files.list(personDirectory)
                    .filter(Files::isRegularFile)
                    .map(path -> new Document(path.getFileName().toString(), path))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RepositoryAccessException("Error accessing documents for person: " + person.id(), e);
        }
    }
}