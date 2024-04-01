package com.company.documents.model;

import java.nio.file.Path;

public class Document {
    private final String name;
    private final Path filePath;

    public Document(String name, Path filePath) {
        this.name = name;
        this.filePath = filePath;
    }

    public String name() {
        return name;
    }

    public Path filePath() {
        return filePath;
    }
}