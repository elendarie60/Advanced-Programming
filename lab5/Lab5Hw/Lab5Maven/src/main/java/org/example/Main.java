package org.example;
package com.company.documents.model;

import com.company.documents.command.Command;
import com.company.documents.command.CommandFactory;
import com.company.documents.exception.InvalidCommandException;
import com.company.documents.repository.DocumentRepository;
import com.company.documents.exception.RepositoryAccessException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Main class for the application
public class Main {
    private static final String MASTER_DIRECTORY_PATH = "C:\\Program Files"; // Specify the master directory path

    public static void main(String[] args) {
        try {
            DocumentRepository repository = new DocumentRepository(MASTER_DIRECTORY_PATH);
            Shell shell = new Shell(repository);
            shell.start();
        } catch (RepositoryAccessException e) {
            System.out.println("Error initializing repository: " + e.getMessage());
        }
    }
}