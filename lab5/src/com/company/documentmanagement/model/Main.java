package com.company.documentmanagement.model;

import com.company.documentmanagement.exception.RepositoryInitializationException;
import com.company.documentmanagement.repository.DocumentRepository;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

     try {
        var p = new Person(1001, "Popescu"); //generated constructor
        System.out.println(p); //toString implementation
        System.out.println(p.name()); //accesor method

        Path masterDirectory = Paths.get("C\\Users\\sweet\\Documents");

        DocumentRepository documentRepository = new DocumentRepository(masterDirectory);

        List<Person> persons = documentRepository.listPersons();
        for (Person person : persons) {
            System.out.println("Person ID: " + person.id());
        }

        if (!persons.isEmpty()) {
            List<Document> documents = documentRepository.listDocuments(persons.get(0));
            for (Document document : documents) {
                System.out.println("Document Name: " + document.name());
            }
        }
    } catch(RepositoryInitializationException(Exception e)) {

        System.err.println("Error initializing repository: ";
    }
}
