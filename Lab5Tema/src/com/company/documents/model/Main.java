package com.company.documents.model;

import com.company.documents.model.Person;
import com.company.documents.repository.DocumentRepository;
import com.company.documents.exception.RepositoryInitializationException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Specify the path to the master directory containing personal documents
            Path masterDirectory = Paths.get("C:\\Program Files");

            // Create a document repository
            DocumentRepository documentRepository = new DocumentRepository(masterDirectory);

            // List all persons in the repository
            List<Person> persons = documentRepository.listPersons();
            for (Person person : persons) {
                System.out.println("Person ID: " + person.id());
            }

            // List documents for the first person
            if (!persons.isEmpty()) {
                List<Document> documents = documentRepository.listDocuments(persons.get(0));
                for (Document document : documents) {
                    System.out.println("Document Name: " + document.name());
                }
            }
        } catch (RepositoryInitializationException e) {
            // Handle RepositoryInitializationException here
            System.err.println("Error initializing repository: " + e.getMessage());
            e.printStackTrace();
        }
    }
}