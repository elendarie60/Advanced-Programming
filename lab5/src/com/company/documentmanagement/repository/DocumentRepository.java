package com.company.documentmanagement.repository;

import java.io.File;
import java.util.Arrays;

public class DocumentRepository {

    private final File masterDirectory;

    public DocumentRepository(String masterDirectoryPath) {
        this.masterDirectory = new File(masterDirectoryPath);
    }

    public void displayRepositoryContent() {
        if (!masterDirectory.exists() || !masterDirectory.isDirectory()) {
            throw new RepositoryInitializationException("Error accessing repository", e);
        }

        String[] subDirectories = masterDirectory.list((dir, name) -> new File(dir, name).isDirectory());
        String[] files = masterDirectory.list((dir, name) -> new File(dir, name).isFile());

        System.out.println("sub directories:");
        if (subDirectories != null) {
            Arrays.stream(subDirectories).forEach(System.out::println);
        }

        System.out.println("\nFiles:");
        if (files != null) {
            Arrays.stream(files).forEach(System.out::println);
        }
    }
}